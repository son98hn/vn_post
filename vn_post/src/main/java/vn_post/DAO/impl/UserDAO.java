package vn_post.DAO.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;

import vn_post.DAO.IUserDAO;
import vn_post.mapper.UserMapper;
import vn_post.model.UserModel;
import vn_post.paging.Pageble;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Inject
	private UserMapper userMapper;

	@Override
	public UserModel findByUserNameAndPassword(String userName, String password) {
		String sql = "SELECT * FROM [user] WHERE username = ? AND password =?";
		List<UserModel> users = query(sql, userMapper, userName, password);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public List<UserModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM [user]");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), userMapper);

	}
	@Override
	public List<UserModel> findAllItem() {
		String sql = "SELECT * FROM [user]";
		return query(sql, userMapper);
	}
	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM [user]";
		return count(sql);
	}

	@Override
	public UserModel findOne(Long id) {
		String sql = "SELECT * FROM [user] WHERE id = ?";
		List<UserModel> users = query(sql, userMapper, id);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Long save(UserModel userModel) {
		String sql = "INSERT INTO [user] (username, password) VALUES(?, ?)";
		return insert(sql, userModel.getUserName(), userModel.getPassword());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM [user] WHERE id=?";
		this.update(sql, id);
	}

	@Override
	public void update(UserModel updateUser) {
		String sql = "UPDATE [user] SET username=?, password=? WHERE id = ?";
		update(sql, updateUser.getUserName(), updateUser.getPassword(), updateUser.getId());
	}

	@Override
	public List<UserModel> getRoleByUserName(String userName) {
		String sql = "select [user].username, roledetail.code from [user] inner join grouprole_user on [user].id = grouprole_user.userid inner join group_role on grouprole_user.group_roleid = group_role.id inner join grouprole_roledetail on grouprole_roledetail.group_role_id = group_role.id inner join roledetail on grouprole_roledetail.roledetailid= roledetail.id where [user].username =?";
		return query(sql, userMapper, userName);
	}



}
