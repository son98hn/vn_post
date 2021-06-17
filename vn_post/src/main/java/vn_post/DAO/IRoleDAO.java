package vn_post.DAO;

import java.util.List;

import vn_post.model.RoleModel;
import vn_post.paging.Pageble;

public interface IRoleDAO extends GenericDAO<RoleModel>{
	
	RoleModel findOne(long id);
	List<RoleModel> findAllItem();
	int getTotalItem();
	RoleModel findOneByCode(String code);
	Long save(RoleModel roleModel);
	void update(RoleModel updateRole);
	void delete(long id);
	List<RoleModel> getRoleDetailById(Long id);
	List<RoleModel> findAll(Pageble pageble);
}
