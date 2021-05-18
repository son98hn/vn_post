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

@WebServlet(urlPatterns = { "/tin-tuc" })
public class TintucController extends HttpServlet {

	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewService newSerivce;
	private static final long serialVersionUID = 1474661389573806532L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		NewModel model = FormUtil.toModel(NewModel.class, request);
		NewModel model1 = FormUtil.toModel(NewModel.class, request);
		NewModel model2 = FormUtil.toModel(NewModel.class, request);
		NewModel model3 = FormUtil.toModel(NewModel.class, request);
		NewModel model4 = FormUtil.toModel(NewModel.class, request);
		CategoryModel category = FormUtil.toModel(CategoryModel.class, request);
		
		category.setListResult(categoryService.findAll());
		request.setAttribute("model", model);
		request.setAttribute("categories", category);
		model1.setListResult(newSerivce.findDescByCategoryId((long) 1));
		request.setAttribute("model1", model1);
		model2.setListResult(newSerivce.findDescByCategoryId((long) 2));
		request.setAttribute("model2", model2);
		model3.setListResult(newSerivce.findDescByCategoryId((long) 3));
		request.setAttribute("model3", model3);
		model4.setListResult(newSerivce.findDescByCategoryId((long) 4));
		request.setAttribute("model4", model4);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/tin-tuc.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {

	}
}
