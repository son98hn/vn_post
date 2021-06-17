package vn_post.DAO.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn_post.DAO.IGroupRoleDAO;
import vn_post.mapper.GroupRoleMapper;
import vn_post.model.GroupRoleModel;
import vn_post.paging.Pageble;

public class GroupRoleDAO extends AbstractDAO<GroupRoleModel> implements IGroupRoleDAO {

	@Override
	public GroupRoleModel findOne(long id) {
		String sql = "SELECT * FROM group_role WHERE id = ?";
		List<GroupRoleModel> groupRole = query(sql, new GroupRoleMapper(), id);
		return groupRole.isEmpty() ? null : groupRole.get(0);
	}
//	@Override
//	public GroupRoleModel findOneByGroupRoleUs(long id) {
//		String sql = "SELECT * FROM group_role WHERE id = ?";
//		List<GroupRoleModel> groupRole = query(sql, new GroupRoleMapper(), id);
//		return groupRole.isEmpty() ? null : groupRole.get(0);
//	}

	@Override
	public Long save(GroupRoleModel groupRoleModel) {
		String sql = "INSERT INTO group_role (name, code) VALUES(?, ?)";
		return insert(sql, groupRoleModel.getName(), groupRoleModel.getCode());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM group_role WHERE id=?";
		this.update(sql, id);
	}
	


	@Override
	public void update(GroupRoleModel updateGroupRole) {
		String sql = "UPDATE group_role SET name=?, code=? WHERE id = ?";
		update(sql, updateGroupRole.getName(), updateGroupRole.getCode(), updateGroupRole.getId());
	}

	@Override
	public List<GroupRoleModel> findAllItem() {
		String sql = "SELECT * FROM group_role";
		return query(sql, new GroupRoleMapper());
	}
	@Override
	public List<GroupRoleModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM group_role");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), new GroupRoleMapper());

	}
	@Override
	public GroupRoleModel findOneByCode(String code) {
		String sql = "SELECT * FROM group_role WHERE code = ?";
		List<GroupRoleModel> groupRole = query(sql, new GroupRoleMapper(), code);
		return groupRole.isEmpty() ? null : groupRole.get(0);
	}
	@Override
	public GroupRoleModel findOneByName(String name) {
		String sql = "SELECT * FROM group_role WHERE name = ?";
		List<GroupRoleModel> groupRole = query(sql, new GroupRoleMapper(), name);
		return groupRole.isEmpty() ? null : groupRole.get(0);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM group_role";
		return count(sql);
	}

	@Override
	public List<GroupRoleModel> getRoleByUserName(String userName) {
		String sql = "SELECT * FROM group_role INNER JOIN grouprole_user ON group_role.id = grouprole_user.group_roleid INNER JOIN [user] ON grouprole_user.userid = [user].id WHERE [user].username = ?";
		List<GroupRoleModel> roleModel = query(sql, new GroupRoleMapper(), userName);
		return roleModel;
	}
	
	@Override
	public List<GroupRoleModel> getGroupRoleByUserName(String userName) {
		String sql = "select * from group_role inner join grouprole_user on grouprole_user.group_roleid = group_role.id inner join [user] on grouprole_user.userid = [user].id where [user].username =?";
		return query(sql,  new GroupRoleMapper(), userName);
	}

}
