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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

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

		attributes.put("lmsID", getLmsID());
		attributes.put("bookname", getBookname());
		attributes.put("issueDate", getIssueDate());
		attributes.put("uploadedBy", getUploadedBy());
		attributes.put("issueTo", getIssueTo());
		attributes.put("groupId", getGroupId());
		attributes.put("comapnyId", getComapnyId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long comapnyId = (Long)attributes.get("comapnyId");

		if (comapnyId != null) {
			setComapnyId(comapnyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
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
	 * Returns the comapny ID of this library store.
	 *
	 * @return the comapny ID of this library store
	 */
	@Override
	public long getComapnyId() {
		return model.getComapnyId();
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
	 * Returns the primary key of this library store.
	 *
	 * @return the primary key of this library store
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
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
	 * Returns the user uuid of this library store.
	 *
	 * @return the user uuid of this library store
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
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
	 * Sets the comapny ID of this library store.
	 *
	 * @param comapnyId the comapny ID of this library store
	 */
	@Override
	public void setComapnyId(long comapnyId) {
		model.setComapnyId(comapnyId);
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
	 * Sets the primary key of this library store.
	 *
	 * @param primaryKey the primary key of this library store
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
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
	 * Sets the user uuid of this library store.
	 *
	 * @param userUuid the user uuid of this library store
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected LibraryStoreWrapper wrap(LibraryStore libraryStore) {
		return new LibraryStoreWrapper(libraryStore);
	}

}