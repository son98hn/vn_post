package vn_post.service.impl;

import java.util.List;

import javax.inject.Inject;

import vn_post.DAO.IDistrictDAO;
import vn_post.model.DistrictModel;
import vn_post.model.UserModel;
import vn_post.paging.Pageble;
import vn_post.service.IDistrictService;

public class DistrictService implements IDistrictService {

	@Inject
	private IDistrictDAO districtDao;

	@Override
	public DistrictModel save(DistrictModel districtModel) {
		Long districtId = districtDao.save(districtModel);
		return districtDao.findOne(districtId);
	}

	@Override
	public DistrictModel update(DistrictModel updateDistrict) {
		districtDao.update(updateDistrict);
		return districtDao.findOne(updateDistrict.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			districtDao.delete(id);
		}
	}

	@Override
	public List<DistrictModel> findAll(Pageble pageble) {
		return districtDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return districtDao.getTotalItem();
	}

	@Override
	public DistrictModel findOne(long id) {
		DistrictModel districtModel = districtDao.findOne(id);
		return districtModel;
	}
	@Override
	public List<DistrictModel> findByProvinId(long provin_id) {
		return districtDao.findByProvinId(provin_id);
	}

	@Override
	public List<DistrictModel> findAllItem() {
		return districtDao.findAllItem();
	}

	@Override
	public DistrictModel findOneByProvinId(long provinId) {
		// TODO Auto-generated method stub
		return districtDao.findOneByProvinId(provinId);
	}


}