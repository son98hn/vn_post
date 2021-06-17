package vn_post.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import vn_post.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			return user;
		} catch (SQLException e) {
			return null;
		}

	}

}
