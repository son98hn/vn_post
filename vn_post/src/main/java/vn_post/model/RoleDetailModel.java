package vn_post.model;

import java.util.ArrayList;
import java.util.List;

public class RoleDetailModel extends AbstractModel<RoleDetailModel> {

	private Long roleId;
	private String permission;
	private String code;
	private List<String> listRole = new ArrayList<>();
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getListRole() {
		return listRole;
	}
	public void setListRole(List<String> listRole) {
		this.listRole = listRole;
	}
	
	
	
}
