package vn_post.model;

public class DistrictModel extends AbstractModel<DistrictModel> {
	private String name;
	private Long provin_id;
	private String provin_name;
	
	public String getProvin_name() {
		return provin_name;
	}
	public void setProvin_name(String provin_name) {
		this.provin_name = provin_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getProvin_id() {
		return provin_id;
	}
	public void setProvin_id(Long provin_id) {
		this.provin_id = provin_id;
	}
	
}
