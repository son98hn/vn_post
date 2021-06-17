package vn_post.controller.admin.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn_post.model.GroupRoleModel;
import vn_post.service.IGroupRoleService;
import vn_post.util.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-grouprole" })
public class GroupRoleAPI extends HttpServlet {

	@Inject
	private IGroupRoleService groupRoleService;

	private static final long serialVersionUID = 1112448464061133945L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		GroupRoleModel groupRoleModel = new GroupRoleModel();
		JSONArray json = HttpUtil.of(request.getReader()).toModel(JSONArray.class);
		List<String> getRoles = new ArrayList<>();
		String getName, getCode;
		for (int i = 0; i < json.size(); i++) {
			if (i == 0) {
				getName = json.get(i).toString().split("=")[2];
				getName = getName.substring(0, getName.length() - 1);
				groupRoleModel.setName(getName);
			} else if (i == 1) {
				getCode = json.get(i).toString().split("=")[2];
				getCode = getCode.substring(0, getCode.length() - 1);
				groupRoleModel.setCode(getCode);
			} else if (i < json.size() - 1) {
				String role = json.get(i).toString().split("=")[2];
				role = role.substring(0, role.length() - 1);
				getRoles.add(role);
				groupRoleModel.setListStringRoleDetailName(getRoles);
			}

		}
		groupRoleModel = groupRoleService.save(groupRoleModel);
		mapper.writeValue(response.getOutputStream(), groupRoleModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		GroupRoleModel updateGroupRole = new GroupRoleModel();
		JSONArray json = HttpUtil.of(request.getReader()).toModel(JSONArray.class);
		List<String> getRoles = new ArrayList<>();
		String getName, getCode, getId;
		for (int i = 0; i < json.size(); i++) {
			if (i == 0) {
				getName = json.get(i).toString().split("=")[2];
				getName = getName.substring(0, getName.length() - 1);
				updateGroupRole.setName(getName);
			} else if (i == 1) {
				getCode = json.get(i).toString().split("=")[2];
				getCode = getCode.substring(0, getCode.length() - 1);
				updateGroupRole.setCode(getCode);
			} else if (i < json.size() - 1) {
				String role = json.get(i).toString().split("=")[2];
				role = role.substring(0, role.length() - 1);
				getRoles.add(role);
				updateGroupRole.setListStringRoleDetailName(getRoles);
			} else {
				getId = json.get(i).toString().split("=")[2];
				getId = getId.substring(0,getId.length()-1);
				updateGroupRole.setId(Long.parseLong(getId));
			}

		}
		updateGroupRole = groupRoleService.update(updateGroupRole);
		mapper.writeValue(response.getOutputStream(), updateGroupRole);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		GroupRoleModel groupRoleModel = HttpUtil.of(request.getReader()).toModel(GroupRoleModel.class);
		groupRoleService.delete(groupRoleModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");	}
}