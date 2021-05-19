package vn_post.DAO;

import java.util.List;

import vn_post.model.UserModel;
import vn_post.paging.Pageble;

public interface IUserDAO extends GenericDAO<UserModel> {

	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	List<UserModel> findAll(Pageble pageble);
	int getTotalItem();
	UserModel findOne(Long id);
	Long save(UserModel userModel);
	void update(UserModel updateUser);
	void delete(long id);
}