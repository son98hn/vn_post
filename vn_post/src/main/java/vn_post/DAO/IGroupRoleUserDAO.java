package vn_post.DAO;

import java.util.List;

import vn_post.model.GroupRoleUserModel;
import vn_post.paging.Pageble;

public interface IGroupRoleUserDAO extends GenericDAO<GroupRoleUserModel>{
	
	GroupRoleUserModel findOne(long id);
	List<GroupRoleUserModel> findAllItem();
	int getTotalItem();
	GroupRoleUserModel findOneByUserId(long userId);
	Long save(GroupRoleUserModel groupRoleUserModel);
	void update(GroupRoleUserModel updateGroupRoleUser);
	void delete(long id);
	GroupRoleUserModel findOneByGroupRoleId(long groupRoleId);
	void deleteByUserId(long userId);
	List<GroupRoleUserModel> findAll(Pageble pageble);
}
