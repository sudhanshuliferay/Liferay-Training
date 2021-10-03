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

package com.training.customsql.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Training}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Training
 * @generated
 */
public class TrainingWrapper
	extends BaseModelWrapper<Training>
	implements ModelWrapper<Training>, Training {

	public TrainingWrapper(Training training) {
		super(training);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("trainingId", getTrainingId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("trainingName", getTrainingName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long trainingId = (Long)attributes.get("trainingId");

		if (trainingId != null) {
			setTrainingId(trainingId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String trainingName = (String)attributes.get("trainingName");

		if (trainingName != null) {
			setTrainingName(trainingName);
		}
	}

	/**
	 * Returns the company ID of this training.
	 *
	 * @return the company ID of this training
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this training.
	 *
	 * @return the group ID of this training
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this training.
	 *
	 * @return the primary key of this training
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the training ID of this training.
	 *
	 * @return the training ID of this training
	 */
	@Override
	public long getTrainingId() {
		return model.getTrainingId();
	}

	/**
	 * Returns the training name of this training.
	 *
	 * @return the training name of this training
	 */
	@Override
	public String getTrainingName() {
		return model.getTrainingName();
	}

	/**
	 * Returns the user ID of this training.
	 *
	 * @return the user ID of this training
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this training.
	 *
	 * @return the user uuid of this training
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this training.
	 *
	 * @return the uuid of this training
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this training.
	 *
	 * @param companyId the company ID of this training
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this training.
	 *
	 * @param groupId the group ID of this training
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this training.
	 *
	 * @param primaryKey the primary key of this training
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the training ID of this training.
	 *
	 * @param trainingId the training ID of this training
	 */
	@Override
	public void setTrainingId(long trainingId) {
		model.setTrainingId(trainingId);
	}

	/**
	 * Sets the training name of this training.
	 *
	 * @param trainingName the training name of this training
	 */
	@Override
	public void setTrainingName(String trainingName) {
		model.setTrainingName(trainingName);
	}

	/**
	 * Sets the user ID of this training.
	 *
	 * @param userId the user ID of this training
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this training.
	 *
	 * @param userUuid the user uuid of this training
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this training.
	 *
	 * @param uuid the uuid of this training
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected TrainingWrapper wrap(Training training) {
		return new TrainingWrapper(training);
	}

}