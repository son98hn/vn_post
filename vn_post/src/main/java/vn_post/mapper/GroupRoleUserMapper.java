package vn_post.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import vn_post.model.GroupRoleUserModel;

public class GroupRoleUserMapper implements RowMapper<GroupRoleUserModel> {
	@Override
	public GroupRoleUserModel mapRow(ResultSet resultSet) {
		try {
			GroupRoleUserModel groupRoleUser = new GroupRoleUserModel();
			groupRoleUser.setId(resultSet.getLong("id"));
			groupRoleUser.setGroupRoleId(resultSet.getLong("group_roleid"));
			groupRoleUser.setUserId(resultSet.getLong("userid"));
			return groupRoleUser;
		} catch (SQLException e) {
			return null;
		}
	}
}
