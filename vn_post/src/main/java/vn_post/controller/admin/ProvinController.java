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

import vn_post.model.DistrictModel;
import vn_post.model.ProvinModel;
import vn_post.model.RoleDetailModel;
import vn_post.model.UserModel;
import vn_post.paging.PageRequest;
import vn_post.paging.Pageble;
import vn_post.service.IDistrictService;
import vn_post.service.IProvinService;
import vn_post.service.IRoleDetailService;
import vn_post.sort.Sorter;
import vn_post.util.FormUtil;
import vn_post.util.MessageUtil;
import vn_post.util.SessionUtil;

@WebServlet(urlPatterns = { "/admin-provin" })
public class ProvinController extends HttpServlet {

	private static final long serialVersionUID = -3719472794256194864L;

	@Inject
	private IProvinService provinService;
	@Inject
	private IRoleDetailService roleDetailService;
	@Inject
	private IDistrictService districtService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ProvinModel model = FormUtil.toModel(ProvinModel.class, request);
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		String view = "";
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
				new Sorter(model.getSortName(), model.getSortBy()));
		if (model.getType().equals("list")) {
			model.setListResult(provinService.findAll(pageble));
			model.setTotalItem(provinService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			List<RoleDetailModel> roleDetail = roleDetailService.getRoleByUserName(userModel.getUserName());
			List<String> list_roleDetailCode_str = new ArrayList<>();
			for (int i = 0; i < roleDetail.size(); i++) {
				String roleDetailCode_str = roleDetail.get(i).getCode();
				list_roleDetailCode_str.add(roleDetailCode_str);
			}
			userModel.setListRoleDetailCode(list_roleDetailCode_str);
			view = "/views/admin/provin/list-provin.jsp";
		} else if (model.getType().equals("edit")) {
			if (model.getId() != null) {
				model = provinService.findOne(model.getId());
				List<DistrictModel> districtModel = districtService.findByProvinId(model.getId());
				List<String> list_district_str = new ArrayList<>();
				for(int i=0;i<districtModel.size();i++) {
					String district_str = districtModel.get(i).getName();
					list_district_str.add(district_str);
				}
				model.setListDistrict(list_district_str);
			}
			view = "/views/admin/provin/edit-provin.jsp";
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