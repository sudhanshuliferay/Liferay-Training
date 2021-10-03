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

package com.demo.customsql.service.persistence;

import com.demo.customsql.model.CustomSQLTest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the custom sql test service. This utility wraps <code>com.demo.customsql.service.persistence.impl.CustomSQLTestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomSQLTestPersistence
 * @generated
 */
public class CustomSQLTestUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CustomSQLTest customSQLTest) {
		getPersistence().clearCache(customSQLTest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CustomSQLTest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CustomSQLTest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CustomSQLTest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CustomSQLTest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CustomSQLTest update(CustomSQLTest customSQLTest) {
		return getPersistence().update(customSQLTest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CustomSQLTest update(
		CustomSQLTest customSQLTest, ServiceContext serviceContext) {

		return getPersistence().update(customSQLTest, serviceContext);
	}

	/**
	 * Returns all the custom sql tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching custom sql tests
	 */
	public static List<CustomSQLTest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the custom sql tests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @return the range of matching custom sql tests
	 */
	public static List<CustomSQLTest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the custom sql tests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom sql tests
	 */
	public static List<CustomSQLTest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom sql tests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom sql tests
	 */
	public static List<CustomSQLTest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public static CustomSQLTest findByUuid_First(
			String uuid, OrderByComparator<CustomSQLTest> orderByComparator)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public static CustomSQLTest fetchByUuid_First(
		String uuid, OrderByComparator<CustomSQLTest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public static CustomSQLTest findByUuid_Last(
			String uuid, OrderByComparator<CustomSQLTest> orderByComparator)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public static CustomSQLTest fetchByUuid_Last(
		String uuid, OrderByComparator<CustomSQLTest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the custom sql tests before and after the current custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param fooId the primary key of the current custom sql test
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom sql test
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	public static CustomSQLTest[] findByUuid_PrevAndNext(
			long fooId, String uuid,
			OrderByComparator<CustomSQLTest> orderByComparator)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().findByUuid_PrevAndNext(
			fooId, uuid, orderByComparator);
	}

	/**
	 * Removes all the custom sql tests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of custom sql tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching custom sql tests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the custom sql test where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCustomSQLTestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public static CustomSQLTest findByUUID_G(String uuid, long groupId)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the custom sql test where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public static CustomSQLTest fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the custom sql test where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public static CustomSQLTest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the custom sql test where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the custom sql test that was removed
	 */
	public static CustomSQLTest removeByUUID_G(String uuid, long groupId)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of custom sql tests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching custom sql tests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the custom sql tests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching custom sql tests
	 */
	public static List<CustomSQLTest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the custom sql tests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @return the range of matching custom sql tests
	 */
	public static List<CustomSQLTest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the custom sql tests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom sql tests
	 */
	public static List<CustomSQLTest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom sql tests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom sql tests
	 */
	public static List<CustomSQLTest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first custom sql test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public static CustomSQLTest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CustomSQLTest> orderByComparator)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first custom sql test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public static CustomSQLTest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last custom sql test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public static CustomSQLTest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CustomSQLTest> orderByComparator)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last custom sql test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public static CustomSQLTest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the custom sql tests before and after the current custom sql test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fooId the primary key of the current custom sql test
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom sql test
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	public static CustomSQLTest[] findByUuid_C_PrevAndNext(
			long fooId, String uuid, long companyId,
			OrderByComparator<CustomSQLTest> orderByComparator)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			fooId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the custom sql tests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of custom sql tests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching custom sql tests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the custom sql tests where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the matching custom sql tests
	 */
	public static List<CustomSQLTest> findByField2(boolean field2) {
		return getPersistence().findByField2(field2);
	}

	/**
	 * Returns a range of all the custom sql tests where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param field2 the field2
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @return the range of matching custom sql tests
	 */
	public static List<CustomSQLTest> findByField2(
		boolean field2, int start, int end) {

		return getPersistence().findByField2(field2, start, end);
	}

	/**
	 * Returns an ordered range of all the custom sql tests where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param field2 the field2
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom sql tests
	 */
	public static List<CustomSQLTest> findByField2(
		boolean field2, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return getPersistence().findByField2(
			field2, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom sql tests where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param field2 the field2
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom sql tests
	 */
	public static List<CustomSQLTest> findByField2(
		boolean field2, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByField2(
			field2, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public static CustomSQLTest findByField2_First(
			boolean field2, OrderByComparator<CustomSQLTest> orderByComparator)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().findByField2_First(field2, orderByComparator);
	}

	/**
	 * Returns the first custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public static CustomSQLTest fetchByField2_First(
		boolean field2, OrderByComparator<CustomSQLTest> orderByComparator) {

		return getPersistence().fetchByField2_First(field2, orderByComparator);
	}

	/**
	 * Returns the last custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public static CustomSQLTest findByField2_Last(
			boolean field2, OrderByComparator<CustomSQLTest> orderByComparator)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().findByField2_Last(field2, orderByComparator);
	}

	/**
	 * Returns the last custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public static CustomSQLTest fetchByField2_Last(
		boolean field2, OrderByComparator<CustomSQLTest> orderByComparator) {

		return getPersistence().fetchByField2_Last(field2, orderByComparator);
	}

	/**
	 * Returns the custom sql tests before and after the current custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param fooId the primary key of the current custom sql test
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom sql test
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	public static CustomSQLTest[] findByField2_PrevAndNext(
			long fooId, boolean field2,
			OrderByComparator<CustomSQLTest> orderByComparator)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().findByField2_PrevAndNext(
			fooId, field2, orderByComparator);
	}

	/**
	 * Removes all the custom sql tests where field2 = &#63; from the database.
	 *
	 * @param field2 the field2
	 */
	public static void removeByField2(boolean field2) {
		getPersistence().removeByField2(field2);
	}

	/**
	 * Returns the number of custom sql tests where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the number of matching custom sql tests
	 */
	public static int countByField2(boolean field2) {
		return getPersistence().countByField2(field2);
	}

	/**
	 * Caches the custom sql test in the entity cache if it is enabled.
	 *
	 * @param customSQLTest the custom sql test
	 */
	public static void cacheResult(CustomSQLTest customSQLTest) {
		getPersistence().cacheResult(customSQLTest);
	}

	/**
	 * Caches the custom sql tests in the entity cache if it is enabled.
	 *
	 * @param customSQLTests the custom sql tests
	 */
	public static void cacheResult(List<CustomSQLTest> customSQLTests) {
		getPersistence().cacheResult(customSQLTests);
	}

	/**
	 * Creates a new custom sql test with the primary key. Does not add the custom sql test to the database.
	 *
	 * @param fooId the primary key for the new custom sql test
	 * @return the new custom sql test
	 */
	public static CustomSQLTest create(long fooId) {
		return getPersistence().create(fooId);
	}

	/**
	 * Removes the custom sql test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test that was removed
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	public static CustomSQLTest remove(long fooId)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().remove(fooId);
	}

	public static CustomSQLTest updateImpl(CustomSQLTest customSQLTest) {
		return getPersistence().updateImpl(customSQLTest);
	}

	/**
	 * Returns the custom sql test with the primary key or throws a <code>NoSuchCustomSQLTestException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	public static CustomSQLTest findByPrimaryKey(long fooId)
		throws com.demo.customsql.exception.NoSuchCustomSQLTestException {

		return getPersistence().findByPrimaryKey(fooId);
	}

	/**
	 * Returns the custom sql test with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test, or <code>null</code> if a custom sql test with the primary key could not be found
	 */
	public static CustomSQLTest fetchByPrimaryKey(long fooId) {
		return getPersistence().fetchByPrimaryKey(fooId);
	}

	/**
	 * Returns all the custom sql tests.
	 *
	 * @return the custom sql tests
	 */
	public static List<CustomSQLTest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the custom sql tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @return the range of custom sql tests
	 */
	public static List<CustomSQLTest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the custom sql tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom sql tests
	 */
	public static List<CustomSQLTest> findAll(
		int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the custom sql tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of custom sql tests
	 */
	public static List<CustomSQLTest> findAll(
		int start, int end, OrderByComparator<CustomSQLTest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the custom sql tests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of custom sql tests.
	 *
	 * @return the number of custom sql tests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CustomSQLTestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CustomSQLTestPersistence, CustomSQLTestPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustomSQLTestPersistence.class);

		ServiceTracker<CustomSQLTestPersistence, CustomSQLTestPersistence>
			serviceTracker =
				new ServiceTracker
					<CustomSQLTestPersistence, CustomSQLTestPersistence>(
						bundle.getBundleContext(),
						CustomSQLTestPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}