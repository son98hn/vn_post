package vn_post.DAO;

import java.util.List;

import vn_post.model.ProvinModel;
import vn_post.paging.Pageble;

public interface IProvinDAO extends GenericDAO<ProvinModel> {
	
	ProvinModel findOne(long id);
	Long save(ProvinModel provinModel);
	void update(ProvinModel updateProvin);
	void delete(long id);
	List<ProvinModel> findAll(Pageble pageble);
	List<ProvinModel> findAllItem();
	int getTotalItem();
}