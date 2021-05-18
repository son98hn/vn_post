package vn_post.controller.web;

import java.io.IOException;
import java.rmi.ServerException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn_post.model.CategoryModel;
import vn_post.model.NewModel;
import vn_post.paging.PageRequest;
import vn_post.paging.Pageble;
import vn_post.service.ICategoryService;
import vn_post.service.INewService;
import vn_post.sort.Sorter;
import vn_post.util.FormUtil;

@WebServlet(urlPatterns = { "/nhom-bai-viet" })
public class NhomBaiVietController extends HttpServlet {

	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewService newSerivce;
	private static final long serialVersionUID = 1474661389573806532L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		NewModel model = FormUtil.toModel(NewModel.class, request);
		CategoryModel category = FormUtil.toModel(CategoryModel.class, request);
		category.setListResult(categoryService.findAll());
		request.setAttribute("categories", category);
		model.setListResult(newSerivce.findDescByCategoryId(model.getCategoryId()));
		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/nhom-bai-viet.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {

	}
}
