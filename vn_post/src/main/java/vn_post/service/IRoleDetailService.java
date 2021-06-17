package vn_post.service;

import java.util.List;

import vn_post.model.RoleDetailModel;
import vn_post.paging.Pageble;

public interface IRoleDetailService {
	List<RoleDetailModel> findAllItem();
	List<RoleDetailModel> find(long id);
	RoleDetailModel findOneByCode(String code);
	RoleDetailModel findOneByRoleId(Long roleId);
	RoleDetailModel save(RoleDetailModel roleDetailModel);
	RoleDetailModel update(RoleDetailModel updateRoleDetail);
	void delete(long [] ids);
	RoleDetailModel findOne(long id);
	RoleDetailModel findOneByPermission(String permission);
	int getTotalItem();
	List<RoleDetailModel> getRoleByUserName( String userName);
	List<RoleDetailModel> getRoleByGroupRoleId( Long groupRoleId);
	List<RoleDetailModel> findAll(Pageble pageble);
	List<RoleDetailModel> getRoleByRoleId( Long roleId);
	void deleteByRoleId(long roleId);
}
