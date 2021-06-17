package vn_post.DAO;

import java.util.List;

import vn_post.model.DistrictModel;
import vn_post.paging.Pageble;

public interface IDistrictDAO extends GenericDAO<DistrictModel> {

	List<DistrictModel> findByProvinId(long provin_id);
	DistrictModel findOne(long id);
	DistrictModel findOneByProvinId(long provin_id);
	Long save(DistrictModel districtModel);
	void update(DistrictModel updateDistrict);
	void delete(long id);
	List<DistrictModel> findAll(Pageble pageble);
	int getTotalItem();
	List<DistrictModel> findAllItem();
}