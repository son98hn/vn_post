package vn_post.DAO.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn_post.DAO.IGroupRoleDetailDAO;
import vn_post.mapper.GroupRoleDetailMapper;
import vn_post.model.GroupRoleDetailModel;
import vn_post.paging.Pageble;

public class GroupRoleDetailDAO extends AbstractDAO<GroupRoleDetailModel> implements IGroupRoleDetailDAO {

	@Override
	public List<GroupRoleDetailModel> findAllItem() {
		String sql = "SELECT * FROM grouprole_roledetail";
		return query(sql, new GroupRoleDetailMapper());
	}
	@Override
	public List<GroupRoleDetailModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM grouprole_roledetail");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), new GroupRoleDetailMapper());

	}
	@Override
	public GroupRoleDetailModel findOneByGroupRoleId(long groupRoleId) {
		String sql = "SELECT * FROM grouprole_roledetail WHERE group_role_id =?";
		List<GroupRoleDetailModel> groupRoleDetail = query(sql, new GroupRoleDetailMapper(), groupRoleId);
		return groupRoleDetail.isEmpty() ? null : groupRoleDetail.get(0);
	}

	@Override
	public void deleteByGroupRoleId(long groupRoleId) {
		String sql = "DELETE FROM grouprole_roledetail WHERE group_role_id=?";
		this.update(sql, groupRoleId);
	}
	@Override
	public List<GroupRoleDetailModel> findByGroupRoleId(long groupRoleId) {
		String sql = "SELECT * FROM grouprole_roledetail WHERE group_role_id =?";
		return query(sql, new GroupRoleDetailMapper(), groupRoleId);
	}

	@Override
	public Long save(GroupRoleDetailModel roleDetailModel) {
		String sql = "INSERT INTO grouprole_roledetail (group_role_id, roledetailid ) VALUES(?,?)";
		return insert(sql, roleDetailModel.getGroupRoleId(), roleDetailModel.getRoleDetailId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM grouprole_roledetail WHERE id=?";
		this.update(sql, id);
	}

	@Override
	public void update(GroupRoleDetailModel updateGroupRoleDetail) {
		String sql = "UPDATE grouprole_roledetail SET group_role_id, roledetailid=? WHERE id = ?";
		update(sql, updateGroupRoleDetail.getGroupRoleId(), updateGroupRoleDetail.getRoleDetailId(),
				updateGroupRoleDetail.getId());
	}

	@Override
	public GroupRoleDetailModel findOne(long id) {
		String sql = "SELECT * FROM grouprole_roledetail WHERE id = ?";
		List<GroupRoleDetailModel> groupRoleDetail = query(sql, new GroupRoleDetailMapper(), id);
		return groupRoleDetail.isEmpty() ? null : groupRoleDetail.get(0);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM grouprole_roledetail";
		return count(sql);
	}

}
