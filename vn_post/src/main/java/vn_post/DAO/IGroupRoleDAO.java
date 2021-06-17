package vn_post.DAO;

import java.util.List;

import vn_post.model.GroupRoleModel;
import vn_post.paging.Pageble;

public interface IGroupRoleDAO extends GenericDAO<GroupRoleModel>{
	
	GroupRoleModel findOne(long id);
	List<GroupRoleModel> findAllItem();
	List<GroupRoleModel> findAll(Pageble pageble);
	int getTotalItem();
	GroupRoleModel findOneByCode(String code);
	Long save(GroupRoleModel groupRoleModel);
	void update(GroupRoleModel updateGroupRole);
	void delete(long id);
	List<GroupRoleModel> getRoleByUserName (String userName);
	List<GroupRoleModel> getGroupRoleByUserName(String userName);
	GroupRoleModel findOneByName(String name);

}
