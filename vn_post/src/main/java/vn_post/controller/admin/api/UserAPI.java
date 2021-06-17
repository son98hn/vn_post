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

import vn_post.model.UserModel;
import vn_post.service.IUserService;
import vn_post.util.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-user" })
public class UserAPI extends HttpServlet {

//	Gọi hàm service
	@Inject
	private IUserService userService;

	private static final long serialVersionUID = 1112448464061133945L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		UserModel userModel = new UserModel();
		JSONArray json = HttpUtil.of(request.getReader()).toModel(JSONArray.class);
		List<String> getRoles = new ArrayList<>();
		String getUsername, getPassword;
		for (int i = 0; i < json.size(); i++) {
			if (i == 0) {
				getUsername = json.get(i).toString().split("=")[2];
				getUsername = getUsername.substring(0, getUsername.length() - 1);
				userModel.setUserName(getUsername);
			} else if (i == 1) {
				getPassword = json.get(i).toString().split("=")[2];
				getPassword = getPassword.substring(0, getPassword.length() - 1);
				userModel.setPassword(getPassword);
			} else if (i < json.size() - 1) {
				String role = json.get(i).toString().split("=")[2];
				role = role.substring(0, role.length() - 1);
				getRoles.add(role);
				userModel.setGroupRoleName(getRoles);
			}

		}
		userModel = userService.save(userModel);
		mapper.writeValue(response.getOutputStream(), userModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		UserModel updateUser = new UserModel();
		JSONArray json = HttpUtil.of(request.getReader()).toModel(JSONArray.class);
		List<String> getRoles = new ArrayList<>();
		String getUsername, getPassword, getId;
		for (int i = 0; i < json.size(); i++) {
			if (i == 0) {
				getUsername = json.get(i).toString().split("=")[2];
				getUsername = getUsername.substring(0, getUsername.length() - 1);
				updateUser.setUserName(getUsername);
			} else if (i == 1) {
				getPassword = json.get(i).toString().split("=")[2];
				getPassword = getPassword.substring(0, getPassword.length() - 1);
				updateUser.setPassword(getPassword);
			} else if (i < json.size() - 1) {
				String role = json.get(i).toString().split("=")[2];
				role = role.substring(0, role.length() - 1);
				getRoles.add(role);
				updateUser.setGroupRoleName(getRoles);
			} else {
				getId = json.get(i).toString().split("=")[2];
				getId = getId.substring(0,getId.length()-1);
				updateUser.setId(Long.parseLong(getId));
			}

		}
		updateUser = userService.update(updateUser);
		mapper.writeValue(response.getOutputStream(), updateUser);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		UserModel userModel = HttpUtil.of(request.getReader()).toModel(UserModel.class);
		userService.delete(userModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}