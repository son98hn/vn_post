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

import vn_post.model.NewModel;
import vn_post.service.INewService;
import vn_post.util.FormUtil;

@WebServlet(urlPatterns = { "/buu-chinh-chuyen-phat" })
public class BuuChinhChuyenPhatController extends HttpServlet {

	@Inject
	private INewService newSerivce;
	private static final long serialVersionUID = 1474661389573806532L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		NewModel model = FormUtil.toModel(NewModel.class, request);
		model.setListResult(newSerivce.findByCategoryId((long) 5));
		model.setTotalItem(newSerivce.getTotalItemByCategory((long) 5));
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/buu-chinh-chuyen-phat.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {

	}
}
