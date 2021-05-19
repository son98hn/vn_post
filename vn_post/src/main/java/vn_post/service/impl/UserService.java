package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.IRoleDAO;
import vn_post.DAO.IUserDAO;
import vn_post.model.RoleModel;
import vn_post.model.UserModel;
import vn_post.paging.Pageble;
import vn_post.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDao;
	
	@Inject
	private IRoleDAO roleDao;
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDao.findByUserNameAndPasswordAndStatus(userName, password, status);
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
		RoleModel roleModel = roleDao.findOne(userModel.getRoleId());
		userModel.setRoleId(roleModel.getId());
		return userModel;
	}
	@Override
	public UserModel save(UserModel userModel) {
		
		RoleModel role = roleDao.findOneByCode(userModel.getRoleCode());
		userModel.setRoleId(role.getId());
		Long userId = userDao.save(userModel);
		return userDao.findOne(userId);
	}

	@Override
	public UserModel update(UserModel updateUser) {
		RoleModel role = roleDao.findOneByCode(updateUser.getRoleCode());
		updateUser.setRoleId(role.getId());
		userDao.update(updateUser);
		return userDao.findOne(updateUser.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			userDao.delete(id);
		}
	}

}
