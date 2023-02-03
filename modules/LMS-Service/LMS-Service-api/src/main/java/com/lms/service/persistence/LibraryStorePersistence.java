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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.lms.exception.NoSuchLibraryStoreException;
import com.lms.model.LibraryStore;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the library store service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryStoreUtil
 * @generated
 */
@ProviderType
public interface LibraryStorePersistence extends BasePersistence<LibraryStore> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LibraryStoreUtil} to access the library store persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the library store where bookname = &#63; and groupId = &#63; or throws a <code>NoSuchLibraryStoreException</code> if it could not be found.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the matching library store
	 * @throws NoSuchLibraryStoreException if a matching library store could not be found
	 */
	public LibraryStore findByBookname(String bookname, long groupId)
		throws NoSuchLibraryStoreException;

	/**
	 * Returns the library store where bookname = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the matching library store, or <code>null</code> if a matching library store could not be found
	 */
	public LibraryStore fetchByBookname(String bookname, long groupId);

	/**
	 * Returns the library store where bookname = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching library store, or <code>null</code> if a matching library store could not be found
	 */
	public LibraryStore fetchByBookname(
		String bookname, long groupId, boolean useFinderCache);

	/**
	 * Removes the library store where bookname = &#63; and groupId = &#63; from the database.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the library store that was removed
	 */
	public LibraryStore removeByBookname(String bookname, long groupId)
		throws NoSuchLibraryStoreException;

	/**
	 * Returns the number of library stores where bookname = &#63; and groupId = &#63;.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the number of matching library stores
	 */
	public int countByBookname(String bookname, long groupId);

	/**
	 * Returns all the library stores where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @return the matching library stores
	 */
	public java.util.List<LibraryStore> findByIssueDate(
		String issueDate, long groupId);

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
	public java.util.List<LibraryStore> findByIssueDate(
		String issueDate, long groupId, int start, int end);

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
	public java.util.List<LibraryStore> findByIssueDate(
		String issueDate, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LibraryStore>
			orderByComparator);

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
	public java.util.List<LibraryStore> findByIssueDate(
		String issueDate, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LibraryStore>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first library store in the ordered set where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library store
	 * @throws NoSuchLibraryStoreException if a matching library store could not be found
	 */
	public LibraryStore findByIssueDate_First(
			String issueDate, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LibraryStore>
				orderByComparator)
		throws NoSuchLibraryStoreException;

	/**
	 * Returns the first library store in the ordered set where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library store, or <code>null</code> if a matching library store could not be found
	 */
	public LibraryStore fetchByIssueDate_First(
		String issueDate, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LibraryStore>
			orderByComparator);

	/**
	 * Returns the last library store in the ordered set where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library store
	 * @throws NoSuchLibraryStoreException if a matching library store could not be found
	 */
	public LibraryStore findByIssueDate_Last(
			String issueDate, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LibraryStore>
				orderByComparator)
		throws NoSuchLibraryStoreException;

	/**
	 * Returns the last library store in the ordered set where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library store, or <code>null</code> if a matching library store could not be found
	 */
	public LibraryStore fetchByIssueDate_Last(
		String issueDate, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LibraryStore>
			orderByComparator);

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
	public LibraryStore[] findByIssueDate_PrevAndNext(
			long lmsID, String issueDate, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LibraryStore>
				orderByComparator)
		throws NoSuchLibraryStoreException;

	/**
	 * Removes all the library stores where issueDate = &#63; and groupId = &#63; from the database.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 */
	public void removeByIssueDate(String issueDate, long groupId);

	/**
	 * Returns the number of library stores where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @return the number of matching library stores
	 */
	public int countByIssueDate(String issueDate, long groupId);

	/**
	 * Caches the library store in the entity cache if it is enabled.
	 *
	 * @param libraryStore the library store
	 */
	public void cacheResult(LibraryStore libraryStore);

	/**
	 * Caches the library stores in the entity cache if it is enabled.
	 *
	 * @param libraryStores the library stores
	 */
	public void cacheResult(java.util.List<LibraryStore> libraryStores);

	/**
	 * Creates a new library store with the primary key. Does not add the library store to the database.
	 *
	 * @param lmsID the primary key for the new library store
	 * @return the new library store
	 */
	public LibraryStore create(long lmsID);

	/**
	 * Removes the library store with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store that was removed
	 * @throws NoSuchLibraryStoreException if a library store with the primary key could not be found
	 */
	public LibraryStore remove(long lmsID) throws NoSuchLibraryStoreException;

	public LibraryStore updateImpl(LibraryStore libraryStore);

	/**
	 * Returns the library store with the primary key or throws a <code>NoSuchLibraryStoreException</code> if it could not be found.
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store
	 * @throws NoSuchLibraryStoreException if a library store with the primary key could not be found
	 */
	public LibraryStore findByPrimaryKey(long lmsID)
		throws NoSuchLibraryStoreException;

	/**
	 * Returns the library store with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store, or <code>null</code> if a library store with the primary key could not be found
	 */
	public LibraryStore fetchByPrimaryKey(long lmsID);

	/**
	 * Returns all the library stores.
	 *
	 * @return the library stores
	 */
	public java.util.List<LibraryStore> findAll();

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
	public java.util.List<LibraryStore> findAll(int start, int end);

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
	public java.util.List<LibraryStore> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LibraryStore>
			orderByComparator);

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
	public java.util.List<LibraryStore> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LibraryStore>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the library stores from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of library stores.
	 *
	 * @return the number of library stores
	 */
	public int countAll();

}