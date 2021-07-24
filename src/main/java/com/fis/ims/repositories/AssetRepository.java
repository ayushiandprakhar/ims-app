package com.fis.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ims.entities.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

	Asset getByAssetId(String assetId);
}
