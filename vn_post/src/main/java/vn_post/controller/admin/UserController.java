package vn_post.controller.admin;

import java.io.IOException;
import java.rmi.ServerException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn_post.model.UserModel;
import vn_post.paging.PageRequest;
import vn_post.paging.Pageble;
import vn_post.service.IRoleDetailService;
import vn_post.service.IRoleService;
import vn_post.service.IUserService;
import vn_post.sort.Sorter;
import vn_post.util.FormUtil;
import vn_post.util.MessageUtil;

@WebServlet(urlPatterns = { "/admin-user" })
public class UserController extends HttpServlet {

	private static final long serialVersionUID = -3719472794256194864L;

	@Inject
	private IUserService userSerivce;

	@Inject
	private IRoleService roleService;

	@Inject
	private IRoleDetailService roleDetailService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		UserModel model = FormUtil.toModel(UserModel.class, request);
		String view = "";
		if (model.getType().equals("list")) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(userSerivce.findAll(pageble));
			model.setTotalItem(userSerivce.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			view = "/views/admin/tk/list-tk.jsp";
		} else if (model.getType().equals("edit")) {
			if (model.getId() != null) {
				model = userSerivce.findOne(model.getId());
			}
			request.setAttribute("roleDetails", roleDetailService.findAll());
			request.setAttribute("roles", roleService.findAll());
			view = "/views/admin/tk/edit-tk.jsp";
		}
		MessageUtil.showMessage(request);
		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {

	}

}