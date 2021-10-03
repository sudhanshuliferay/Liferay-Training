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

import com.demo.customsql.exception.NoSuchCustomSQLTestException;
import com.demo.customsql.model.CustomSQLTest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the custom sql test service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomSQLTestUtil
 * @generated
 */
@ProviderType
public interface CustomSQLTestPersistence
	extends BasePersistence<CustomSQLTest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomSQLTestUtil} to access the custom sql test persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the custom sql tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching custom sql tests
	 */
	public java.util.List<CustomSQLTest> findByUuid(String uuid);

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
	public java.util.List<CustomSQLTest> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CustomSQLTest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator);

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
	public java.util.List<CustomSQLTest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public CustomSQLTest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
				orderByComparator)
		throws NoSuchCustomSQLTestException;

	/**
	 * Returns the first custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public CustomSQLTest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator);

	/**
	 * Returns the last custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public CustomSQLTest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
				orderByComparator)
		throws NoSuchCustomSQLTestException;

	/**
	 * Returns the last custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public CustomSQLTest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator);

	/**
	 * Returns the custom sql tests before and after the current custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param fooId the primary key of the current custom sql test
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom sql test
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	public CustomSQLTest[] findByUuid_PrevAndNext(
			long fooId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
				orderByComparator)
		throws NoSuchCustomSQLTestException;

	/**
	 * Removes all the custom sql tests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of custom sql tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching custom sql tests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the custom sql test where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCustomSQLTestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public CustomSQLTest findByUUID_G(String uuid, long groupId)
		throws NoSuchCustomSQLTestException;

	/**
	 * Returns the custom sql test where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public CustomSQLTest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the custom sql test where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public CustomSQLTest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the custom sql test where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the custom sql test that was removed
	 */
	public CustomSQLTest removeByUUID_G(String uuid, long groupId)
		throws NoSuchCustomSQLTestException;

	/**
	 * Returns the number of custom sql tests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching custom sql tests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the custom sql tests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching custom sql tests
	 */
	public java.util.List<CustomSQLTest> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CustomSQLTest> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CustomSQLTest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator);

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
	public java.util.List<CustomSQLTest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first custom sql test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public CustomSQLTest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
				orderByComparator)
		throws NoSuchCustomSQLTestException;

	/**
	 * Returns the first custom sql test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public CustomSQLTest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator);

	/**
	 * Returns the last custom sql test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public CustomSQLTest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
				orderByComparator)
		throws NoSuchCustomSQLTestException;

	/**
	 * Returns the last custom sql test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public CustomSQLTest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator);

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
	public CustomSQLTest[] findByUuid_C_PrevAndNext(
			long fooId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
				orderByComparator)
		throws NoSuchCustomSQLTestException;

	/**
	 * Removes all the custom sql tests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of custom sql tests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching custom sql tests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the custom sql tests where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the matching custom sql tests
	 */
	public java.util.List<CustomSQLTest> findByField2(boolean field2);

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
	public java.util.List<CustomSQLTest> findByField2(
		boolean field2, int start, int end);

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
	public java.util.List<CustomSQLTest> findByField2(
		boolean field2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator);

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
	public java.util.List<CustomSQLTest> findByField2(
		boolean field2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public CustomSQLTest findByField2_First(
			boolean field2,
			com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
				orderByComparator)
		throws NoSuchCustomSQLTestException;

	/**
	 * Returns the first custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public CustomSQLTest fetchByField2_First(
		boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator);

	/**
	 * Returns the last custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	public CustomSQLTest findByField2_Last(
			boolean field2,
			com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
				orderByComparator)
		throws NoSuchCustomSQLTestException;

	/**
	 * Returns the last custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public CustomSQLTest fetchByField2_Last(
		boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator);

	/**
	 * Returns the custom sql tests before and after the current custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param fooId the primary key of the current custom sql test
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom sql test
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	public CustomSQLTest[] findByField2_PrevAndNext(
			long fooId, boolean field2,
			com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
				orderByComparator)
		throws NoSuchCustomSQLTestException;

	/**
	 * Removes all the custom sql tests where field2 = &#63; from the database.
	 *
	 * @param field2 the field2
	 */
	public void removeByField2(boolean field2);

	/**
	 * Returns the number of custom sql tests where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the number of matching custom sql tests
	 */
	public int countByField2(boolean field2);

	/**
	 * Caches the custom sql test in the entity cache if it is enabled.
	 *
	 * @param customSQLTest the custom sql test
	 */
	public void cacheResult(CustomSQLTest customSQLTest);

	/**
	 * Caches the custom sql tests in the entity cache if it is enabled.
	 *
	 * @param customSQLTests the custom sql tests
	 */
	public void cacheResult(java.util.List<CustomSQLTest> customSQLTests);

	/**
	 * Creates a new custom sql test with the primary key. Does not add the custom sql test to the database.
	 *
	 * @param fooId the primary key for the new custom sql test
	 * @return the new custom sql test
	 */
	public CustomSQLTest create(long fooId);

	/**
	 * Removes the custom sql test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test that was removed
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	public CustomSQLTest remove(long fooId) throws NoSuchCustomSQLTestException;

	public CustomSQLTest updateImpl(CustomSQLTest customSQLTest);

	/**
	 * Returns the custom sql test with the primary key or throws a <code>NoSuchCustomSQLTestException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	public CustomSQLTest findByPrimaryKey(long fooId)
		throws NoSuchCustomSQLTestException;

	/**
	 * Returns the custom sql test with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test, or <code>null</code> if a custom sql test with the primary key could not be found
	 */
	public CustomSQLTest fetchByPrimaryKey(long fooId);

	/**
	 * Returns all the custom sql tests.
	 *
	 * @return the custom sql tests
	 */
	public java.util.List<CustomSQLTest> findAll();

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
	public java.util.List<CustomSQLTest> findAll(int start, int end);

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
	public java.util.List<CustomSQLTest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator);

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
	public java.util.List<CustomSQLTest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomSQLTest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the custom sql tests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of custom sql tests.
	 *
	 * @return the number of custom sql tests
	 */
	public int countAll();

}