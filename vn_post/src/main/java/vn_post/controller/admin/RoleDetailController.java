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

import vn_post.model.RoleDetailModel;
import vn_post.model.RoleModel;
import vn_post.model.UserModel;
import vn_post.paging.PageRequest;
import vn_post.paging.Pageble;
import vn_post.service.IRoleDetailService;
import vn_post.service.IRoleService;
import vn_post.sort.Sorter;
import vn_post.util.FormUtil;
import vn_post.util.MessageUtil;
import vn_post.util.SessionUtil;

@WebServlet(urlPatterns = { "/admin-roledetail" })
public class RoleDetailController extends HttpServlet {

	private static final long serialVersionUID = -3719472794256194864L;

	@Inject
	private IRoleDetailService roleDetailService;
	@Inject
	private IRoleService roleService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RoleDetailModel model = FormUtil.toModel(RoleDetailModel.class, request);
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		String view = "";
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
				new Sorter(model.getSortName(), model.getSortBy()));
		if (model.getType().equals("list")) {
			model.setListResult(roleDetailService.findAll(pageble));
			model.setTotalItem(roleDetailService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			List<RoleDetailModel> listRoleDetail = roleDetailService.findAll(pageble);
			List<String> list_role_str = new ArrayList<>();
			for (int i = 0; i < listRoleDetail.size(); i++) {
				RoleModel role = roleService.findOne(listRoleDetail.get(i).getRoleId());
				list_role_str.add(role.getName());
			}
			model.setListRole(list_role_str);
			List<RoleDetailModel> roleDetail = roleDetailService.getRoleByUserName(userModel.getUserName());
			List<String> list_roleDetailCode_str = new ArrayList<>();
			for (int i = 0; i < roleDetail.size(); i++) {
				String roleDetailCode_str = roleDetail.get(i).getCode();
				list_roleDetailCode_str.add(roleDetailCode_str);
			}
			userModel.setListRoleDetailCode(list_roleDetailCode_str);
			view = "/views/admin/roledetail/list-roledetail.jsp";
		} else if (model.getType().equals("edit"))

		{
			if (model.getId() != null) {
				model = roleDetailService.findOne(model.getId());
			}
			request.setAttribute("role", roleService.findAllItem());
			view = "/views/admin/roledetail/edit-roledetail.jsp";
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