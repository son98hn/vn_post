package vn_post.service.impl;

import javax.inject.Inject;

import vn_post.DAO.IUserDAO;
import vn_post.model.UserModel;
import vn_post.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDao;
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDao.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

}
