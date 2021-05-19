package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.IRoleDetailDAO;
import vn_post.model.RoleDetailModel;
import vn_post.service.IRoleDetailService;

public class RoleDetailService implements IRoleDetailService {
	
	@Inject
	private IRoleDetailDAO roleDetailDAO;

	@Override
	public List<RoleDetailModel> findAll() {
		return roleDetailDAO.findAll();
	}

	
}
