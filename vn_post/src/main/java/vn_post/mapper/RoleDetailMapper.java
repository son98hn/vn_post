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
			roleDetail.setRoleId(resultSet.getLong("roleid"));
			roleDetail.setPermission(resultSet.getString("permission"));
			roleDetail.setCode(resultSet.getString("code"));
			return roleDetail;
		} catch (SQLException e) {
			return null;
		}
	}
}
