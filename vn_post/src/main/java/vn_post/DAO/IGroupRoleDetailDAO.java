package vn_post.DAO;

import java.util.List;

import vn_post.model.GroupRoleDetailModel;
import vn_post.paging.Pageble;

public interface IGroupRoleDetailDAO extends GenericDAO<GroupRoleDetailModel>{
	
	GroupRoleDetailModel findOne(long id);
	List<GroupRoleDetailModel> findAllItem();
	int getTotalItem();
	List<GroupRoleDetailModel> findByGroupRoleId(long groupRoleId);
	GroupRoleDetailModel findOneByGroupRoleId(long groupRoleId);
	Long save(GroupRoleDetailModel groupRoleDetailModel);
	void update(GroupRoleDetailModel updateGroupRoleDetail);
	void delete(long id);
	void deleteByGroupRoleId(long groupRoleId);
	List<GroupRoleDetailModel> findAll(Pageble pageble);
}
