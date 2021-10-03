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

package com.training.customsql.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.training.customsql.model.Training;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Training in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TrainingCacheModel
	implements CacheModel<Training>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TrainingCacheModel)) {
			return false;
		}

		TrainingCacheModel trainingCacheModel = (TrainingCacheModel)object;

		if (trainingId == trainingCacheModel.trainingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, trainingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", trainingId=");
		sb.append(trainingId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", trainingName=");
		sb.append(trainingName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Training toEntityModel() {
		TrainingImpl trainingImpl = new TrainingImpl();

		if (uuid == null) {
			trainingImpl.setUuid("");
		}
		else {
			trainingImpl.setUuid(uuid);
		}

		trainingImpl.setTrainingId(trainingId);
		trainingImpl.setUserId(userId);
		trainingImpl.setCompanyId(companyId);
		trainingImpl.setGroupId(groupId);

		if (trainingName == null) {
			trainingImpl.setTrainingName("");
		}
		else {
			trainingImpl.setTrainingName(trainingName);
		}

		trainingImpl.resetOriginalValues();

		return trainingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		trainingId = objectInput.readLong();

		userId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		trainingName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(trainingId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		if (trainingName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trainingName);
		}
	}

	public String uuid;
	public long trainingId;
	public long userId;
	public long companyId;
	public long groupId;
	public String trainingName;

}