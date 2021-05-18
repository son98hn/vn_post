package vn_post.DAO;

import vn_post.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {

	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);

}