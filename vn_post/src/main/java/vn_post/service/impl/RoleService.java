package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.IRoleDAO;
import vn_post.DAO.IRoleDetailDAO;
import vn_post.model.RoleModel;
import vn_post.paging.Pageble;
import vn_post.service.IRoleService;

public class RoleService implements IRoleService {

	@Inject
	private IRoleDAO roleDao;


	@Inject
	private IRoleDetailDAO roleDetailDao;

	
	@Override
	public List<RoleModel> findAllItem() {
		return roleDao.findAllItem();
	}
	@Override
	public List<RoleModel> findAll(Pageble pageble) {
		return roleDao.findAll(pageble);
	}

	@Override
	public RoleModel findOne(long id) {
		RoleModel roleModel = roleDao.findOne(id);
		return roleModel;
	}

	@Override
	public int getTotalItem() {
		return roleDao.getTotalItem();
	}

	@Override
	public RoleModel save(RoleModel roleModel) {
		Long roleId = roleDao.save(roleModel);
		return roleDao.findOne(roleId);
	}

	@Override
	public RoleModel update(RoleModel updateRole) {
		roleDao.update(updateRole);
		return roleDao.findOne(updateRole.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
				roleDao.findOne(id);
				roleDetailDao.deleteByRoleId(id);
				roleDao.delete(id);
		}
	}

	@Override
	public List<RoleModel> getRoleDetailById(Long id) {
		List<RoleModel> role = roleDao.getRoleDetailById(id);
		return role;
	}
}
