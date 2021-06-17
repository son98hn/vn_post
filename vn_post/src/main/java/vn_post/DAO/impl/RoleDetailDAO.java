package vn_post.DAO.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn_post.DAO.IRoleDetailDAO;
import vn_post.mapper.RoleDetailMapper;
import vn_post.model.RoleDetailModel;
import vn_post.paging.Pageble;

public class RoleDetailDAO extends AbstractDAO<RoleDetailModel> implements IRoleDetailDAO {
	
	@Override
	public RoleDetailModel findOneByCode(String code) {
		String sql = "SELECT * FROM roledetail WHERE code =?";
		List<RoleDetailModel> roleDetail = query(sql, new RoleDetailMapper(), code);
		return roleDetail.isEmpty() ? null : roleDetail.get(0);
	}

	@Override
	public RoleDetailModel findOneByRoleId(Long roleId) {
		String sql = "SELECT * FROM roledetail WHERE roleid =?";
		List<RoleDetailModel> roleDetail = query(sql, new RoleDetailMapper(), roleId);
		return roleDetail.isEmpty() ? null : roleDetail.get(0);
	}
	
	@Override
	public List<RoleDetailModel> find(long id) {
		String sql = "SELECT * FROM roledetail WHERE id =?";
		return query(sql, new RoleDetailMapper(), id);
	}

	@Override
	public List<RoleDetailModel> findAllItem() {
		String sql = "SELECT * FROM roledetail";
		return query(sql, new RoleDetailMapper());
	}
	@Override
	public Long save(RoleDetailModel roleDetailModel) {
		String sql = "INSERT INTO roledetail (roleid, permission, code ) VALUES(?,?,?)";
		return insert(sql, roleDetailModel.getRoleId(), roleDetailModel.getPermission(), roleDetailModel.getCode());
	}
	@Override
	public void deleteByRoleId(long roleId) {
		String sql = "DELETE FROM roledetail WHERE roleid=?";
		this.update(sql, roleId);
	}
	@Override
	public void delete(long id) {
		String sql = "DELETE FROM roledetail WHERE id=?";
		this.update(sql, id);
	}

	@Override
	public void update(RoleDetailModel updateRoleDetail) {
		String sql = "UPDATE roledetail SET roleid=?, permission=?, code=? WHERE id = ?";
		update(sql, updateRoleDetail.getRoleId(), updateRoleDetail.getPermission(), updateRoleDetail.getCode(),
				updateRoleDetail.getId());
	}

	@Override
	public RoleDetailModel findOne(long id) {
		String sql = "SELECT * FROM roledetail WHERE id = ?";
		List<RoleDetailModel> roleDetail = query(sql, new RoleDetailMapper(), id);
		return roleDetail.isEmpty() ? null : roleDetail.get(0);
	}
	@Override
	public RoleDetailModel findOneByPermission(String permission) {
		String sql = "SELECT * FROM roledetail WHERE permission = ?";
		List<RoleDetailModel> roleDetail = query(sql, new RoleDetailMapper(), permission);
		return roleDetail.isEmpty() ? null : roleDetail.get(0);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM roledetail";
		return count(sql);
	}

	@Override
	public List<RoleDetailModel> getRoleByUserName(String userName) {
		String sql ="SELECT * FROM roledetail INNER JOIN grouprole_roledetail ON "
				+ "roledetail.id = grouprole_roledetail.roledetailid INNER JOIN group_role ON "
				+ "group_role.id = grouprole_roledetail.group_role_id INNER JOIN grouprole_user ON "
				+ "group_role.id = grouprole_user.group_roleid INNER JOIN [user] ON grouprole_user.userid= [user].id "
				+ "WHERE [user].username = ?";
		List<RoleDetailModel> roleDetail = query(sql, new RoleDetailMapper(), userName);
		return roleDetail;
	}
	

	@Override
	public List<RoleDetailModel> getRoleByGroupRoleId(Long groupRoleId) {
		String sql ="SELECT * FROM roledetail INNER JOIN grouprole_roledetail ON "
				+ "roledetail.id = grouprole_roledetail.roledetailid INNER JOIN group_role ON "
				+ "group_role.id = grouprole_roledetail.group_role_id "
				+ "WHERE [group_role].id = ?";
		List<RoleDetailModel> roleDetail = query(sql, new RoleDetailMapper(), groupRoleId);	
		return roleDetail;
	}
	@Override
	public List<RoleDetailModel> getRoleByRoleId(Long id) {
		String sql ="SELECT * FROM roledetail INNER JOIN role ON "
				+ "roledetail.roleid = role.id "
				+ "WHERE role.id = ?";
		List<RoleDetailModel> roleDetail = query(sql, new RoleDetailMapper(), id);	
		return roleDetail;
	}
	
	@Override
	public List<RoleDetailModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM roledetail");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), new RoleDetailMapper());

	}

}
