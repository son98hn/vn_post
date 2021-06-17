package vn_post.service;

import java.util.List;

import vn_post.model.UserModel;
import vn_post.paging.Pageble;

public interface IUserService {
	UserModel findByUserNameAndPassword(String userName, String password);
	int getTotalItem();
	UserModel findOne(long id);
	
	UserModel save(UserModel userModel);
	UserModel update(UserModel updateUser);
	void delete(long [] ids);
	List<UserModel> getRoleByUserName( String userName);
	List<UserModel> findAllItem();
	List<UserModel> findAll(Pageble pageble);
}