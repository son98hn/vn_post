package vn_post.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn_post.model.DistrictModel;
import vn_post.service.IDistrictService;
import vn_post.util.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-district" })
public class DistrictAPI extends HttpServlet {

//	Gọi hàm service
	@Inject
	private IDistrictService districtService;

	private static final long serialVersionUID = 1112448464061133945L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		DistrictModel districtModel = HttpUtil.of(request.getReader()).toModel(DistrictModel.class);
		districtModel = districtService.save(districtModel);
		mapper.writeValue(response.getOutputStream(), districtModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		DistrictModel updateDistrict = HttpUtil.of(request.getReader()).toModel(DistrictModel.class);
		updateDistrict = districtService.update(updateDistrict);
		mapper.writeValue(response.getOutputStream(), updateDistrict);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/application/json");
		DistrictModel districtModel = HttpUtil.of(request.getReader()).toModel(DistrictModel.class);
		districtService.delete(districtModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}