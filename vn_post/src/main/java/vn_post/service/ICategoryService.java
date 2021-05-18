package vn_post.service;

import java.util.List;

import vn_post.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	CategoryModel findOne(long id);
}
