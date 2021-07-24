package com.fis.ims.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.ims.entities.Asset;
import com.fis.ims.entities.User;
import com.fis.ims.repositories.AssetRepository;
import com.fis.ims.repositories.UserRespository;

@Service
public class AssetService {

	@Autowired
	AssetRepository assetRepository;

	@Autowired
	UserRespository userRespository;

	public List<Asset> getAllAssets() {
		return assetRepository.findAll();
	}

	public Asset create(Asset asset) {
		return assetRepository.save(asset);
	}

	public boolean allocateAsset(String assetId, String employeeId) {
		Asset asset = assetRepository.getByAssetId(assetId);
		if (asset.isAllocated() == false && asset.getQuantity() > 0) {
			User user = userRespository.findByEmployeeId(employeeId);
			asset.setUser(user);
			asset.setAllocated(true);
			return true;
		}
		return false;
	}

}
