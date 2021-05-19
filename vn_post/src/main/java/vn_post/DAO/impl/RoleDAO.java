package vn_post.DAO.impl;

import java.util.List;

import vn_post.DAO.IRoleDAO;
import vn_post.mapper.RoleMapper;
import vn_post.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {

	@Override
	public RoleModel findOne(long id) {
		String sql = "SELECT * FROM role WHERE id = ?";
		List<RoleModel> role = query(sql, new RoleMapper(), id);
		return role.isEmpty() ? null : role.get(0);
	}

	@Override
	public List<RoleModel> findAll() {
		String sql = "SELECT * FROM role";
		return query(sql, new RoleMapper());
	}

	@Override
	public RoleModel findOneByCode(String code) {
		String sql = "SELECT * FROM role WHERE code = ?";
		List<RoleModel> role = query(sql, new RoleMapper(), code);
		return role.isEmpty() ? null : role.get(0);
	}


	

}
