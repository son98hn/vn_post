package vn_post.service;

import java.util.List;

import vn_post.model.RoleModel;
import vn_post.paging.Pageble;

public interface IRoleService {
	
	RoleModel findOne(long id);
	int getTotalItem();
	RoleModel save(RoleModel roleModel);
	RoleModel update(RoleModel updateRole);
	void delete(long [] ids);
	List<RoleModel> getRoleDetailById( Long id);
	List<RoleModel> findAll(Pageble pageble);
	List<RoleModel> findAllItem();
}
