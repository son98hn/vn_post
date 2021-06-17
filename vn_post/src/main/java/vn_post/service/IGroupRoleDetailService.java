package vn_post.service;

import java.util.List;

import vn_post.model.GroupRoleDetailModel;
import vn_post.paging.Pageble;

public interface IGroupRoleDetailService {
	List<GroupRoleDetailModel> findByGroupRoleId(long groupRoleId);
	GroupRoleDetailModel findOneByGroupRoleId(long groupRoleId);
	GroupRoleDetailModel save(GroupRoleDetailModel groupRoleDetailModel);
	GroupRoleDetailModel update(GroupRoleDetailModel updateGroupRoleDetail);	
	void delete(long [] ids);
	GroupRoleDetailModel findOne(long id);
	int getTotalItem();
	void deleteByGroupRoleId(long groupRoleId);
	List<GroupRoleDetailModel> findAll(Pageble pageble);
	List<GroupRoleDetailModel> findAllItem();
}
