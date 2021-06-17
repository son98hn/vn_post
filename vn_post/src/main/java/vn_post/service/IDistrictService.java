package vn_post.service;

import java.util.List;

import vn_post.model.DistrictModel;
import vn_post.paging.Pageble;

public interface IDistrictService {
	DistrictModel save(DistrictModel districtModel);
	DistrictModel update(DistrictModel updateDistrict);
	void delete(long [] ids);
	DistrictModel findOne(long id);
	List<DistrictModel> findByProvinId(long provin_id);
	int getTotalItem();
	List<DistrictModel> findAllItem();
	List<DistrictModel> findAll(Pageble pageble);
	DistrictModel findOneByProvinId(long provinId);
}