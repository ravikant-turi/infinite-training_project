package com.java.model;

import java.util.Date;

public class AssetRequest {

	private int requestId;

//	user Id

	private User requestByUserId;

//	AssetId

	private Asset assetRequestId;

	private RequestStatus requestStatus;

	private Date assignedDate;

	public User getRequestByUserId() {
		return requestByUserId;
	}

	public void setRequestByUserId(User requestByUserId) {
		this.requestByUserId = requestByUserId;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Asset getAssetRequestId() {
		return assetRequestId;
	}

	public void setAssetRequestId(Asset assetRequestId) {
		this.assetRequestId = assetRequestId;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public AssetRequest() {
		this.requestStatus = RequestStatus.PENDING;
	}

}
