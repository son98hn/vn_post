package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.IRoleDAO;
import vn_post.DAO.IRoleDetailDAO;
import vn_post.model.RoleDetailModel;
import vn_post.model.RoleModel;
import vn_post.paging.Pageble;
import vn_post.service.IRoleDetailService;

public class RoleDetailService implements IRoleDetailService {
	
	@Inject
	private IRoleDetailDAO roleDetailDao;
	
	@Inject
	private IRoleDAO roleDao;

	@Override
	public void deleteByRoleId(long roleId) {
		roleDetailDao.deleteByRoleId(roleId);

	}
	@Override
	public int getTotalItem() {
		return roleDetailDao.getTotalItem();
	}
	@Override
	public List<RoleDetailModel> findAllItem() {
		return roleDetailDao.findAllItem();
	}
	@Override
	public List<RoleDetailModel> findAll(Pageble pageble) {
		return roleDetailDao.findAll(pageble);
	}
	@Override
	public List<RoleDetailModel> find(long id) {
		return roleDetailDao.find(id);
	}
	@Override
	public RoleDetailModel findOneByCode(String code) {
		// TODO Auto-generated method stub
		return roleDetailDao.findOneByCode(code);
	}
	
	@Override
	public RoleDetailModel findOneByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return roleDetailDao.findOneByRoleId(roleId);
	}

	@Override
	public RoleDetailModel findOne(long id) {
		RoleDetailModel roleDetailModel = roleDetailDao.findOne(id);
		RoleModel roleModel = roleDao.findOne(roleDetailModel.getRoleId());
		roleDetailModel.setRoleId(roleModel.getId());
		return roleDetailModel;
	}
	
	@Override
	public RoleDetailModel findOneByPermission(String permission) {
		RoleDetailModel roleDetailModel = roleDetailDao.findOneByPermission(permission);
		RoleModel roleModel = roleDao.findOne(roleDetailModel.getRoleId());
		roleDetailModel.setRoleId(roleModel.getId());
		return roleDetailModel;
	}
	@Override
	public RoleDetailModel save(RoleDetailModel roleDetailModel) {
		Long roleDetailId = roleDetailDao.save(roleDetailModel);
		return roleDetailDao.findOne(roleDetailId);
	}

	@Override
	public RoleDetailModel update(RoleDetailModel updateRoleDetail) {
		roleDetailDao.update(updateRoleDetail);
		return roleDetailDao.findOne(updateRoleDetail.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			roleDetailDao.delete(id);
		}
	}
	
	@Override
	public List<RoleDetailModel> getRoleByUserName(String userName) {
		List<RoleDetailModel> roleDetail = roleDetailDao.getRoleByUserName(userName);
		return roleDetail;
	}
	
	@Override
	public List<RoleDetailModel> getRoleByGroupRoleId(Long groupRoleId) {
		List<RoleDetailModel> roleDetail = roleDetailDao.getRoleByGroupRoleId(groupRoleId);
		return roleDetail;
	}
	
	@Override
	public List<RoleDetailModel> getRoleByRoleId(Long roleId) {
		List<RoleDetailModel> roleDetail = roleDetailDao.getRoleByRoleId(roleId);
		return roleDetail;
	}
}
