package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.ICategoryDAO;
import vn_post.model.CategoryModel;
import vn_post.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public CategoryModel findOne(long id) {
		
		return categoryDAO.findOne(id);
	}
}
