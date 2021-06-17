package vn_post.model;

import java.util.ArrayList;
import java.util.List;

public class ProvinModel extends AbstractModel<ProvinModel> {
	private String name;
	private List<String> listDistrict = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getListDistrict() {
		return listDistrict;
	}

	public void setListDistrict(List<String> listDistrict) {
		this.listDistrict = listDistrict;
	}
}
