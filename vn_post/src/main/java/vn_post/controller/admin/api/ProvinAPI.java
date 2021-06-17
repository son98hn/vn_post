package vn_post.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn_post.model.ProvinModel;
import vn_post.service.IProvinService;
import vn_post.util.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-provin" })
public class ProvinAPI extends HttpServlet {

	@Inject
	private IProvinService provinService;

	private static final long serialVersionUID = 1112448464061133945L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		ProvinModel provinModel = HttpUtil.of(request.getReader()).toModel(ProvinModel.class);
		provinModel = provinService.save(provinModel);
		mapper.writeValue(response.getOutputStream(), provinModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ProvinModel updateProvin = HttpUtil.of(request.getReader()).toModel(ProvinModel.class);
		updateProvin = provinService.update(updateProvin);
		mapper.writeValue(response.getOutputStream(), updateProvin);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		ProvinModel provinModel = HttpUtil.of(request.getReader()).toModel(ProvinModel.class);
		provinService.delete(provinModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}