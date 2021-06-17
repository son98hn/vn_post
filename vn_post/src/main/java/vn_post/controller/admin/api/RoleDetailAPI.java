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

import vn_post.model.RoleDetailModel;
import vn_post.service.IRoleDetailService;
import vn_post.util.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-roledetail" })
public class RoleDetailAPI extends HttpServlet {
	
	@Inject
	private IRoleDetailService roleDetailService;

	private static final long serialVersionUID = 1112448464061133945L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		RoleDetailModel roleDetailModel = new RoleDetailModel();
		JSONArray json = HttpUtil.of(request.getReader()).toModel(JSONArray.class);
		String getName, getCode, getRoleId;
		for (int i = 0; i < json.size(); i++) {
			if (i == 0) {
				getRoleId = json.get(i).toString().split("=")[2];
				getRoleId = getRoleId.substring(0,getRoleId.length()-1);
				roleDetailModel.setRoleId(Long.parseLong(getRoleId));
			} else if (i == 1) {
				getCode = json.get(i).toString().split("=")[2];
				getCode = getCode.substring(0, getCode.length() - 1);
				roleDetailModel.setCode(getCode);
			}
			else if (i == 2) {
				getName = json.get(i).toString().split("=")[2];
				getName = getName.substring(0, getName.length() - 1);
				roleDetailModel.setPermission(getName);
			}

		}
		roleDetailModel = roleDetailService.save(roleDetailModel);
		mapper.writeValue(response.getOutputStream(), roleDetailModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		RoleDetailModel updateRoleDetail = new RoleDetailModel();
		JSONArray json = HttpUtil.of(request.getReader()).toModel(JSONArray.class);
		String getName, getCode, getId;
		for (int i = 0; i < json.size(); i++) {
			if (i == 0) {
				getName = json.get(i).toString().split("=")[2];
				getName = getName.substring(0, getName.length() - 1);
				updateRoleDetail.setPermission(getName);
			} else if (i == 1) {
				getCode = json.get(i).toString().split("=")[2];
				getCode = getCode.substring(0, getCode.length() - 1);
				updateRoleDetail.setCode(getCode);
			} else {
				getId = json.get(i).toString().split("=")[2];
				getId = getId.substring(0,getId.length()-1);
				updateRoleDetail.setId(Long.parseLong(getId));
			}

		}
		updateRoleDetail = roleDetailService.update(updateRoleDetail);
		mapper.writeValue(response.getOutputStream(), updateRoleDetail);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		RoleDetailModel roleDetailModel = HttpUtil.of(request.getReader()).toModel(RoleDetailModel.class);
		roleDetailService.delete(roleDetailModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}