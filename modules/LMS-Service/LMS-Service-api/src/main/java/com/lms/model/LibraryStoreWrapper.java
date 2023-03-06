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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LibraryStore}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryStore
 * @generated
 */
public class LibraryStoreWrapper
	extends BaseModelWrapper<LibraryStore>
	implements LibraryStore, ModelWrapper<LibraryStore> {

	public LibraryStoreWrapper(LibraryStore libraryStore) {
		super(libraryStore);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("lmsID", getLmsID());
		attributes.put("bookname", getBookname());
		attributes.put("issueDate", getIssueDate());
		attributes.put("uploadedBy", getUploadedBy());
		attributes.put("issueTo", getIssueTo());
		attributes.put("authorName", getAuthorName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long lmsID = (Long)attributes.get("lmsID");

		if (lmsID != null) {
			setLmsID(lmsID);
		}

		String bookname = (String)attributes.get("bookname");

		if (bookname != null) {
			setBookname(bookname);
		}

		String issueDate = (String)attributes.get("issueDate");

		if (issueDate != null) {
			setIssueDate(issueDate);
		}

		String uploadedBy = (String)attributes.get("uploadedBy");

		if (uploadedBy != null) {
			setUploadedBy(uploadedBy);
		}

		String issueTo = (String)attributes.get("issueTo");

		if (issueTo != null) {
			setIssueTo(issueTo);
		}

		String authorName = (String)attributes.get("authorName");

		if (authorName != null) {
			setAuthorName(authorName);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	 * Returns the author name of this library store.
	 *
	 * @return the author name of this library store
	 */
	@Override
	public String getAuthorName() {
		return model.getAuthorName();
	}

	/**
	 * Returns the bookname of this library store.
	 *
	 * @return the bookname of this library store
	 */
	@Override
	public String getBookname() {
		return model.getBookname();
	}

	/**
	 * Returns the company ID of this library store.
	 *
	 * @return the company ID of this library store
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this library store.
	 *
	 * @return the create date of this library store
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created date of this library store.
	 *
	 * @return the created date of this library store
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the group ID of this library store.
	 *
	 * @return the group ID of this library store
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the issue date of this library store.
	 *
	 * @return the issue date of this library store
	 */
	@Override
	public String getIssueDate() {
		return model.getIssueDate();
	}

	/**
	 * Returns the issue to of this library store.
	 *
	 * @return the issue to of this library store
	 */
	@Override
	public String getIssueTo() {
		return model.getIssueTo();
	}

	/**
	 * Returns the lms ID of this library store.
	 *
	 * @return the lms ID of this library store
	 */
	@Override
	public long getLmsID() {
		return model.getLmsID();
	}

	/**
	 * Returns the modified date of this library store.
	 *
	 * @return the modified date of this library store
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this library store.
	 *
	 * @return the primary key of this library store
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this library store.
	 *
	 * @return the status of this library store
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this library store.
	 *
	 * @return the status by user ID of this library store
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this library store.
	 *
	 * @return the status by user name of this library store
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this library store.
	 *
	 * @return the status by user uuid of this library store
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this library store.
	 *
	 * @return the status date of this library store
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the uploaded by of this library store.
	 *
	 * @return the uploaded by of this library store
	 */
	@Override
	public String getUploadedBy() {
		return model.getUploadedBy();
	}

	/**
	 * Returns the user ID of this library store.
	 *
	 * @return the user ID of this library store
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this library store.
	 *
	 * @return the user name of this library store
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this library store.
	 *
	 * @return the user uuid of this library store
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this library store.
	 *
	 * @return the uuid of this library store
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this library store is approved.
	 *
	 * @return <code>true</code> if this library store is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this library store is denied.
	 *
	 * @return <code>true</code> if this library store is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this library store is a draft.
	 *
	 * @return <code>true</code> if this library store is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this library store is expired.
	 *
	 * @return <code>true</code> if this library store is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this library store is inactive.
	 *
	 * @return <code>true</code> if this library store is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this library store is incomplete.
	 *
	 * @return <code>true</code> if this library store is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this library store is pending.
	 *
	 * @return <code>true</code> if this library store is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this library store is scheduled.
	 *
	 * @return <code>true</code> if this library store is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the author name of this library store.
	 *
	 * @param authorName the author name of this library store
	 */
	@Override
	public void setAuthorName(String authorName) {
		model.setAuthorName(authorName);
	}

	/**
	 * Sets the bookname of this library store.
	 *
	 * @param bookname the bookname of this library store
	 */
	@Override
	public void setBookname(String bookname) {
		model.setBookname(bookname);
	}

	/**
	 * Sets the company ID of this library store.
	 *
	 * @param companyId the company ID of this library store
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this library store.
	 *
	 * @param createDate the create date of this library store
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created date of this library store.
	 *
	 * @param createdDate the created date of this library store
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the group ID of this library store.
	 *
	 * @param groupId the group ID of this library store
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the issue date of this library store.
	 *
	 * @param issueDate the issue date of this library store
	 */
	@Override
	public void setIssueDate(String issueDate) {
		model.setIssueDate(issueDate);
	}

	/**
	 * Sets the issue to of this library store.
	 *
	 * @param issueTo the issue to of this library store
	 */
	@Override
	public void setIssueTo(String issueTo) {
		model.setIssueTo(issueTo);
	}

	/**
	 * Sets the lms ID of this library store.
	 *
	 * @param lmsID the lms ID of this library store
	 */
	@Override
	public void setLmsID(long lmsID) {
		model.setLmsID(lmsID);
	}

	/**
	 * Sets the modified date of this library store.
	 *
	 * @param modifiedDate the modified date of this library store
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this library store.
	 *
	 * @param primaryKey the primary key of this library store
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this library store.
	 *
	 * @param status the status of this library store
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this library store.
	 *
	 * @param statusByUserId the status by user ID of this library store
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this library store.
	 *
	 * @param statusByUserName the status by user name of this library store
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this library store.
	 *
	 * @param statusByUserUuid the status by user uuid of this library store
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this library store.
	 *
	 * @param statusDate the status date of this library store
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the uploaded by of this library store.
	 *
	 * @param uploadedBy the uploaded by of this library store
	 */
	@Override
	public void setUploadedBy(String uploadedBy) {
		model.setUploadedBy(uploadedBy);
	}

	/**
	 * Sets the user ID of this library store.
	 *
	 * @param userId the user ID of this library store
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this library store.
	 *
	 * @param userName the user name of this library store
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this library store.
	 *
	 * @param userUuid the user uuid of this library store
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this library store.
	 *
	 * @param uuid the uuid of this library store
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected LibraryStoreWrapper wrap(LibraryStore libraryStore) {
		return new LibraryStoreWrapper(libraryStore);
	}

}