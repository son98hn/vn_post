package vn_post.model;

public class RoleDetailModel extends AbstractModel<RoleDetailModel> {

	private String name;
	private Long roleId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


}
