package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.IProvinDAO;
import vn_post.model.ProvinModel;
import vn_post.paging.Pageble;
import vn_post.service.IProvinService;

public class ProvinService implements IProvinService {

	@Inject
	private IProvinDAO provinDao;

	@Override
	public ProvinModel save(ProvinModel provinModel) {
		Long provinId = provinDao.save(provinModel);
		return provinDao.findOne(provinId);
	}

	@Override
	public ProvinModel update(ProvinModel updateProvin) {
		provinDao.update(updateProvin);
		return provinDao.findOne(updateProvin.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			provinDao.delete(id);
		}
	}

	@Override
	public List<ProvinModel> findAll(Pageble pageble) {
		return provinDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return provinDao.getTotalItem();
	}

	@Override
	public ProvinModel findOne(long id) {
		ProvinModel provinModel = provinDao.findOne(id);
		
		return provinModel;
	}

	@Override
	public List<ProvinModel> findAllItem() {
		return provinDao.findAllItem();
	}

}