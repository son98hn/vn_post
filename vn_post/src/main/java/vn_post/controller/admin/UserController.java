package vn_post.controller.admin;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn_post.model.GroupRoleModel;
import vn_post.model.RoleDetailModel;
import vn_post.model.UserModel;
import vn_post.paging.PageRequest;
import vn_post.paging.Pageble;
import vn_post.service.IGroupRoleService;
import vn_post.service.IRoleDetailService;
import vn_post.service.IUserService;
import vn_post.sort.Sorter;
import vn_post.util.FormUtil;
import vn_post.util.MessageUtil;
import vn_post.util.SessionUtil;

@WebServlet(urlPatterns = { "/admin-user" })
public class UserController extends HttpServlet {

	private static final long serialVersionUID = -3719472794256194864L;

	@Inject
	private IUserService userSerivce;
	@Inject
	private IGroupRoleService groupRoleService;
	@Inject
	private IRoleDetailService roleDetailService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		UserModel model = FormUtil.toModel(UserModel.class, request);
		String view = "";
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
				new Sorter(model.getSortName(), model.getSortBy()));
		if (model.getType().equals("list")) {
			model.setListResult(userSerivce.findAll(pageble));
			model.setTotalItem(userSerivce.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			request.setAttribute("roles", groupRoleService.findAllItem());
			List<UserModel> listUserModel = userSerivce.findAll(pageble);
			List<List> list_groupRoleName_list = new ArrayList<>();
			for (int i = 0; i < listUserModel.size(); i++) {
				List<String> list_groupRoleUser_str = new ArrayList<>();
				String userName_str = listUserModel.get(i).getUserName();
				List<GroupRoleModel> groupRole = groupRoleService.getGroupRoleByUserName(userName_str);
				for (int j = 0; j < groupRole.size(); j++) {
					String groupRole_str = groupRole.get(j).getName();
					list_groupRoleUser_str.add(groupRole_str);
				}
				list_groupRoleName_list.add(list_groupRoleUser_str);
			}
			model.setListGroupRoleName(list_groupRoleName_list);
			List<RoleDetailModel> roleDetail = roleDetailService.getRoleByUserName(userModel.getUserName());
			List<String> list_roleDetailCode_str = new ArrayList<>();
			for (int i = 0; i < roleDetail.size(); i++) {
				String roleDetailCode_str = roleDetail.get(i).getCode();
				list_roleDetailCode_str.add(roleDetailCode_str);
			}
			userModel.setListRoleDetailCode(list_roleDetailCode_str);
			view = "/views/admin/tk/list-tk.jsp";
		} else if (model.getType().equals("edit")) {
			if (model.getId() != null) {
				model = userSerivce.findOne(model.getId());
				List<String> list_groupRole_str = new ArrayList<>();
				List<GroupRoleModel> groupRole = groupRoleService.getRoleByUserName(model.getUserName());
				for (int i = 0; i < groupRole.size(); i++) {
					String grouprole_str = groupRole.get(i).getName();
					list_groupRole_str.add(grouprole_str);
				}
				model.setGroupRoleName(list_groupRole_str);
			}
			request.setAttribute("roles", groupRoleService.findAllItem());
			view = "/views/admin/tk/edit-tk.jsp";
		}
		request.setAttribute("userModel", userModel);
		MessageUtil.showMessage(request);
		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {

	}

}