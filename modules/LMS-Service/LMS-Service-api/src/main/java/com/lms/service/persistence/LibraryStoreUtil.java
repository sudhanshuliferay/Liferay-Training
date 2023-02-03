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

package com.lms.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.lms.model.LibraryStore;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the library store service. This utility wraps <code>com.lms.service.persistence.impl.LibraryStorePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryStorePersistence
 * @generated
 */
public class LibraryStoreUtil {

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
	public static void clearCache(LibraryStore libraryStore) {
		getPersistence().clearCache(libraryStore);
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
	public static Map<Serializable, LibraryStore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LibraryStore> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LibraryStore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LibraryStore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LibraryStore> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LibraryStore update(LibraryStore libraryStore) {
		return getPersistence().update(libraryStore);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LibraryStore update(
		LibraryStore libraryStore, ServiceContext serviceContext) {

		return getPersistence().update(libraryStore, serviceContext);
	}

	/**
	 * Returns the library store where bookname = &#63; and groupId = &#63; or throws a <code>NoSuchLibraryStoreException</code> if it could not be found.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the matching library store
	 * @throws NoSuchLibraryStoreException if a matching library store could not be found
	 */
	public static LibraryStore findByBookname(String bookname, long groupId)
		throws com.lms.exception.NoSuchLibraryStoreException {

		return getPersistence().findByBookname(bookname, groupId);
	}

	/**
	 * Returns the library store where bookname = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the matching library store, or <code>null</code> if a matching library store could not be found
	 */
	public static LibraryStore fetchByBookname(String bookname, long groupId) {
		return getPersistence().fetchByBookname(bookname, groupId);
	}

	/**
	 * Returns the library store where bookname = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching library store, or <code>null</code> if a matching library store could not be found
	 */
	public static LibraryStore fetchByBookname(
		String bookname, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByBookname(
			bookname, groupId, useFinderCache);
	}

	/**
	 * Removes the library store where bookname = &#63; and groupId = &#63; from the database.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the library store that was removed
	 */
	public static LibraryStore removeByBookname(String bookname, long groupId)
		throws com.lms.exception.NoSuchLibraryStoreException {

		return getPersistence().removeByBookname(bookname, groupId);
	}

	/**
	 * Returns the number of library stores where bookname = &#63; and groupId = &#63;.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the number of matching library stores
	 */
	public static int countByBookname(String bookname, long groupId) {
		return getPersistence().countByBookname(bookname, groupId);
	}

	/**
	 * Returns all the library stores where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @return the matching library stores
	 */
	public static List<LibraryStore> findByIssueDate(
		String issueDate, long groupId) {

		return getPersistence().findByIssueDate(issueDate, groupId);
	}

	/**
	 * Returns a range of all the library stores where issueDate = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryStoreModelImpl</code>.
	 * </p>
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param start the lower bound of the range of library stores
	 * @param end the upper bound of the range of library stores (not inclusive)
	 * @return the range of matching library stores
	 */
	public static List<LibraryStore> findByIssueDate(
		String issueDate, long groupId, int start, int end) {

		return getPersistence().findByIssueDate(issueDate, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the library stores where issueDate = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryStoreModelImpl</code>.
	 * </p>
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param start the lower bound of the range of library stores
	 * @param end the upper bound of the range of library stores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching library stores
	 */
	public static List<LibraryStore> findByIssueDate(
		String issueDate, long groupId, int start, int end,
		OrderByComparator<LibraryStore> orderByComparator) {

		return getPersistence().findByIssueDate(
			issueDate, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the library stores where issueDate = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryStoreModelImpl</code>.
	 * </p>
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param start the lower bound of the range of library stores
	 * @param end the upper bound of the range of library stores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching library stores
	 */
	public static List<LibraryStore> findByIssueDate(
		String issueDate, long groupId, int start, int end,
		OrderByComparator<LibraryStore> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIssueDate(
			issueDate, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first library store in the ordered set where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library store
	 * @throws NoSuchLibraryStoreException if a matching library store could not be found
	 */
	public static LibraryStore findByIssueDate_First(
			String issueDate, long groupId,
			OrderByComparator<LibraryStore> orderByComparator)
		throws com.lms.exception.NoSuchLibraryStoreException {

		return getPersistence().findByIssueDate_First(
			issueDate, groupId, orderByComparator);
	}

	/**
	 * Returns the first library store in the ordered set where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library store, or <code>null</code> if a matching library store could not be found
	 */
	public static LibraryStore fetchByIssueDate_First(
		String issueDate, long groupId,
		OrderByComparator<LibraryStore> orderByComparator) {

		return getPersistence().fetchByIssueDate_First(
			issueDate, groupId, orderByComparator);
	}

	/**
	 * Returns the last library store in the ordered set where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library store
	 * @throws NoSuchLibraryStoreException if a matching library store could not be found
	 */
	public static LibraryStore findByIssueDate_Last(
			String issueDate, long groupId,
			OrderByComparator<LibraryStore> orderByComparator)
		throws com.lms.exception.NoSuchLibraryStoreException {

		return getPersistence().findByIssueDate_Last(
			issueDate, groupId, orderByComparator);
	}

	/**
	 * Returns the last library store in the ordered set where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library store, or <code>null</code> if a matching library store could not be found
	 */
	public static LibraryStore fetchByIssueDate_Last(
		String issueDate, long groupId,
		OrderByComparator<LibraryStore> orderByComparator) {

		return getPersistence().fetchByIssueDate_Last(
			issueDate, groupId, orderByComparator);
	}

	/**
	 * Returns the library stores before and after the current library store in the ordered set where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param lmsID the primary key of the current library store
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library store
	 * @throws NoSuchLibraryStoreException if a library store with the primary key could not be found
	 */
	public static LibraryStore[] findByIssueDate_PrevAndNext(
			long lmsID, String issueDate, long groupId,
			OrderByComparator<LibraryStore> orderByComparator)
		throws com.lms.exception.NoSuchLibraryStoreException {

		return getPersistence().findByIssueDate_PrevAndNext(
			lmsID, issueDate, groupId, orderByComparator);
	}

	/**
	 * Removes all the library stores where issueDate = &#63; and groupId = &#63; from the database.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 */
	public static void removeByIssueDate(String issueDate, long groupId) {
		getPersistence().removeByIssueDate(issueDate, groupId);
	}

	/**
	 * Returns the number of library stores where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @return the number of matching library stores
	 */
	public static int countByIssueDate(String issueDate, long groupId) {
		return getPersistence().countByIssueDate(issueDate, groupId);
	}

	/**
	 * Caches the library store in the entity cache if it is enabled.
	 *
	 * @param libraryStore the library store
	 */
	public static void cacheResult(LibraryStore libraryStore) {
		getPersistence().cacheResult(libraryStore);
	}

	/**
	 * Caches the library stores in the entity cache if it is enabled.
	 *
	 * @param libraryStores the library stores
	 */
	public static void cacheResult(List<LibraryStore> libraryStores) {
		getPersistence().cacheResult(libraryStores);
	}

	/**
	 * Creates a new library store with the primary key. Does not add the library store to the database.
	 *
	 * @param lmsID the primary key for the new library store
	 * @return the new library store
	 */
	public static LibraryStore create(long lmsID) {
		return getPersistence().create(lmsID);
	}

	/**
	 * Removes the library store with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store that was removed
	 * @throws NoSuchLibraryStoreException if a library store with the primary key could not be found
	 */
	public static LibraryStore remove(long lmsID)
		throws com.lms.exception.NoSuchLibraryStoreException {

		return getPersistence().remove(lmsID);
	}

	public static LibraryStore updateImpl(LibraryStore libraryStore) {
		return getPersistence().updateImpl(libraryStore);
	}

	/**
	 * Returns the library store with the primary key or throws a <code>NoSuchLibraryStoreException</code> if it could not be found.
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store
	 * @throws NoSuchLibraryStoreException if a library store with the primary key could not be found
	 */
	public static LibraryStore findByPrimaryKey(long lmsID)
		throws com.lms.exception.NoSuchLibraryStoreException {

		return getPersistence().findByPrimaryKey(lmsID);
	}

	/**
	 * Returns the library store with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store, or <code>null</code> if a library store with the primary key could not be found
	 */
	public static LibraryStore fetchByPrimaryKey(long lmsID) {
		return getPersistence().fetchByPrimaryKey(lmsID);
	}

	/**
	 * Returns all the library stores.
	 *
	 * @return the library stores
	 */
	public static List<LibraryStore> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the library stores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryStoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of library stores
	 * @param end the upper bound of the range of library stores (not inclusive)
	 * @return the range of library stores
	 */
	public static List<LibraryStore> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the library stores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryStoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of library stores
	 * @param end the upper bound of the range of library stores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of library stores
	 */
	public static List<LibraryStore> findAll(
		int start, int end, OrderByComparator<LibraryStore> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the library stores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryStoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of library stores
	 * @param end the upper bound of the range of library stores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of library stores
	 */
	public static List<LibraryStore> findAll(
		int start, int end, OrderByComparator<LibraryStore> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the library stores from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of library stores.
	 *
	 * @return the number of library stores
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LibraryStorePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LibraryStorePersistence, LibraryStorePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LibraryStorePersistence.class);

		ServiceTracker<LibraryStorePersistence, LibraryStorePersistence>
			serviceTracker =
				new ServiceTracker
					<LibraryStorePersistence, LibraryStorePersistence>(
						bundle.getBundleContext(),
						LibraryStorePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}