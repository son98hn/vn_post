package vn_post.service;

import java.util.List;

import vn_post.model.UserModel;
import vn_post.paging.Pageble;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	int getTotalItem();
	UserModel findOne(long id);
	List<UserModel> findAll(Pageble pageble);
	UserModel save(UserModel userModel);
	UserModel update(UserModel updateUser);
	void delete(long [] ids);
}