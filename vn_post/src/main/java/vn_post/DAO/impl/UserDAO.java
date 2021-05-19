package vn_post.DAO.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn_post.DAO.IUserDAO;
import vn_post.mapper.UserMapper;
import vn_post.model.UserModel;
import vn_post.paging.Pageble;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		String sql = "SELECT * FROM [user] AS u INNER JOIN role AS r ON r.id = u.roleid WHERE username = ? AND password = ? AND status = ?";
		List<UserModel> users = query(sql, new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public List<UserModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM [user]");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), new UserMapper());
	
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM [user]";
		return count(sql);
	}

	@Override
	public UserModel findOne(Long id) {
		String sql = "SELECT * FROM [user] WHERE id = ?";
		List<UserModel> users = query(sql, new UserMapper(), id);
		return users.isEmpty() ? null : users.get(0);
	}
	
	@Override
	public Long save(UserModel userModel) {
		String sql = "INSERT INTO [user] (username, password, roleid) VALUES(?, ?, ?)";
		return insert(sql, userModel.getUserName(), userModel.getPassword(), userModel.getRoleId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM [user] WHERE id=?";
		this.update(sql, id);
	}

	@Override
	public void update(UserModel updateUser) {
		String sql = "UPDATE [user] SET username=?, password=?,roleid=? WHERE id = ?";
		update(sql, updateUser.getUserName(), updateUser.getPassword(), updateUser.getRoleId(), updateUser.getId());
	}
	

}
