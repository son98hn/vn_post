package vn_post.DAO.impl;

import java.util.List;

import vn_post.DAO.IRoleDetailDAO;
import vn_post.mapper.RoleDetailMapper;
import vn_post.model.RoleDetailModel;

public class RoleDetailDAO extends AbstractDAO<RoleDetailModel> implements IRoleDetailDAO {

	@Override
	public List<RoleDetailModel> findAll() {
		String sql = "SELECT * FROM roledetail";
		return query(sql, new RoleDetailMapper());
	}

}
