package vn_post.DAO.impl;

import java.util.List;

import vn_post.DAO.IUserDAO;
import vn_post.mapper.UserMapper;
import vn_post.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		String sql = "SELECT * FROM [user] AS u INNER JOIN role AS r ON r.id = u.roleid WHERE username = ? AND password = ? AND status = ?";
		List<UserModel> users = query(sql, new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

}
