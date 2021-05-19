package vn_post.DAO;

import java.util.List;

import vn_post.model.RoleModel;

public interface IRoleDAO extends GenericDAO<RoleModel>{
	
	RoleModel findOne(long id);

	List<RoleModel> findAll();
	
	RoleModel findOneByCode(String code);
}
