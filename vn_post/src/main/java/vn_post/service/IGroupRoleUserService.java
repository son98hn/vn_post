package vn_post.service;

import java.util.List;

import vn_post.model.GroupRoleUserModel;
import vn_post.paging.Pageble;

public interface IGroupRoleUserService {
	List<GroupRoleUserModel> findAll(Pageble pageble);
	List<GroupRoleUserModel> findAllItem();
	GroupRoleUserModel findOneByUserId(long userId);
	GroupRoleUserModel save(GroupRoleUserModel groupRoleUserModel);
	GroupRoleUserModel update(GroupRoleUserModel updateGroupRoleUser);
	void delete(long [] ids);
	GroupRoleUserModel findOne(long id);
	int getTotalItem();
}
