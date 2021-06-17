package vn_post.DAO.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn_post.DAO.IDistrictDAO;
import vn_post.mapper.DistrictMapper;
import vn_post.model.DistrictModel;
import vn_post.paging.Pageble;

public class DistrictDAO extends AbstractDAO<DistrictModel> implements IDistrictDAO {

	@Override
	public DistrictModel findOne(long id) {
		String sql = "SELECT * FROM district WHERE id = ?";
		List<DistrictModel> district = query(sql, new DistrictMapper(), id);
		return district.isEmpty() ? null : district.get(0);
	}
	@Override
	public DistrictModel findOneByProvinId(long provin_id) {
		String sql = "SELECT * FROM district WHERE provin_id = ?";
		List<DistrictModel> district = query(sql, new DistrictMapper(), provin_id);
		return district.isEmpty() ? null : district.get(0);
	}
	@Override
	public List<DistrictModel> findAllItem() {
		String sql = "SELECT * FROM district";
		return query(sql, new DistrictMapper());
	}
	@Override
	public Long save(DistrictModel districtModel) {
		String sql = "INSERT INTO district (name, provin_id) VALUES(?, ?)";
		return insert(sql, districtModel.getName(), districtModel.getProvin_id());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM district WHERE id=?";
		this.update(sql, id);
	}

	@Override
	public void update(DistrictModel updateDistrict) {
		String sql = "UPDATE district SET name=?,  provin_id=? WHERE id = ?";
		update(sql, updateDistrict.getName(), updateDistrict.getProvin_id(), updateDistrict.getId());
	}

	@Override
	public List<DistrictModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM district");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), new DistrictMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM district";
		return count(sql);
	}

	@Override
	public List<DistrictModel> findByProvinId(long provin_id) {
		String sql = "SELECT * FROM district WHERE provin_id=?";
		return query(sql, new DistrictMapper(), provin_id);
	}

}