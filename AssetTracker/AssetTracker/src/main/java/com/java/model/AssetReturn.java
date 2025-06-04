package com.java.model;

import java.util.Date;

public class AssetReturn {
	
	private int assetReturnId;
	
//	user id
	
	private User requestByUserid;
	
//	asset ID
	
	public User getRequestByUserid() {
		return requestByUserid;
	}

	public void setRequestByUserid(User requestByUserid) {
		this.requestByUserid = requestByUserid;
	}

	private Asset returnAssetId;
	
	private Date returnDate;
	
	

	public int getAssetReturnId() {
		return assetReturnId;
	}

	public void setAssetReturnId(int assetReturnId) {
		this.assetReturnId = assetReturnId;
	}

	

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}



	public Asset getReturnAsset() {
		return returnAssetId;
	}

	public void setReturnAsset(Asset returnAssetId) {
		this.returnAssetId = returnAssetId;
	}

	public Asset getReturnAssetId() {
		return returnAssetId;
	}

	public void setReturnAssetId(Asset returnAssetId) {
		this.returnAssetId = returnAssetId;
	}
	

	
	
}
