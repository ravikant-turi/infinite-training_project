package com.java.controller;




import java.util.List;

import com.java.dao.AssetDao;
import com.java.model.Asset;
import lombok.Data;

@Data 
public class AssetController {
    
    private Asset asset = new Asset(); // ensure it's not null
    private AssetDao assetdao;

    public List<Asset> getShowAssetAll() {
        return assetdao.showAsset();
    }

    
    public String addAllAsset() {
       return assetdao.addAsset(asset); // pass the actual Asset object
       
    }
}
