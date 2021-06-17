package vn_post.DAO.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn_post.DAO.IGroupRoleUserDAO;
import vn_post.mapper.GroupRoleUserMapper;
import vn_post.model.GroupRoleUserModel;
import vn_post.paging.Pageble;

public class GroupRoleUserDAO extends AbstractDAO<GroupRoleUserModel> implements IGroupRoleUserDAO {

	@Override
	public List<GroupRoleUserModel> findAllItem() {
		String sql = "SELECT * FROM grouprole_user";
		return query(sql, new GroupRoleUserMapper());
	}

	@Override
	public List<GroupRoleUserModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM grouprole_roledetail");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), new GroupRoleUserMapper());

	}
	@Override
	public GroupRoleUserModel findOneByUserId(long userId) {
		String sql = "SELECT * FROM grouprole_user WHERE userid =?";
		List<GroupRoleUserModel> groupRoleUser = query(sql, new GroupRoleUserMapper(), userId);
		return groupRoleUser.isEmpty() ? null : groupRoleUser.get(0);
	}
	@Override
	public GroupRoleUserModel findOneByGroupRoleId(long groupRoleId) {
		String sql = "SELECT * FROM grouprole_user WHERE group_roleid =?";
		List<GroupRoleUserModel> groupRoleUser = query(sql, new GroupRoleUserMapper(), groupRoleId);
		return groupRoleUser.isEmpty() ? null : groupRoleUser.get(0);
	}

	@Override
	public Long save(GroupRoleUserModel roleUserModel) {
		String sql = "INSERT INTO grouprole_user (group_roleid, userid ) VALUES(?,?)";
		return insert(sql, roleUserModel.getGroupRoleId(), roleUserModel.getUserId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM grouprole_user WHERE id=?";
		this.update(sql, id);
	}

	@Override
	public void deleteByUserId(long userId) {
		String sql = "DELETE FROM grouprole_user WHERE userid=?";
		this.update(sql, userId);
	}
	@Override
	public void update(GroupRoleUserModel updateGroupRoleUser) {
		String sql = "UPDATE grouprole_user SET group_roleid=?, userid=? WHERE id = ?";
		update(sql, updateGroupRoleUser.getGroupRoleId(), updateGroupRoleUser.getUserId(),
				updateGroupRoleUser.getId());
	}

	@Override
	public GroupRoleUserModel findOne(long id) {
		String sql = "SELECT * FROM grouprole_user WHERE id = ?";
		List<GroupRoleUserModel> groupRoleUser = query(sql, new GroupRoleUserMapper(), id);
		return groupRoleUser.isEmpty() ? null : groupRoleUser.get(0);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM grouprole_user";
		return count(sql);
	}

}
