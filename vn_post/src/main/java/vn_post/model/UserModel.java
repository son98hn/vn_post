
package vn_post.model;

import java.util.ArrayList;
import java.util.List;

public class UserModel extends AbstractModel<UserModel> {

	private String userName;
	private String password;
	private String groupRoleCode;
	private List<String> listRoleDetailCode = new ArrayList<>();
	private String roleDetailCode;
	private List<List> listGroupRoleName = new ArrayList<>();
	private List<String> groupRoleName;

	public List<String> getGroupRoleName() {
		return groupRoleName;
	}

	public void setGroupRoleName(List<String> groupRoleName) {
		this.groupRoleName = groupRoleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroupRoleCode() {
		return groupRoleCode;
	}

	public void setGroupRoleCode(String groupRoleCode) {
		this.groupRoleCode = groupRoleCode;
	}



	public String getRoleDetailCode() {
		return roleDetailCode;
	}

	public void setRoleDetailCode(String roleDetailCode) {
		this.roleDetailCode = roleDetailCode;
	}

	public List<String> getListRoleDetailCode() {
		return listRoleDetailCode;
	}

	public void setListRoleDetailCode(List<String> listRoleDetailCode) {
		this.listRoleDetailCode = listRoleDetailCode;
	}

	public List<List> getListGroupRoleName() {
		return listGroupRoleName;
	}

	public void setListGroupRoleName(List<List> listGroupRoleName) {
		this.listGroupRoleName = listGroupRoleName;
	}

	
	
}