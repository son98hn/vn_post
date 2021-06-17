package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.IGroupRoleDAO;
import vn_post.DAO.IGroupRoleUserDAO;
import vn_post.DAO.IUserDAO;
import vn_post.model.GroupRoleModel;
import vn_post.model.GroupRoleUserModel;
import vn_post.model.UserModel;
import vn_post.paging.Pageble;
import vn_post.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDao;
	
	
	@Inject
	private IGroupRoleDAO groupRoleDao;
	
	@Inject
	private IGroupRoleUserDAO groupRoleUserDao;
	

	@Override
	public UserModel findByUserNameAndPassword(String userName, String password) {
		UserModel userModel = userDao.findByUserNameAndPassword(userName, password);
		GroupRoleUserModel groupRoleUser = groupRoleUserDao.findOneByUserId(userModel.getId());
		GroupRoleModel groupRole = groupRoleDao.findOne(groupRoleUser.getGroupRoleId());
		userModel.setGroupRoleCode(groupRole.getCode());
		return userModel;
	}

	@Override
	public List<UserModel> findAllItem() {
		return userDao.findAllItem();
	}
	@Override
	public List<UserModel> findAll(Pageble pageble) {
		return userDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return userDao.getTotalItem();
	}
	

	@Override
	public UserModel findOne(long id) {
		UserModel userModel = userDao.findOne(id);
		GroupRoleUserModel groupRoleUserModel = groupRoleUserDao.findOneByUserId(userModel.getId());
		GroupRoleModel groupRoleModel = groupRoleDao.findOne(groupRoleUserModel.getGroupRoleId());
		userModel.setGroupRoleCode(groupRoleModel.getCode());
		return userModel;
	}
	@Override
	public UserModel save(UserModel userModel) {
		Long userId = userDao.save(userModel);
		for (int i = 0; i < userModel.getGroupRoleName().size(); i++) {
			String groupRole_str = userModel.getGroupRoleName().get(i);
			GroupRoleModel groupRole = groupRoleDao.findOneByName(groupRole_str);
			GroupRoleUserModel groupRoleUser = new GroupRoleUserModel();
			groupRoleUser.setUserId(userId);
			groupRoleUser.setGroupRoleId(groupRole.getId());
			groupRoleUserDao.save(groupRoleUser);
		}
		return userDao.findOne(userId);
	}

	@Override
	public UserModel update(UserModel updateUser) {
		userDao.update(updateUser);
		groupRoleUserDao.deleteByUserId(updateUser.getId());
		for (int i = 0; i < updateUser.getGroupRoleName().size(); i++) {
			String groupRole_str = updateUser.getGroupRoleName().get(i);
			GroupRoleModel groupRole = groupRoleDao.findOneByName(groupRole_str);
			GroupRoleUserModel groupRoleUser = new GroupRoleUserModel();
			groupRoleUser.setUserId(updateUser.getId());
			groupRoleUser.setGroupRoleId(groupRole.getId());
			groupRoleUserDao.save(groupRoleUser);
		}
		return userDao.findOne(updateUser.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			UserModel userModel = userDao.findOne(id);
			groupRoleUserDao.deleteByUserId(userModel.getId());
			userDao.delete(id);
		}
	}

	@Override
	public List<UserModel> getRoleByUserName(String userName) {
		return userDao.getRoleByUserName(userName);
	}
		

}
