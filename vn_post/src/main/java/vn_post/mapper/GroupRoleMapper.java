package vn_post.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import vn_post.model.GroupRoleModel;

public class GroupRoleMapper implements RowMapper<GroupRoleModel> {
	@Override
	public GroupRoleModel mapRow(ResultSet resultSet) {
		try {
			GroupRoleModel groupRole = new GroupRoleModel();
			groupRole.setId(resultSet.getLong("id"));
			groupRole.setName(resultSet.getString("name"));
			groupRole.setCode(resultSet.getString("code"));
			return groupRole;
		} catch (SQLException e) {
			return null;
		}
	}
}
