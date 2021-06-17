package vn_post.controller.web;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn_post.model.GroupRoleDetailModel;
import vn_post.model.GroupRoleModel;
import vn_post.model.GroupRoleUserModel;
import vn_post.model.NewModel;
import vn_post.model.RoleDetailModel;
import vn_post.model.UserModel;
import vn_post.paging.PageRequest;
import vn_post.paging.Pageble;
import vn_post.service.IGroupRoleDetailService;
import vn_post.service.IGroupRoleService;
import vn_post.service.IGroupRoleUserService;
import vn_post.service.INewService;
import vn_post.service.IUserService;
import vn_post.sort.Sorter;
import vn_post.util.FormUtil;
import vn_post.util.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat" })
public class HomeController extends HttpServlet {

	@Inject
	private IUserService userService;

	@Inject
	private INewService newSerivce;
	
	@Inject
	private IGroupRoleUserService groupRoleUserService;
	
	@Inject
	private IGroupRoleDetailService groupRoleDetailService;
	
	@Inject
	private IGroupRoleService groupRoleService;
	
	
	
	private static final long serialVersionUID = 1474661389573806532L;

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		NewModel model = FormUtil.toModel(NewModel.class, request);
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if (message != null & alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		} else {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(newSerivce.findAll(pageble));
			request.setAttribute("model", model);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, request);
			model = userService.findByUserNameAndPassword(model.getUserName(), model.getPassword());
			if (model != null) {
				SessionUtil.getInstance().putValue(request, "USERMODEL", model);
				if (model.getGroupRoleCode().equals("user")) {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				} else if (model.getGroupRoleCode().equals("admin")) {
					response.sendRedirect(request.getContextPath() + "/admin-home");
				}
			} else {
				response.sendRedirect(request.getContextPath()
						+ "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
		}
	}
}
