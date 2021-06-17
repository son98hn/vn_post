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
import vn_post.sort.Sorter;
import vn_post.util.FormUtil;
import vn_post.util.MessageUtil;
import vn_post.util.SessionUtil;

@WebServlet(urlPatterns = { "/admin-grouprole" })
public class GroupRoleController extends HttpServlet {

	private static final long serialVersionUID = -3719472794256194864L;

	@Inject
	private IGroupRoleService groupRoleService;
	@Inject
	private IRoleDetailService roleDetailService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		GroupRoleModel model = FormUtil.toModel(GroupRoleModel.class, request);
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		String view = "";
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
				new Sorter(model.getSortName(), model.getSortBy()));
		if (model.getType().equals("list")) {
			model.setListResult(groupRoleService.findAll(pageble));
			model.setTotalItem(groupRoleService.getTotalItem());
			request.setAttribute("roleDetails", roleDetailService.findAllItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			List<GroupRoleModel> listGroupRole = groupRoleService.findAll(pageble);
			List<List> list_roleDetail_list = new ArrayList<>();
			for (int i = 0; i < listGroupRole.size(); i++) {
				List<String> list_roleDetail_str = new ArrayList<>();
				Long id_long = listGroupRole.get(i).getId();
				List<RoleDetailModel> roleDetail = roleDetailService.getRoleByGroupRoleId(id_long);
				for (int j = 0; j < roleDetail.size(); j++) {
					String roleDetail_str = roleDetail.get(j).getPermission();
					list_roleDetail_str.add(roleDetail_str);
				}
				list_roleDetail_list.add(list_roleDetail_str);
			}
			model.setListRoleDetailName(list_roleDetail_list);
			List<RoleDetailModel> roleDetail = roleDetailService.getRoleByUserName(userModel.getUserName());
			List <String> list_roleDetailCode_str = new ArrayList<>();
			for (int i = 0; i < roleDetail.size(); i++) {
				String roleDetailCode_str = roleDetail.get(i).getCode();
				list_roleDetailCode_str.add(roleDetailCode_str);
			}
			userModel.setListRoleDetailCode(list_roleDetailCode_str);
			view = "/views/admin/grouprole/list-grouprole.jsp";
		} else if (model.getType().equals("edit")) {
			if (model.getId() != null) {
				model = groupRoleService.findOne(model.getId());
				List<String> list_roleDetail_str = new ArrayList<>();
				List<RoleDetailModel> roleDetail = roleDetailService.getRoleByGroupRoleId(model.getId());
				for (int i = 0; i < roleDetail.size(); i++) {
					String roleDetail_str = roleDetail.get(i).getPermission();
					list_roleDetail_str.add(roleDetail_str);
				}
				model.setListStringRoleDetailName(list_roleDetail_str);
			}
			model.setListResult(groupRoleService.findAllItem());
			request.setAttribute("roleDetails", roleDetailService.findAllItem());
			view = "/views/admin/grouprole/edit-grouprole.jsp";
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