package vn_post.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import vn_post.model.RoleDetailModel;

public class RoleDetailMapper implements RowMapper<RoleDetailModel> {
	@Override
	public RoleDetailModel mapRow(ResultSet resultSet) {
		try {
			RoleDetailModel roleDetail = new RoleDetailModel();
			roleDetail.setId(resultSet.getLong("id"));
			roleDetail.setName(resultSet.getString("name"));
			roleDetail.setRoleId(resultSet.getLong("roleId"));
			return roleDetail;
		} catch (SQLException e) {
			return null;
		}
	}
}
