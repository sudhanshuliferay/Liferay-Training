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

package com.demo.customsql.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CustomSQLTest service. Represents a row in the &quot;Customsql_CustomSQLTest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.demo.customsql.model.impl.CustomSQLTestModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.demo.customsql.model.impl.CustomSQLTestImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomSQLTest
 * @generated
 */
@ProviderType
public interface CustomSQLTestModel
	extends BaseModel<CustomSQLTest>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a custom sql test model instance should use the {@link CustomSQLTest} interface instead.
	 */

	/**
	 * Returns the primary key of this custom sql test.
	 *
	 * @return the primary key of this custom sql test
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this custom sql test.
	 *
	 * @param primaryKey the primary key of this custom sql test
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this custom sql test.
	 *
	 * @return the uuid of this custom sql test
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this custom sql test.
	 *
	 * @param uuid the uuid of this custom sql test
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the foo ID of this custom sql test.
	 *
	 * @return the foo ID of this custom sql test
	 */
	public long getFooId();

	/**
	 * Sets the foo ID of this custom sql test.
	 *
	 * @param fooId the foo ID of this custom sql test
	 */
	public void setFooId(long fooId);

	/**
	 * Returns the group ID of this custom sql test.
	 *
	 * @return the group ID of this custom sql test
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this custom sql test.
	 *
	 * @param groupId the group ID of this custom sql test
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this custom sql test.
	 *
	 * @return the company ID of this custom sql test
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this custom sql test.
	 *
	 * @param companyId the company ID of this custom sql test
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this custom sql test.
	 *
	 * @return the user ID of this custom sql test
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this custom sql test.
	 *
	 * @param userId the user ID of this custom sql test
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this custom sql test.
	 *
	 * @return the user uuid of this custom sql test
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this custom sql test.
	 *
	 * @param userUuid the user uuid of this custom sql test
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this custom sql test.
	 *
	 * @return the user name of this custom sql test
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this custom sql test.
	 *
	 * @param userName the user name of this custom sql test
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this custom sql test.
	 *
	 * @return the create date of this custom sql test
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this custom sql test.
	 *
	 * @param createDate the create date of this custom sql test
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this custom sql test.
	 *
	 * @return the modified date of this custom sql test
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this custom sql test.
	 *
	 * @param modifiedDate the modified date of this custom sql test
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the field1 of this custom sql test.
	 *
	 * @return the field1 of this custom sql test
	 */
	@AutoEscape
	public String getField1();

	/**
	 * Sets the field1 of this custom sql test.
	 *
	 * @param field1 the field1 of this custom sql test
	 */
	public void setField1(String field1);

	/**
	 * Returns the field2 of this custom sql test.
	 *
	 * @return the field2 of this custom sql test
	 */
	public boolean getField2();

	/**
	 * Returns <code>true</code> if this custom sql test is field2.
	 *
	 * @return <code>true</code> if this custom sql test is field2; <code>false</code> otherwise
	 */
	public boolean isField2();

	/**
	 * Sets whether this custom sql test is field2.
	 *
	 * @param field2 the field2 of this custom sql test
	 */
	public void setField2(boolean field2);

	/**
	 * Returns the field3 of this custom sql test.
	 *
	 * @return the field3 of this custom sql test
	 */
	public int getField3();

	/**
	 * Sets the field3 of this custom sql test.
	 *
	 * @param field3 the field3 of this custom sql test
	 */
	public void setField3(int field3);

	/**
	 * Returns the field4 of this custom sql test.
	 *
	 * @return the field4 of this custom sql test
	 */
	public Date getField4();

	/**
	 * Sets the field4 of this custom sql test.
	 *
	 * @param field4 the field4 of this custom sql test
	 */
	public void setField4(Date field4);

	/**
	 * Returns the field5 of this custom sql test.
	 *
	 * @return the field5 of this custom sql test
	 */
	@AutoEscape
	public String getField5();

	/**
	 * Sets the field5 of this custom sql test.
	 *
	 * @param field5 the field5 of this custom sql test
	 */
	public void setField5(String field5);

}