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

package com.lms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.lms.model.LibraryStore;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LibraryStore in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LibraryStoreCacheModel
	implements CacheModel<LibraryStore>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LibraryStoreCacheModel)) {
			return false;
		}

		LibraryStoreCacheModel libraryStoreCacheModel =
			(LibraryStoreCacheModel)object;

		if (lmsID == libraryStoreCacheModel.lmsID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lmsID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{lmsID=");
		sb.append(lmsID);
		sb.append(", bookname=");
		sb.append(bookname);
		sb.append(", issueDate=");
		sb.append(issueDate);
		sb.append(", uploadedBy=");
		sb.append(uploadedBy);
		sb.append(", issueTo=");
		sb.append(issueTo);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", comapnyId=");
		sb.append(comapnyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LibraryStore toEntityModel() {
		LibraryStoreImpl libraryStoreImpl = new LibraryStoreImpl();

		libraryStoreImpl.setLmsID(lmsID);

		if (bookname == null) {
			libraryStoreImpl.setBookname("");
		}
		else {
			libraryStoreImpl.setBookname(bookname);
		}

		if (issueDate == null) {
			libraryStoreImpl.setIssueDate("");
		}
		else {
			libraryStoreImpl.setIssueDate(issueDate);
		}

		if (uploadedBy == null) {
			libraryStoreImpl.setUploadedBy("");
		}
		else {
			libraryStoreImpl.setUploadedBy(uploadedBy);
		}

		if (issueTo == null) {
			libraryStoreImpl.setIssueTo("");
		}
		else {
			libraryStoreImpl.setIssueTo(issueTo);
		}

		libraryStoreImpl.setGroupId(groupId);
		libraryStoreImpl.setComapnyId(comapnyId);
		libraryStoreImpl.setUserId(userId);

		libraryStoreImpl.resetOriginalValues();

		return libraryStoreImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lmsID = objectInput.readLong();
		bookname = objectInput.readUTF();
		issueDate = objectInput.readUTF();
		uploadedBy = objectInput.readUTF();
		issueTo = objectInput.readUTF();

		groupId = objectInput.readLong();

		comapnyId = objectInput.readLong();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(lmsID);

		if (bookname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bookname);
		}

		if (issueDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(issueDate);
		}

		if (uploadedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uploadedBy);
		}

		if (issueTo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(issueTo);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(comapnyId);

		objectOutput.writeLong(userId);
	}

	public long lmsID;
	public String bookname;
	public String issueDate;
	public String uploadedBy;
	public String issueTo;
	public long groupId;
	public long comapnyId;
	public long userId;

}