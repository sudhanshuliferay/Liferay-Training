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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LibraryStoreSoap implements Serializable {

	public static LibraryStoreSoap toSoapModel(LibraryStore model) {
		LibraryStoreSoap soapModel = new LibraryStoreSoap();

		soapModel.setLmsID(model.getLmsID());
		soapModel.setBookname(model.getBookname());
		soapModel.setIssueDate(model.getIssueDate());
		soapModel.setUploadedBy(model.getUploadedBy());
		soapModel.setIssueTo(model.getIssueTo());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setComapnyId(model.getComapnyId());
		soapModel.setUserId(model.getUserId());

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

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getComapnyId() {
		return _comapnyId;
	}

	public void setComapnyId(long comapnyId) {
		_comapnyId = comapnyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _lmsID;
	private String _bookname;
	private String _issueDate;
	private String _uploadedBy;
	private String _issueTo;
	private long _groupId;
	private long _comapnyId;
	private long _userId;

}