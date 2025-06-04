package com.java.dao;

import java.util.List;

import com.java.model.Asset;

public interface AssetDao {

	String addAsset(Asset asset);

	List<Asset> showAsset();

	List<Asset> showAssetbyEmpId();

}
