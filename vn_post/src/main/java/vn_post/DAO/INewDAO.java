package vn_post.DAO;

import java.util.List;

import vn_post.model.NewModel;
import vn_post.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {

	List<NewModel> findByCategoryId(Long categoryId);
	
	NewModel findOne(long id);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
	int getTotalItemByCategory(long categoryId);
	List<NewModel> findDescByCategoryId(Pageble pageble, long categoryId);
	List<NewModel> findDescByCategoryId1(long categoryId);
	List<NewModel> search(String title);
}