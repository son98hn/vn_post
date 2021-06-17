package vn_post.model;

import java.util.ArrayList;
import java.util.List;

public class GroupRoleModel extends AbstractModel<GroupRoleModel> {

	private String code;
	private String name;
	private String roleDetailCode;
	private long roleDetailId;
	private List<List> listRoleDetailName = new ArrayList<>();
	private List<String> listStringRoleDetailName = new ArrayList<>();
	
	public long getRoleDetailId() {
		return roleDetailId;
	}

	public void setRoleDetailId(long roleDetailId) {
		this.roleDetailId = roleDetailId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleDetailCode() {
		return roleDetailCode;
	}

	public void setRoleDetailCode(String roleDetailCode) {
		this.roleDetailCode = roleDetailCode;
	}

	public List<List> getListRoleDetailName() {
		return listRoleDetailName;
	}

	public void setListRoleDetailName(List<List> listRoleDetailName) {
		this.listRoleDetailName = listRoleDetailName;
	}

	public List<String> getListStringRoleDetailName() {
		return listStringRoleDetailName;
	}

	public void setListStringRoleDetailName(List<String> listStringRoleDetailName) {
		this.listStringRoleDetailName = listStringRoleDetailName;
	}


}
