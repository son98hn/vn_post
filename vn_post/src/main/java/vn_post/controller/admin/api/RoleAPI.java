package vn_post.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn_post.model.RoleModel;
import vn_post.service.IRoleService;
import vn_post.util.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-role" })
public class RoleAPI extends HttpServlet {

	@Inject
	private IRoleService roleService;

	private static final long serialVersionUID = 1112448464061133945L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		RoleModel roleModel = new RoleModel();
		JSONArray json = HttpUtil.of(request.getReader()).toModel(JSONArray.class);
		String getName, getCode;
		for (int i = 0; i < json.size(); i++) {
			if (i == 0) {
				getName = json.get(i).toString().split("=")[2];
				getName = getName.substring(0, getName.length() - 1);
				roleModel.setName(getName);
			} else if (i == 1) {
				getCode = json.get(i).toString().split("=")[2];
				getCode = getCode.substring(0, getCode.length() - 1);
				roleModel.setCode(getCode);
			}
		}
		roleModel = roleService.save(roleModel);
		mapper.writeValue(response.getOutputStream(), roleModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		RoleModel updateRole = new RoleModel();
		JSONArray json = HttpUtil.of(request.getReader()).toModel(JSONArray.class);
		String getName, getCode, getId;
		for (int i = 0; i < json.size(); i++) {
			if (i == 0) {
				getName = json.get(i).toString().split("=")[2];
				getName = getName.substring(0, getName.length() - 1);
				updateRole.setName(getName);
			} else if (i == 1) {
				getCode = json.get(i).toString().split("=")[2];
				getCode = getCode.substring(0, getCode.length() - 1);
				updateRole.setCode(getCode);
			} else {
				getId = json.get(i).toString().split("=")[2];
				getId = getId.substring(0, getId.length() - 1);
				updateRole.setId(Long.parseLong(getId));
			}

		}
		updateRole = roleService.update(updateRole);
		mapper.writeValue(response.getOutputStream(), updateRole);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		RoleModel roleModel = HttpUtil.of(request.getReader()).toModel(RoleModel.class);
		roleService.delete(roleModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}