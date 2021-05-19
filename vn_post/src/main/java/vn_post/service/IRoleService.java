package vn_post.service;

import java.util.List;

import vn_post.model.RoleModel;

public interface IRoleService {
	List<RoleModel> findAll();
	RoleModel findOne(long id);
}
