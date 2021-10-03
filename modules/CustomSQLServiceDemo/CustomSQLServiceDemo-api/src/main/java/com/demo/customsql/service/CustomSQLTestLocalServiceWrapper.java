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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomSQLTestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomSQLTestLocalService
 * @generated
 */
public class CustomSQLTestLocalServiceWrapper
	implements CustomSQLTestLocalService,
			   ServiceWrapper<CustomSQLTestLocalService> {

	public CustomSQLTestLocalServiceWrapper(
		CustomSQLTestLocalService customSQLTestLocalService) {

		_customSQLTestLocalService = customSQLTestLocalService;
	}

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
	@Override
	public com.demo.customsql.model.CustomSQLTest addCustomSQLTest(
		com.demo.customsql.model.CustomSQLTest customSQLTest) {

		return _customSQLTestLocalService.addCustomSQLTest(customSQLTest);
	}

	/**
	 * Creates a new custom sql test with the primary key. Does not add the custom sql test to the database.
	 *
	 * @param fooId the primary key for the new custom sql test
	 * @return the new custom sql test
	 */
	@Override
	public com.demo.customsql.model.CustomSQLTest createCustomSQLTest(
		long fooId) {

		return _customSQLTestLocalService.createCustomSQLTest(fooId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customSQLTestLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.demo.customsql.model.CustomSQLTest deleteCustomSQLTest(
		com.demo.customsql.model.CustomSQLTest customSQLTest) {

		return _customSQLTestLocalService.deleteCustomSQLTest(customSQLTest);
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
	@Override
	public com.demo.customsql.model.CustomSQLTest deleteCustomSQLTest(
			long fooId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customSQLTestLocalService.deleteCustomSQLTest(fooId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customSQLTestLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _customSQLTestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _customSQLTestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customSQLTestLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _customSQLTestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _customSQLTestLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _customSQLTestLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _customSQLTestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _customSQLTestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.demo.customsql.model.CustomSQLTest fetchCustomSQLTest(
		long fooId) {

		return _customSQLTestLocalService.fetchCustomSQLTest(fooId);
	}

	/**
	 * Returns the custom sql test matching the UUID and group.
	 *
	 * @param uuid the custom sql test's UUID
	 * @param groupId the primary key of the group
	 * @return the matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	@Override
	public com.demo.customsql.model.CustomSQLTest
		fetchCustomSQLTestByUuidAndGroupId(String uuid, long groupId) {

		return _customSQLTestLocalService.fetchCustomSQLTestByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.demo.customsql.model.CustomSQLTest>
		findByScreenNameLikeUser(String screenName) {

		return _customSQLTestLocalService.findByScreenNameLikeUser(screenName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _customSQLTestLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the custom sql test with the primary key.
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test
	 * @throws PortalException if a custom sql test with the primary key could not be found
	 */
	@Override
	public com.demo.customsql.model.CustomSQLTest getCustomSQLTest(long fooId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customSQLTestLocalService.getCustomSQLTest(fooId);
	}

	/**
	 * Returns the custom sql test matching the UUID and group.
	 *
	 * @param uuid the custom sql test's UUID
	 * @param groupId the primary key of the group
	 * @return the matching custom sql test
	 * @throws PortalException if a matching custom sql test could not be found
	 */
	@Override
	public com.demo.customsql.model.CustomSQLTest
			getCustomSQLTestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customSQLTestLocalService.getCustomSQLTestByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.demo.customsql.model.CustomSQLTest>
		getCustomSQLTests(int start, int end) {

		return _customSQLTestLocalService.getCustomSQLTests(start, end);
	}

	/**
	 * Returns all the custom sql tests matching the UUID and company.
	 *
	 * @param uuid the UUID of the custom sql tests
	 * @param companyId the primary key of the company
	 * @return the matching custom sql tests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.demo.customsql.model.CustomSQLTest>
		getCustomSQLTestsByUuidAndCompanyId(String uuid, long companyId) {

		return _customSQLTestLocalService.getCustomSQLTestsByUuidAndCompanyId(
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
	@Override
	public java.util.List<com.demo.customsql.model.CustomSQLTest>
		getCustomSQLTestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.demo.customsql.model.CustomSQLTest> orderByComparator) {

		return _customSQLTestLocalService.getCustomSQLTestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of custom sql tests.
	 *
	 * @return the number of custom sql tests
	 */
	@Override
	public int getCustomSQLTestsCount() {
		return _customSQLTestLocalService.getCustomSQLTestsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _customSQLTestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _customSQLTestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customSQLTestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customSQLTestLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.demo.customsql.model.CustomSQLTest updateCustomSQLTest(
		com.demo.customsql.model.CustomSQLTest customSQLTest) {

		return _customSQLTestLocalService.updateCustomSQLTest(customSQLTest);
	}

	@Override
	public CustomSQLTestLocalService getWrappedService() {
		return _customSQLTestLocalService;
	}

	@Override
	public void setWrappedService(
		CustomSQLTestLocalService customSQLTestLocalService) {

		_customSQLTestLocalService = customSQLTestLocalService;
	}

	private CustomSQLTestLocalService _customSQLTestLocalService;

}