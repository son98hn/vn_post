package vn_post.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import vn_post.model.GroupRoleDetailModel;

public class GroupRoleDetailMapper implements RowMapper<GroupRoleDetailModel> {
	@Override
	public GroupRoleDetailModel mapRow(ResultSet resultSet) {
		try {
			GroupRoleDetailModel groupRoleDetail = new GroupRoleDetailModel();
			groupRoleDetail.setId(resultSet.getLong("id"));
			groupRoleDetail.setGroupRoleId(resultSet.getLong("group_role_id"));
			groupRoleDetail.setRoleDetailId(resultSet.getLong("roledetailid"));
			return groupRoleDetail;
		} catch (SQLException e) {
			return null;
		}
	}
}
