package vn_post.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import vn_post.model.ProvinModel;

public class ProvinMapper implements RowMapper<ProvinModel> {

	@Override
	public ProvinModel mapRow(ResultSet resultSet) {
		try {
			ProvinModel provin = new ProvinModel();
			provin.setId(resultSet.getLong("id"));
			provin.setName(resultSet.getString("name"));
			return provin;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
