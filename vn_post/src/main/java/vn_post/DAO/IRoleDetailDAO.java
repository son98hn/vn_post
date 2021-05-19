package vn_post.DAO;

import java.util.List;

import vn_post.model.RoleDetailModel;

public interface IRoleDetailDAO extends GenericDAO<RoleDetailModel> {

	List<RoleDetailModel> findAll();

}
