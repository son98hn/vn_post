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

import vn_post.model.NewModel;
import vn_post.model.RoleDetailModel;
import vn_post.model.UserModel;
import vn_post.paging.PageRequest;
import vn_post.paging.Pageble;
import vn_post.service.ICategoryService;
import vn_post.service.INewService;
import vn_post.service.IRoleDetailService;
import vn_post.sort.Sorter;
import vn_post.util.FormUtil;
import vn_post.util.MessageUtil;
import vn_post.util.SessionUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {

	private static final long serialVersionUID = -3719472794256194864L;

	@Inject
	private INewService newSerivce;

	@Inject
	private ICategoryService categoryService;

	@Inject
	private IRoleDetailService roleDetailService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		NewModel model = FormUtil.toModel(NewModel.class, request);
		String view = "";
		if (model.getType().equals("list")) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(newSerivce.findAll(pageble));
			model.setTotalItem(newSerivce.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/new/list.jsp";
			List<RoleDetailModel> roleDetail = roleDetailService.getRoleByUserName(userModel.getUserName());
			List<String> list_roleDetailCode_str = new ArrayList<>();
			for (int i = 0; i < roleDetail.size(); i++) {
				String roleDetailCode_str = roleDetail.get(i).getCode();
				list_roleDetailCode_str.add(roleDetailCode_str);
			}
			userModel.setListRoleDetailCode(list_roleDetailCode_str);
		} else if (model.getType().equals("edit")) {
			if (model.getId() != null) {
				model = newSerivce.findOne(model.getId());
			}
			request.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/new/edit.jsp";
		} else {
			String title = request.getParameter("search");
			List<NewModel> listNewModel = newSerivce.search(title);
			request.setAttribute("${model.listResult}", listNewModel);
			model.setTotalItem(newSerivce.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			List<RoleDetailModel> roleDetail = roleDetailService.getRoleByUserName(userModel.getUserName());
			List<String> list_roleDetailCode_str = new ArrayList<>();
			for (int i = 0; i < roleDetail.size(); i++) {
				String roleDetailCode_str = roleDetail.get(i).getCode();
				list_roleDetailCode_str.add(roleDetailCode_str);
			}
			userModel.setListRoleDetailCode(list_roleDetailCode_str);
			view = "/views/admin/new/list.jsp";
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