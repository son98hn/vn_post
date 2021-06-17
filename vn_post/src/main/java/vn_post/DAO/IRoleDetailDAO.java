package vn_post.DAO;

import java.util.List;

import vn_post.model.RoleDetailModel;
import vn_post.paging.Pageble;

public interface IRoleDetailDAO extends GenericDAO<RoleDetailModel> {
	List<RoleDetailModel> findAll(Pageble pageble);
	List<RoleDetailModel> findAllItem();
	List<RoleDetailModel> find(long id);
	RoleDetailModel findOneByRoleId(Long roleId);
	RoleDetailModel findOneByCode(String code);
	Long save(RoleDetailModel roleDetailModel);
	void update(RoleDetailModel updateRoleDetail);
	void delete(long id);
	RoleDetailModel findOne(long id);
	RoleDetailModel findOneByPermission(String permission);
	int getTotalItem();
	List<RoleDetailModel> getRoleByUserName(String userName);
	List<RoleDetailModel> getRoleByGroupRoleId(Long groupRoleId);
	List<RoleDetailModel> getRoleByRoleId(Long roleId);
	void deleteByRoleId(long roleId);
}
