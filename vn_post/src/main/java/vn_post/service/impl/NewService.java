package vn_post.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.ICategoryDAO;
import vn_post.DAO.INewDAO;
import vn_post.model.CategoryModel;
import vn_post.model.NewModel;
import vn_post.paging.Pageble;
import vn_post.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao;

	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<NewModel> findByCategoryId(long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDao.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getId());
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDao.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newDao.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

	@Override
	public NewModel findOne(long id) {
		NewModel newModel = newDao.findOne(id);
		CategoryModel categoryModel = categoryDao.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}

	@Override
	public int getTotalItemByCategory(long categoryId) {
		return newDao.getTotalItemByCategory(categoryId);
	}

	@Override
	public List<NewModel> findDescByCategoryId(Pageble pageble, long categoryId) {
		return newDao.findDescByCategoryId(pageble, categoryId);
	}

	@Override
	public List<NewModel> findDescByCategoryId1(long categoryId) {
		return newDao.findDescByCategoryId1(categoryId);
	}

	@Override
	public List<NewModel> search(String title) {
		return newDao.search(title);
	}

}