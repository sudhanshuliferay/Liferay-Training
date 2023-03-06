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

import java.util.Date;

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
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", lmsID=");
		sb.append(lmsID);
		sb.append(", bookname=");
		sb.append(bookname);
		sb.append(", issueDate=");
		sb.append(issueDate);
		sb.append(", uploadedBy=");
		sb.append(uploadedBy);
		sb.append(", issueTo=");
		sb.append(issueTo);
		sb.append(", authorName=");
		sb.append(authorName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LibraryStore toEntityModel() {
		LibraryStoreImpl libraryStoreImpl = new LibraryStoreImpl();

		if (uuid == null) {
			libraryStoreImpl.setUuid("");
		}
		else {
			libraryStoreImpl.setUuid(uuid);
		}

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

		if (authorName == null) {
			libraryStoreImpl.setAuthorName("");
		}
		else {
			libraryStoreImpl.setAuthorName(authorName);
		}

		libraryStoreImpl.setGroupId(groupId);
		libraryStoreImpl.setCompanyId(companyId);
		libraryStoreImpl.setUserId(userId);

		if (userName == null) {
			libraryStoreImpl.setUserName("");
		}
		else {
			libraryStoreImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			libraryStoreImpl.setCreateDate(null);
		}
		else {
			libraryStoreImpl.setCreateDate(new Date(createDate));
		}

		if (createdDate == Long.MIN_VALUE) {
			libraryStoreImpl.setCreatedDate(null);
		}
		else {
			libraryStoreImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			libraryStoreImpl.setModifiedDate(null);
		}
		else {
			libraryStoreImpl.setModifiedDate(new Date(modifiedDate));
		}

		libraryStoreImpl.setStatus(status);
		libraryStoreImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			libraryStoreImpl.setStatusByUserName("");
		}
		else {
			libraryStoreImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			libraryStoreImpl.setStatusDate(null);
		}
		else {
			libraryStoreImpl.setStatusDate(new Date(statusDate));
		}

		libraryStoreImpl.resetOriginalValues();

		return libraryStoreImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		lmsID = objectInput.readLong();
		bookname = objectInput.readUTF();
		issueDate = objectInput.readUTF();
		uploadedBy = objectInput.readUTF();
		issueTo = objectInput.readUTF();
		authorName = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

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

		if (authorName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(authorName);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long lmsID;
	public String bookname;
	public String issueDate;
	public String uploadedBy;
	public String issueTo;
	public String authorName;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long createdDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}