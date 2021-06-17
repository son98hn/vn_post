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

@WebServlet(urlPatterns = { "/admin-role" })
public class RoleController extends HttpServlet {

	private static final long serialVersionUID = -3719472794256194864L;

	@Inject
	private IRoleService roleService;

	@Inject
	private IRoleDetailService roleDetailService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RoleModel model = FormUtil.toModel(RoleModel.class, request);
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		String view = "";
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
				new Sorter(model.getSortName(), model.getSortBy()));
		if (model.getType().equals("list")) {
			model.setListResult(roleService.findAll(pageble));
			model.setTotalItem(roleService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			List<RoleModel> listRole = roleService.findAll(pageble);
			List<List> list_roleDetail_list = new ArrayList<>();
			for (int i = 0; i < listRole.size(); i++) {
				List<String> list_roleDetail_str = new ArrayList<>();
				Long id_long = listRole.get(i).getId();
				List<RoleDetailModel> roleDetail = roleDetailService.getRoleByRoleId(id_long);
				for (int j = 0; j < roleDetail.size(); j++) {
					String roleDetail_str = roleDetail.get(j).getPermission();
					list_roleDetail_str.add(roleDetail_str);
				}
				list_roleDetail_list.add(list_roleDetail_str);
			}
			model.setListRoleDetail(list_roleDetail_list);
			List<RoleDetailModel> roleDetail = roleDetailService.getRoleByUserName(userModel.getUserName());
			List<String> list_roleDetailCode_str = new ArrayList<>();
			for (int i = 0; i < roleDetail.size(); i++) {
				String roleDetailCode_str = roleDetail.get(i).getCode();
				list_roleDetailCode_str.add(roleDetailCode_str);
			}
			userModel.setListRoleDetailCode(list_roleDetailCode_str);
			view = "/views/admin/role/list-role.jsp";
		} else if (model.getType().equals("edit")) {
			if (model.getId() != null) {
				model = roleService.findOne(model.getId());
				List<String> listRoleDetail_str = new ArrayList<>();
				List<RoleDetailModel> roleDetail = roleDetailService.getRoleByRoleId(model.getId());
				for (int i = 0; i < roleDetail.size(); i++) {
					String roleDetail_str = roleDetail.get(i).getPermission();
					listRoleDetail_str.add(roleDetail_str);
				}
				model.setListStringRoleDetailName(listRoleDetail_str);
			}
			model.setListResult(roleService.findAllItem());
			request.setAttribute("roleDetails", roleDetailService.findAllItem());
			view = "/views/admin/role/edit-role.jsp";
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