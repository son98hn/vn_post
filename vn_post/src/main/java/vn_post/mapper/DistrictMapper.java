package vn_post.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import vn_post.model.DistrictModel;

public class DistrictMapper implements RowMapper<DistrictModel> {

	@Override
	public DistrictModel mapRow(ResultSet resultSet) {
		try {
			DistrictModel district = new DistrictModel();
			district.setId(resultSet.getLong("id"));
			district.setName(resultSet.getString("name"));
			district.setProvin_id(resultSet.getLong("provin_id"));
			return district;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
