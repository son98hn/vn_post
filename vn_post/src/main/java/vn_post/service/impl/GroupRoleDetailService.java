package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.IGroupRoleDetailDAO;
import vn_post.model.GroupRoleDetailModel;
import vn_post.paging.Pageble;
import vn_post.service.IGroupRoleDetailService;

public class GroupRoleDetailService implements IGroupRoleDetailService {

	@Inject
	private IGroupRoleDetailDAO groupRoleDetailDao;

	@Override
	public int getTotalItem() {
		return groupRoleDetailDao.getTotalItem();
	}

	@Override
	public List<GroupRoleDetailModel> findAllItem() {
		return groupRoleDetailDao.findAllItem();
	}
	@Override
	public List<GroupRoleDetailModel> findAll(Pageble pageble) {
		return groupRoleDetailDao.findAll(pageble);
	}
	@Override
	public void deleteByGroupRoleId(long groupRoleId) {
		groupRoleDetailDao.deleteByGroupRoleId(groupRoleId);

	}
	@Override
	public GroupRoleDetailModel findOneByGroupRoleId(long groupRoleId) {
		return groupRoleDetailDao.findOneByGroupRoleId(groupRoleId);
	}
	@Override
	public List<GroupRoleDetailModel> findByGroupRoleId(long groupRoleId) {
		List<GroupRoleDetailModel> groupRoleDetailModel = groupRoleDetailDao.findByGroupRoleId(groupRoleId);
		return groupRoleDetailModel;
	}

	@Override
	public GroupRoleDetailModel findOne(long id) {
		GroupRoleDetailModel groupRoleDetailModel = groupRoleDetailDao.findOne(id);
		return groupRoleDetailModel;
	}

	@Override
	public GroupRoleDetailModel save(GroupRoleDetailModel groupRoleDetailModel) {
		Long groupRoleDetailId = groupRoleDetailDao.save(groupRoleDetailModel);
		return groupRoleDetailDao.findOne(groupRoleDetailId);
	}

	@Override
	public GroupRoleDetailModel update(GroupRoleDetailModel updateGroupRoleDetail) {
		groupRoleDetailDao.update(updateGroupRoleDetail);
		return groupRoleDetailDao.findOne(updateGroupRoleDetail.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			groupRoleDetailDao.delete(id);
		}
	}

}
