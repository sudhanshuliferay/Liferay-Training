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

package com.demo.customsql.model.impl;

import com.demo.customsql.model.CustomSQLTest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CustomSQLTest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomSQLTestCacheModel
	implements CacheModel<CustomSQLTest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomSQLTestCacheModel)) {
			return false;
		}

		CustomSQLTestCacheModel customSQLTestCacheModel =
			(CustomSQLTestCacheModel)object;

		if (fooId == customSQLTestCacheModel.fooId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fooId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fooId=");
		sb.append(fooId);
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
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", field1=");
		sb.append(field1);
		sb.append(", field2=");
		sb.append(field2);
		sb.append(", field3=");
		sb.append(field3);
		sb.append(", field4=");
		sb.append(field4);
		sb.append(", field5=");
		sb.append(field5);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomSQLTest toEntityModel() {
		CustomSQLTestImpl customSQLTestImpl = new CustomSQLTestImpl();

		if (uuid == null) {
			customSQLTestImpl.setUuid("");
		}
		else {
			customSQLTestImpl.setUuid(uuid);
		}

		customSQLTestImpl.setFooId(fooId);
		customSQLTestImpl.setGroupId(groupId);
		customSQLTestImpl.setCompanyId(companyId);
		customSQLTestImpl.setUserId(userId);

		if (userName == null) {
			customSQLTestImpl.setUserName("");
		}
		else {
			customSQLTestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			customSQLTestImpl.setCreateDate(null);
		}
		else {
			customSQLTestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			customSQLTestImpl.setModifiedDate(null);
		}
		else {
			customSQLTestImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (field1 == null) {
			customSQLTestImpl.setField1("");
		}
		else {
			customSQLTestImpl.setField1(field1);
		}

		customSQLTestImpl.setField2(field2);
		customSQLTestImpl.setField3(field3);

		if (field4 == Long.MIN_VALUE) {
			customSQLTestImpl.setField4(null);
		}
		else {
			customSQLTestImpl.setField4(new Date(field4));
		}

		if (field5 == null) {
			customSQLTestImpl.setField5("");
		}
		else {
			customSQLTestImpl.setField5(field5);
		}

		customSQLTestImpl.resetOriginalValues();

		return customSQLTestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fooId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		field1 = objectInput.readUTF();

		field2 = objectInput.readBoolean();

		field3 = objectInput.readInt();
		field4 = objectInput.readLong();
		field5 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fooId);

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
		objectOutput.writeLong(modifiedDate);

		if (field1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(field1);
		}

		objectOutput.writeBoolean(field2);

		objectOutput.writeInt(field3);
		objectOutput.writeLong(field4);

		if (field5 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(field5);
		}
	}

	public String uuid;
	public long fooId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String field1;
	public boolean field2;
	public int field3;
	public long field4;
	public String field5;

}