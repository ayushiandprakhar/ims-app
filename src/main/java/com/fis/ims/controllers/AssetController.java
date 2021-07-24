package com.fis.ims.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.ims.entities.Asset;
import com.fis.ims.entities.User;
import com.fis.ims.services.AssetService;	
import com.fis.ims.services.UserService;

@RestController
@RequestMapping("/api/ims")
public class AssetController {

	@Autowired
	UserService userService;

	@Autowired
	AssetService assetService;

	@GetMapping("/getAsset")
	public ResponseEntity<List<Asset>> getAllAssets() {
		List<Asset> assetList = assetService.getAllAssets();
		return new ResponseEntity<List<Asset>>(assetList, HttpStatus.OK);
	}

	@PostMapping("/createAsset")
	public ResponseEntity<Asset> createAsset(@Valid @RequestBody Asset asset) {
		if (asset.getAllocatedTo() != null) {
			User user = userService.getUserbyId(asset.getAllocatedTo());
			asset.setUser(user);
			asset.setAllocated(true);
		}
		Asset saveAsset = assetService.create(asset);
		asset.setAllocated(false);
		return new ResponseEntity<Asset>(saveAsset, HttpStatus.CREATED);
	}

}
