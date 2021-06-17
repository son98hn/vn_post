package vn_post.DAO.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn_post.DAO.IProvinDAO;
import vn_post.mapper.ProvinMapper;
import vn_post.model.ProvinModel;
import vn_post.paging.Pageble;

public class ProvinDAO extends AbstractDAO<ProvinModel> implements IProvinDAO {

	@Override
	public ProvinModel findOne(long id) {
		String sql = "SELECT * FROM provin WHERE id = ?";
		List<ProvinModel> provin = query(sql, new ProvinMapper(), id);
		return provin.isEmpty() ? null : provin.get(0);
	}

	@Override
	public Long save(ProvinModel provinModel) {
		String sql = "INSERT INTO provin (name) VALUES(?)";
		return insert(sql, provinModel.getName());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM provin WHERE id=?";
		this.update(sql, id);
	}

	@Override
	public void update(ProvinModel updateProvin) {
		String sql = "UPDATE provin SET name=? WHERE id = ?";
		update(sql, updateProvin.getName(), updateProvin.getId());
	}
	
	@Override
	public List<ProvinModel> findAllItem() {
		String sql = "SELECT * FROM provin";
		return query(sql, new ProvinMapper());
	}

	@Override
	public List<ProvinModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM provin");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), new ProvinMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM provin";
		return count(sql);
	}

}