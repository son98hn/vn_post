package vn_post.service;

import java.util.List;

import vn_post.model.ProvinModel;
import vn_post.paging.Pageble;

public interface IProvinService {
	ProvinModel save(ProvinModel provinModel);
	ProvinModel update(ProvinModel updateProvin);
	void delete(long [] ids);
	ProvinModel findOne(long id);
	List<ProvinModel> findAll(Pageble pageble);
	List<ProvinModel> findAllItem();
	int getTotalItem();
}