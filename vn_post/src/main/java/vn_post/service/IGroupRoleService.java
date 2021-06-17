package vn_post.service;

import java.util.List;

import vn_post.model.GroupRoleModel;
import vn_post.paging.Pageble;

public interface IGroupRoleService {
	List<GroupRoleModel> findAllItem();
	List<GroupRoleModel> findAll(Pageble pageble);
	GroupRoleModel findOneByCode(String code);
	GroupRoleModel save(GroupRoleModel groupRoleModel);
	GroupRoleModel update(GroupRoleModel updateGroupRole);
	void delete(long [] ids);
	GroupRoleModel findOne(long id);
	int getTotalItem();
	List<GroupRoleModel> getRoleByUserName(String userName);
	List<GroupRoleModel> getGroupRoleByUserName( String userName);
}
