package vn_post.DAO;

import java.util.List;

import vn_post.model.NewModel;
import vn_post.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {

	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	NewModel findOne(Long id);
	void update(NewModel updateNew);
	void delete(long id);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
	int getTotalItemByCategory(long categoryId);
	List<NewModel> findDescByCategoryId(Long categoryId);
}