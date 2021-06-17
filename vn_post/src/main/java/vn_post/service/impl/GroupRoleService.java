package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.IGroupRoleDAO;
import vn_post.DAO.IGroupRoleDetailDAO;
import vn_post.model.GroupRoleDetailModel;
import vn_post.model.GroupRoleModel;
import vn_post.model.RoleDetailModel;
import vn_post.paging.Pageble;
import vn_post.service.IGroupRoleDetailService;
import vn_post.service.IGroupRoleService;
import vn_post.service.IRoleDetailService;

public class GroupRoleService implements IGroupRoleService {

	@Inject
	private IGroupRoleDAO groupRoleDao;

	@Inject
	private IGroupRoleDetailDAO groupRoleDetailDao;

	@Inject
	private IGroupRoleDetailService groupRoleDetailService;

	@Inject
	private IRoleDetailService roleDetailService;

	@Override
	public int getTotalItem() {
		return groupRoleDao.getTotalItem();
	}

	@Override
	public List<GroupRoleModel> findAllItem() {
		return groupRoleDao.findAllItem();
	}

	@Override
	public List<GroupRoleModel> findAll(Pageble pageble) {
		return groupRoleDao.findAll(pageble);
	}

	@Override
	public List<GroupRoleModel> getRoleByUserName(String userName) {
		return groupRoleDao.getRoleByUserName(userName);
	}

	@Override
	public GroupRoleModel findOneByCode(String code) {
		return groupRoleDao.findOneByCode(code);
	}

	@Override
	public GroupRoleModel findOne(long id) {
		GroupRoleModel groupRoleModel = groupRoleDao.findOne(id);
		return groupRoleModel;
	}

	@Override
	public GroupRoleModel save(GroupRoleModel groupRoleModel) {
		Long groupRoleId = groupRoleDao.save(groupRoleModel);
		for (int i = 0; i < groupRoleModel.getListStringRoleDetailName().size(); i++) {
			String roleDetail_str = groupRoleModel.getListStringRoleDetailName().get(i);
			RoleDetailModel roleDetail = roleDetailService.findOneByPermission(roleDetail_str);
			GroupRoleDetailModel groupRoleDetail = new GroupRoleDetailModel();
			groupRoleDetail.setGroupRoleId(groupRoleId);
			groupRoleDetail.setRoleDetailId(roleDetail.getId());
			groupRoleDetailDao.save(groupRoleDetail);
		}
		return groupRoleDao.findOne(groupRoleId);
	}

	@Override
	public GroupRoleModel update(GroupRoleModel updateGroupRole) {
		groupRoleDao.update(updateGroupRole);
		groupRoleDetailService.deleteByGroupRoleId(updateGroupRole.getId());
		for (int i = 0; i < updateGroupRole.getListStringRoleDetailName().size(); i++) {
			String roleDetail_str = updateGroupRole.getListStringRoleDetailName().get(i);
			RoleDetailModel roleDetail = roleDetailService.findOneByPermission(roleDetail_str);
			GroupRoleDetailModel groupRoleDetail = new GroupRoleDetailModel();
			groupRoleDetail.setGroupRoleId(updateGroupRole.getId());
			groupRoleDetail.setRoleDetailId(roleDetail.getId());
			groupRoleDetailDao.save(groupRoleDetail);
		}
		return groupRoleDao.findOne(updateGroupRole.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			GroupRoleModel groupRole = groupRoleDao.findOne(id);
			groupRoleDetailDao.deleteByGroupRoleId(groupRole.getId());
			groupRoleDao.delete(id);
		}
	}

	@Override
	public List<GroupRoleModel> getGroupRoleByUserName(String userName) {
		return groupRoleDao.getGroupRoleByUserName(userName);
	}
}
