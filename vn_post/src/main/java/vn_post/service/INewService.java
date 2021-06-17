package vn_post.service;

import java.util.List;

import vn_post.model.NewModel;
import vn_post.paging.Pageble;

public interface INewService {
	List<NewModel> findByCategoryId(long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel updateNew);
	void delete(long [] ids);
	NewModel findOne(long id);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
	int getTotalItemByCategory(long categoryId);
	List<NewModel> findDescByCategoryId(Pageble pageble, long categoryId);
	List<NewModel> findDescByCategoryId1(long categoryId);
	List<NewModel> search(String title);
}