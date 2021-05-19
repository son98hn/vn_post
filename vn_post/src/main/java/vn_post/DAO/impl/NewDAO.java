package vn_post.DAO.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn_post.DAO.INewDAO;
import vn_post.mapper.NewMapper;
import vn_post.model.NewModel;
import vn_post.paging.Pageble;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM new WHERE categoryid=?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public NewModel findOne(long id) {
		String sql = "SELECT * FROM new WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public Long save(NewModel newModel) {
		String sql = "INSERT INTO new (title, content, categoryid, thumbnail, shortdescription, createddate, createdby) VALUES(?, ?, ?, ?, ?, ?, ?)";
		return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryId(),
				newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCreatedDate(),
				newModel.getCreatedBy());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM new WHERE id=?";
		this.update(sql, id);
	}

	@Override
	public void update(NewModel updateNew) {
		String sql = "UPDATE new SET title=?, thumbnail=?,shortdescription=?, content=?, categoryid=?, createddate=?, createdby=? WHERE id = ?";
		update(sql, updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), updateNew.getCreatedBy(),
				updateNew.getId());
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM new");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("OFFSET " + pageble.getOffset() + " ROWS FETCH NEXT " + pageble.getLimit() + " ROWS ONLY");
		}
		return query(sql.toString(), new NewMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM new";
		return count(sql);
	}

	@Override
	public int getTotalItemByCategory(long categoryId) {
		String sql = "SELECT count(*) FROM new WHERE categoryid = ?";
		return count(sql);
	}

	@Override
	public List<NewModel> findDescByCategoryId(long categoryId) {
		String sql = "SELECT * FROM new WHERE categoryid = ? order by createddate desc";
		return query(sql, new NewMapper(), categoryId);
	}
}