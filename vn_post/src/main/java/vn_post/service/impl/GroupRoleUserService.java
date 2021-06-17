package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.IGroupRoleUserDAO;
import vn_post.model.GroupRoleUserModel;
import vn_post.paging.Pageble;
import vn_post.service.IGroupRoleUserService;

public class GroupRoleUserService implements IGroupRoleUserService {

	@Inject
	private IGroupRoleUserDAO groupRoleUserDao;

	@Override
	public int getTotalItem() {
		return groupRoleUserDao.getTotalItem();
	}

	@Override
	public List<GroupRoleUserModel> findAllItem() {
		return groupRoleUserDao.findAllItem();
	}
	@Override
	public List<GroupRoleUserModel> findAll(Pageble pageble) {
		return groupRoleUserDao.findAll(pageble);
	}

	@Override
	public GroupRoleUserModel findOneByUserId(long userId) {
		return groupRoleUserDao.findOneByUserId(userId);
	}

	@Override
	public GroupRoleUserModel findOne(long id) {
		GroupRoleUserModel groupRoleUserModel = groupRoleUserDao.findOne(id);
		return groupRoleUserModel;
	}

	@Override
	public GroupRoleUserModel save(GroupRoleUserModel groupRoleUserModel) {
		Long groupRoleUserId = groupRoleUserDao.save(groupRoleUserModel);
		return groupRoleUserDao.findOne(groupRoleUserId);
	}

	@Override
	public GroupRoleUserModel update(GroupRoleUserModel updateGroupRoleUser) {
		groupRoleUserDao.update(updateGroupRoleUser);
		return groupRoleUserDao.findOne(updateGroupRoleUser.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			groupRoleUserDao.delete(id);
		}
	}

}
