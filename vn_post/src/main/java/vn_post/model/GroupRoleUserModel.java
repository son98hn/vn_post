package vn_post.model;

public class GroupRoleUserModel extends AbstractModel<GroupRoleUserModel> {

	private Long groupRoleId;
	private Long userId;
	private GroupRoleModel groupRole = new GroupRoleModel();
	
	public Long getGroupRoleId() {
		return groupRoleId;
	}
	public void setGroupRoleId(Long groupRoleId) {
		this.groupRoleId = groupRoleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public GroupRoleModel getGroupRole() {
		return groupRole;
	}
	public void setGroupRole(GroupRoleModel groupRole) {
		this.groupRole = groupRole;
	}
	
}
