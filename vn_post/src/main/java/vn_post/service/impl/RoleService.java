package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.IRoleDAO;
import vn_post.model.RoleModel;
import vn_post.service.IRoleService;

public class RoleService implements IRoleService {
	
	@Inject
	private IRoleDAO roleDAO;

	@Override
	public List<RoleModel> findAll() {
		return roleDAO.findAll();
	}

	@Override
	public RoleModel findOne(long id) {
		
		return roleDAO.findOne(id);
	}
}
