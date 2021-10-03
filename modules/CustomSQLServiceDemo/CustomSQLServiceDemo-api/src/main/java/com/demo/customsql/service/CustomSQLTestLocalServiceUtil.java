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

package com.demo.customsql.service;

import com.demo.customsql.model.CustomSQLTest;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CustomSQLTest. This utility wraps
 * <code>com.demo.customsql.service.impl.CustomSQLTestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CustomSQLTestLocalService
 * @generated
 */
public class CustomSQLTestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.demo.customsql.service.impl.CustomSQLTestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the custom sql test to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomSQLTestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customSQLTest the custom sql test
	 * @return the custom sql test that was added
	 */
	public static CustomSQLTest addCustomSQLTest(CustomSQLTest customSQLTest) {
		return getService().addCustomSQLTest(customSQLTest);
	}

	/**
	 * Creates a new custom sql test with the primary key. Does not add the custom sql test to the database.
	 *
	 * @param fooId the primary key for the new custom sql test
	 * @return the new custom sql test
	 */
	public static CustomSQLTest createCustomSQLTest(long fooId) {
		return getService().createCustomSQLTest(fooId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the custom sql test from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomSQLTestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customSQLTest the custom sql test
	 * @return the custom sql test that was removed
	 */
	public static CustomSQLTest deleteCustomSQLTest(
		CustomSQLTest customSQLTest) {

		return getService().deleteCustomSQLTest(customSQLTest);
	}

	/**
	 * Deletes the custom sql test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomSQLTestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test that was removed
	 * @throws PortalException if a custom sql test with the primary key could not be found
	 */
	public static CustomSQLTest deleteCustomSQLTest(long fooId)
		throws PortalException {

		return getService().deleteCustomSQLTest(fooId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.demo.customsql.model.impl.CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.demo.customsql.model.impl.CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CustomSQLTest fetchCustomSQLTest(long fooId) {
		return getService().fetchCustomSQLTest(fooId);
	}

	/**
	 * Returns the custom sql test matching the UUID and group.
	 *
	 * @param uuid the custom sql test's UUID
	 * @param groupId the primary key of the group
	 * @return the matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	public static CustomSQLTest fetchCustomSQLTestByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCustomSQLTestByUuidAndGroupId(uuid, groupId);
	}

	public static List<CustomSQLTest> findByScreenNameLikeUser(
		String screenName) {

		return getService().findByScreenNameLikeUser(screenName);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the custom sql test with the primary key.
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test
	 * @throws PortalException if a custom sql test with the primary key could not be found
	 */
	public static CustomSQLTest getCustomSQLTest(long fooId)
		throws PortalException {

		return getService().getCustomSQLTest(fooId);
	}

	/**
	 * Returns the custom sql test matching the UUID and group.
	 *
	 * @param uuid the custom sql test's UUID
	 * @param groupId the primary key of the group
	 * @return the matching custom sql test
	 * @throws PortalException if a matching custom sql test could not be found
	 */
	public static CustomSQLTest getCustomSQLTestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCustomSQLTestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the custom sql tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.demo.customsql.model.impl.CustomSQLTestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @return the range of custom sql tests
	 */
	public static List<CustomSQLTest> getCustomSQLTests(int start, int end) {
		return getService().getCustomSQLTests(start, end);
	}

	/**
	 * Returns all the custom sql tests matching the UUID and company.
	 *
	 * @param uuid the UUID of the custom sql tests
	 * @param companyId the primary key of the company
	 * @return the matching custom sql tests, or an empty list if no matches were found
	 */
	public static List<CustomSQLTest> getCustomSQLTestsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCustomSQLTestsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of custom sql tests matching the UUID and company.
	 *
	 * @param uuid the UUID of the custom sql tests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of custom sql tests
	 * @param end the upper bound of the range of custom sql tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching custom sql tests, or an empty list if no matches were found
	 */
	public static List<CustomSQLTest> getCustomSQLTestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return getService().getCustomSQLTestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of custom sql tests.
	 *
	 * @return the number of custom sql tests
	 */
	public static int getCustomSQLTestsCount() {
		return getService().getCustomSQLTestsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the custom sql test in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CustomSQLTestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customSQLTest the custom sql test
	 * @return the custom sql test that was updated
	 */
	public static CustomSQLTest updateCustomSQLTest(
		CustomSQLTest customSQLTest) {

		return getService().updateCustomSQLTest(customSQLTest);
	}

	public static CustomSQLTestLocalService getService() {
		return _service;
	}

	private static volatile CustomSQLTestLocalService _service;

}