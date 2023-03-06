/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lms.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.lms.service.http.LibraryStoreServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LibraryStoreSoap implements Serializable {

	public static LibraryStoreSoap toSoapModel(LibraryStore model) {
		LibraryStoreSoap soapModel = new LibraryStoreSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setLmsID(model.getLmsID());
		soapModel.setBookname(model.getBookname());
		soapModel.setIssueDate(model.getIssueDate());
		soapModel.setUploadedBy(model.getUploadedBy());
		soapModel.setIssueTo(model.getIssueTo());
		soapModel.setAuthorName(model.getAuthorName());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static LibraryStoreSoap[] toSoapModels(LibraryStore[] models) {
		LibraryStoreSoap[] soapModels = new LibraryStoreSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LibraryStoreSoap[][] toSoapModels(LibraryStore[][] models) {
		LibraryStoreSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LibraryStoreSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LibraryStoreSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LibraryStoreSoap[] toSoapModels(List<LibraryStore> models) {
		List<LibraryStoreSoap> soapModels = new ArrayList<LibraryStoreSoap>(
			models.size());

		for (LibraryStore model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LibraryStoreSoap[soapModels.size()]);
	}

	public LibraryStoreSoap() {
	}

	public long getPrimaryKey() {
		return _lmsID;
	}

	public void setPrimaryKey(long pk) {
		setLmsID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getLmsID() {
		return _lmsID;
	}

	public void setLmsID(long lmsID) {
		_lmsID = lmsID;
	}

	public String getBookname() {
		return _bookname;
	}

	public void setBookname(String bookname) {
		_bookname = bookname;
	}

	public String getIssueDate() {
		return _issueDate;
	}

	public void setIssueDate(String issueDate) {
		_issueDate = issueDate;
	}

	public String getUploadedBy() {
		return _uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		_uploadedBy = uploadedBy;
	}

	public String getIssueTo() {
		return _issueTo;
	}

	public void setIssueTo(String issueTo) {
		_issueTo = issueTo;
	}

	public String getAuthorName() {
		return _authorName;
	}

	public void setAuthorName(String authorName) {
		_authorName = authorName;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private String _uuid;
	private long _lmsID;
	private String _bookname;
	private String _issueDate;
	private String _uploadedBy;
	private String _issueTo;
	private String _authorName;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _createdDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

}