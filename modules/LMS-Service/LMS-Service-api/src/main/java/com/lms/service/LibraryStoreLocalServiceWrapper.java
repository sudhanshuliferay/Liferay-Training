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

package com.lms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LibraryStoreLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LibraryStoreLocalService
 * @generated
 */
public class LibraryStoreLocalServiceWrapper
	implements LibraryStoreLocalService,
			   ServiceWrapper<LibraryStoreLocalService> {

	public LibraryStoreLocalServiceWrapper(
		LibraryStoreLocalService libraryStoreLocalService) {

		_libraryStoreLocalService = libraryStoreLocalService;
	}

	/**
	 * Adds the library store to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryStoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param libraryStore the library store
	 * @return the library store that was added
	 */
	@Override
	public com.lms.model.LibraryStore addLibraryStore(
		com.lms.model.LibraryStore libraryStore) {

		return _libraryStoreLocalService.addLibraryStore(libraryStore);
	}

	/**
	 * Creates a new library store with the primary key. Does not add the library store to the database.
	 *
	 * @param lmsID the primary key for the new library store
	 * @return the new library store
	 */
	@Override
	public com.lms.model.LibraryStore createLibraryStore(long lmsID) {
		return _libraryStoreLocalService.createLibraryStore(lmsID);
	}

	/**
	 * Deletes the library store from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryStoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param libraryStore the library store
	 * @return the library store that was removed
	 */
	@Override
	public com.lms.model.LibraryStore deleteLibraryStore(
		com.lms.model.LibraryStore libraryStore) {

		return _libraryStoreLocalService.deleteLibraryStore(libraryStore);
	}

	/**
	 * Deletes the library store with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryStoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store that was removed
	 * @throws PortalException if a library store with the primary key could not be found
	 */
	@Override
	public com.lms.model.LibraryStore deleteLibraryStore(long lmsID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryStoreLocalService.deleteLibraryStore(lmsID);
	}

	@Override
	public com.lms.model.LibraryStore deleteLibraryStore(
			long lmsId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryStoreLocalService.deleteLibraryStore(
			lmsId, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryStoreLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _libraryStoreLocalService.dynamicQuery();
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

		return _libraryStoreLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.lms.model.impl.LibraryStoreModelImpl</code>.
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

		return _libraryStoreLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.lms.model.impl.LibraryStoreModelImpl</code>.
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

		return _libraryStoreLocalService.dynamicQuery(
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

		return _libraryStoreLocalService.dynamicQueryCount(dynamicQuery);
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

		return _libraryStoreLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.lms.model.LibraryStore fetchLibraryStore(long lmsID) {
		return _libraryStoreLocalService.fetchLibraryStore(lmsID);
	}

	/**
	 * Returns the library store matching the UUID and group.
	 *
	 * @param uuid the library store's UUID
	 * @param groupId the primary key of the group
	 * @return the matching library store, or <code>null</code> if a matching library store could not be found
	 */
	@Override
	public com.lms.model.LibraryStore fetchLibraryStoreByUuidAndGroupId(
		String uuid, long groupId) {

		return _libraryStoreLocalService.fetchLibraryStoreByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.lms.model.LibraryStore>
		findByBookNameFromCustomSQL(String bookName) {

		return _libraryStoreLocalService.findByBookNameFromCustomSQL(bookName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _libraryStoreLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.lms.model.LibraryStore> getAllBooksByIssueDate(
		String issueDate, long groupId) {

		return _libraryStoreLocalService.getAllBooksByIssueDate(
			issueDate, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _libraryStoreLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _libraryStoreLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the library store with the primary key.
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store
	 * @throws PortalException if a library store with the primary key could not be found
	 */
	@Override
	public com.lms.model.LibraryStore getLibraryStore(long lmsID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryStoreLocalService.getLibraryStore(lmsID);
	}

	/**
	 * Returns the library store matching the UUID and group.
	 *
	 * @param uuid the library store's UUID
	 * @param groupId the primary key of the group
	 * @return the matching library store
	 * @throws PortalException if a matching library store could not be found
	 */
	@Override
	public com.lms.model.LibraryStore getLibraryStoreByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryStoreLocalService.getLibraryStoreByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the library stores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.lms.model.impl.LibraryStoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of library stores
	 * @param end the upper bound of the range of library stores (not inclusive)
	 * @return the range of library stores
	 */
	@Override
	public java.util.List<com.lms.model.LibraryStore> getLibraryStores(
		int start, int end) {

		return _libraryStoreLocalService.getLibraryStores(start, end);
	}

	/**
	 * Returns all the library stores matching the UUID and company.
	 *
	 * @param uuid the UUID of the library stores
	 * @param companyId the primary key of the company
	 * @return the matching library stores, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.lms.model.LibraryStore>
		getLibraryStoresByUuidAndCompanyId(String uuid, long companyId) {

		return _libraryStoreLocalService.getLibraryStoresByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of library stores matching the UUID and company.
	 *
	 * @param uuid the UUID of the library stores
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of library stores
	 * @param end the upper bound of the range of library stores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching library stores, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.lms.model.LibraryStore>
		getLibraryStoresByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.lms.model.LibraryStore> orderByComparator) {

		return _libraryStoreLocalService.getLibraryStoresByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of library stores.
	 *
	 * @return the number of library stores
	 */
	@Override
	public int getLibraryStoresCount() {
		return _libraryStoreLocalService.getLibraryStoresCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _libraryStoreLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryStoreLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.lms.model.LibraryStore getStoreByBookName(
			String bookname, long comapnyID)
		throws com.lms.exception.NoSuchLibraryStoreException {

		return _libraryStoreLocalService.getStoreByBookName(
			bookname, comapnyID);
	}

	@Override
	public com.lms.model.LibraryStore saveNewBook(
			long lmsId, String bookName, String issuedBy, String issueDate,
			String issueTo,
			com.liferay.portal.kernel.theme.ThemeDisplay display,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryStoreLocalService.saveNewBook(
			lmsId, bookName, issuedBy, issueDate, issueTo, display,
			serviceContext);
	}

	/**
	 * Updates the library store in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryStoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param libraryStore the library store
	 * @return the library store that was updated
	 */
	@Override
	public com.lms.model.LibraryStore updateLibraryStore(
		com.lms.model.LibraryStore libraryStore) {

		return _libraryStoreLocalService.updateLibraryStore(libraryStore);
	}

	@Override
	public com.lms.model.LibraryStore updateStatus(
			long userId, long lmsId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _libraryStoreLocalService.updateStatus(
			userId, lmsId, status, serviceContext);
	}

	@Override
	public LibraryStoreLocalService getWrappedService() {
		return _libraryStoreLocalService;
	}

	@Override
	public void setWrappedService(
		LibraryStoreLocalService libraryStoreLocalService) {

		_libraryStoreLocalService = libraryStoreLocalService;
	}

	private LibraryStoreLocalService _libraryStoreLocalService;

}