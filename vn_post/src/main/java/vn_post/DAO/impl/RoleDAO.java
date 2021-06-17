package vn_post.DAO.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn_post.DAO.IRoleDAO;
import vn_post.mapper.RoleMapper;
import vn_post.model.RoleModel;
import vn_post.paging.Pageble;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {

	@Override
	public RoleModel findOne(long id) {
		String sql = "SELECT * FROM role WHERE id = ?";
		List<RoleModel> role = query(sql, new RoleMapper(), id);
		return role.isEmpty() ? null : role.get(0);
	}
	@Override
	public Long save(RoleModel roleModel) {
		String sql = "INSERT INTO role (name, code) VALUES(?, ?)";
		return insert(sql, roleModel.getName(), roleModel.getCode());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM role WHERE id=?";
		this.update(sql, id);
	}

	@Override
	public void update(RoleModel updateRole) {
		String sql = "UPDATE roledetail SET name=?, code=? WHERE id = ?";
		update(sql, updateRole.getName(), updateRole.getCode(),
				updateRole.getId());
	}
	
	@Override
	public List<RoleModel> findAllItem() {
		String sql = "SELECT * FROM role";
		return query(sql, new RoleMapper());
	}

	@Override
	public RoleModel findOneByCode(String code) {
		String sql = "SELECT * FROM role WHERE code = ?";
		List<RoleModel> role = query(sql, new RoleMapper(), code);
		return role.isEmpty() ? null : role.get(0);
	}
	
	@Override
	public List<RoleModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM role");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), new RoleMapper());
	}
	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM role";
		return count(sql);
	}
	@Override
	public List<RoleModel> getRoleDetailById(Long id) {
		String sql ="SELECT * FROM role INNER JOIN roledetail ON "
				+ "role.id = roledetail.roleid  "
				+ "WHERE roledetail.roleid = ?";
		List<RoleModel> role = query(sql, new RoleMapper(), id);	
		return role;
	}

}
