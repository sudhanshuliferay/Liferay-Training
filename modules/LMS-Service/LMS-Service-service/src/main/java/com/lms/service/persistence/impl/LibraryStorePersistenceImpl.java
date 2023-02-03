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

package com.lms.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.lms.exception.NoSuchLibraryStoreException;
import com.lms.model.LibraryStore;
import com.lms.model.impl.LibraryStoreImpl;
import com.lms.model.impl.LibraryStoreModelImpl;
import com.lms.service.persistence.LibraryStorePersistence;
import com.lms.service.persistence.impl.constants.LMSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the library store service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LibraryStorePersistence.class)
public class LibraryStorePersistenceImpl
	extends BasePersistenceImpl<LibraryStore>
	implements LibraryStorePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LibraryStoreUtil</code> to access the library store persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LibraryStoreImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByBookname;
	private FinderPath _finderPathCountByBookname;

	/**
	 * Returns the library store where bookname = &#63; and groupId = &#63; or throws a <code>NoSuchLibraryStoreException</code> if it could not be found.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the matching library store
	 * @throws NoSuchLibraryStoreException if a matching library store could not be found
	 */
	@Override
	public LibraryStore findByBookname(String bookname, long groupId)
		throws NoSuchLibraryStoreException {

		LibraryStore libraryStore = fetchByBookname(bookname, groupId);

		if (libraryStore == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("bookname=");
			sb.append(bookname);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLibraryStoreException(sb.toString());
		}

		return libraryStore;
	}

	/**
	 * Returns the library store where bookname = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the matching library store, or <code>null</code> if a matching library store could not be found
	 */
	@Override
	public LibraryStore fetchByBookname(String bookname, long groupId) {
		return fetchByBookname(bookname, groupId, true);
	}

	/**
	 * Returns the library store where bookname = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching library store, or <code>null</code> if a matching library store could not be found
	 */
	@Override
	public LibraryStore fetchByBookname(
		String bookname, long groupId, boolean useFinderCache) {

		bookname = Objects.toString(bookname, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {bookname, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByBookname, finderArgs, this);
		}

		if (result instanceof LibraryStore) {
			LibraryStore libraryStore = (LibraryStore)result;

			if (!Objects.equals(bookname, libraryStore.getBookname()) ||
				(groupId != libraryStore.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LIBRARYSTORE_WHERE);

			boolean bindBookname = false;

			if (bookname.isEmpty()) {
				sb.append(_FINDER_COLUMN_BOOKNAME_BOOKNAME_3);
			}
			else {
				bindBookname = true;

				sb.append(_FINDER_COLUMN_BOOKNAME_BOOKNAME_2);
			}

			sb.append(_FINDER_COLUMN_BOOKNAME_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBookname) {
					queryPos.add(bookname);
				}

				queryPos.add(groupId);

				List<LibraryStore> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByBookname, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {bookname, groupId};
							}

							_log.warn(
								"LibraryStorePersistenceImpl.fetchByBookname(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LibraryStore libraryStore = list.get(0);

					result = libraryStore;

					cacheResult(libraryStore);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByBookname, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (LibraryStore)result;
		}
	}

	/**
	 * Removes the library store where bookname = &#63; and groupId = &#63; from the database.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the library store that was removed
	 */
	@Override
	public LibraryStore removeByBookname(String bookname, long groupId)
		throws NoSuchLibraryStoreException {

		LibraryStore libraryStore = findByBookname(bookname, groupId);

		return remove(libraryStore);
	}

	/**
	 * Returns the number of library stores where bookname = &#63; and groupId = &#63;.
	 *
	 * @param bookname the bookname
	 * @param groupId the group ID
	 * @return the number of matching library stores
	 */
	@Override
	public int countByBookname(String bookname, long groupId) {
		bookname = Objects.toString(bookname, "");

		FinderPath finderPath = _finderPathCountByBookname;

		Object[] finderArgs = new Object[] {bookname, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LIBRARYSTORE_WHERE);

			boolean bindBookname = false;

			if (bookname.isEmpty()) {
				sb.append(_FINDER_COLUMN_BOOKNAME_BOOKNAME_3);
			}
			else {
				bindBookname = true;

				sb.append(_FINDER_COLUMN_BOOKNAME_BOOKNAME_2);
			}

			sb.append(_FINDER_COLUMN_BOOKNAME_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBookname) {
					queryPos.add(bookname);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BOOKNAME_BOOKNAME_2 =
		"libraryStore.bookname = ? AND ";

	private static final String _FINDER_COLUMN_BOOKNAME_BOOKNAME_3 =
		"(libraryStore.bookname IS NULL OR libraryStore.bookname = '') AND ";

	private static final String _FINDER_COLUMN_BOOKNAME_GROUPID_2 =
		"libraryStore.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByIssueDate;
	private FinderPath _finderPathWithoutPaginationFindByIssueDate;
	private FinderPath _finderPathCountByIssueDate;

	/**
	 * Returns all the library stores where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @return the matching library stores
	 */
	@Override
	public List<LibraryStore> findByIssueDate(String issueDate, long groupId) {
		return findByIssueDate(
			issueDate, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LibraryStore> findByIssueDate(
		String issueDate, long groupId, int start, int end) {

		return findByIssueDate(issueDate, groupId, start, end, null);
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
	@Override
	public List<LibraryStore> findByIssueDate(
		String issueDate, long groupId, int start, int end,
		OrderByComparator<LibraryStore> orderByComparator) {

		return findByIssueDate(
			issueDate, groupId, start, end, orderByComparator, true);
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
	@Override
	public List<LibraryStore> findByIssueDate(
		String issueDate, long groupId, int start, int end,
		OrderByComparator<LibraryStore> orderByComparator,
		boolean useFinderCache) {

		issueDate = Objects.toString(issueDate, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIssueDate;
				finderArgs = new Object[] {issueDate, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIssueDate;
			finderArgs = new Object[] {
				issueDate, groupId, start, end, orderByComparator
			};
		}

		List<LibraryStore> list = null;

		if (useFinderCache) {
			list = (List<LibraryStore>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LibraryStore libraryStore : list) {
					if (!issueDate.equals(libraryStore.getIssueDate()) ||
						(groupId != libraryStore.getGroupId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LIBRARYSTORE_WHERE);

			boolean bindIssueDate = false;

			if (issueDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_3);
			}
			else {
				bindIssueDate = true;

				sb.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_2);
			}

			sb.append(_FINDER_COLUMN_ISSUEDATE_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LibraryStoreModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIssueDate) {
					queryPos.add(issueDate);
				}

				queryPos.add(groupId);

				list = (List<LibraryStore>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LibraryStore findByIssueDate_First(
			String issueDate, long groupId,
			OrderByComparator<LibraryStore> orderByComparator)
		throws NoSuchLibraryStoreException {

		LibraryStore libraryStore = fetchByIssueDate_First(
			issueDate, groupId, orderByComparator);

		if (libraryStore != null) {
			return libraryStore;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issueDate=");
		sb.append(issueDate);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchLibraryStoreException(sb.toString());
	}

	/**
	 * Returns the first library store in the ordered set where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library store, or <code>null</code> if a matching library store could not be found
	 */
	@Override
	public LibraryStore fetchByIssueDate_First(
		String issueDate, long groupId,
		OrderByComparator<LibraryStore> orderByComparator) {

		List<LibraryStore> list = findByIssueDate(
			issueDate, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LibraryStore findByIssueDate_Last(
			String issueDate, long groupId,
			OrderByComparator<LibraryStore> orderByComparator)
		throws NoSuchLibraryStoreException {

		LibraryStore libraryStore = fetchByIssueDate_Last(
			issueDate, groupId, orderByComparator);

		if (libraryStore != null) {
			return libraryStore;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issueDate=");
		sb.append(issueDate);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchLibraryStoreException(sb.toString());
	}

	/**
	 * Returns the last library store in the ordered set where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library store, or <code>null</code> if a matching library store could not be found
	 */
	@Override
	public LibraryStore fetchByIssueDate_Last(
		String issueDate, long groupId,
		OrderByComparator<LibraryStore> orderByComparator) {

		int count = countByIssueDate(issueDate, groupId);

		if (count == 0) {
			return null;
		}

		List<LibraryStore> list = findByIssueDate(
			issueDate, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LibraryStore[] findByIssueDate_PrevAndNext(
			long lmsID, String issueDate, long groupId,
			OrderByComparator<LibraryStore> orderByComparator)
		throws NoSuchLibraryStoreException {

		issueDate = Objects.toString(issueDate, "");

		LibraryStore libraryStore = findByPrimaryKey(lmsID);

		Session session = null;

		try {
			session = openSession();

			LibraryStore[] array = new LibraryStoreImpl[3];

			array[0] = getByIssueDate_PrevAndNext(
				session, libraryStore, issueDate, groupId, orderByComparator,
				true);

			array[1] = libraryStore;

			array[2] = getByIssueDate_PrevAndNext(
				session, libraryStore, issueDate, groupId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LibraryStore getByIssueDate_PrevAndNext(
		Session session, LibraryStore libraryStore, String issueDate,
		long groupId, OrderByComparator<LibraryStore> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LIBRARYSTORE_WHERE);

		boolean bindIssueDate = false;

		if (issueDate.isEmpty()) {
			sb.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_3);
		}
		else {
			bindIssueDate = true;

			sb.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_2);
		}

		sb.append(_FINDER_COLUMN_ISSUEDATE_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LibraryStoreModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIssueDate) {
			queryPos.add(issueDate);
		}

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(libraryStore)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LibraryStore> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the library stores where issueDate = &#63; and groupId = &#63; from the database.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 */
	@Override
	public void removeByIssueDate(String issueDate, long groupId) {
		for (LibraryStore libraryStore :
				findByIssueDate(
					issueDate, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(libraryStore);
		}
	}

	/**
	 * Returns the number of library stores where issueDate = &#63; and groupId = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param groupId the group ID
	 * @return the number of matching library stores
	 */
	@Override
	public int countByIssueDate(String issueDate, long groupId) {
		issueDate = Objects.toString(issueDate, "");

		FinderPath finderPath = _finderPathCountByIssueDate;

		Object[] finderArgs = new Object[] {issueDate, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LIBRARYSTORE_WHERE);

			boolean bindIssueDate = false;

			if (issueDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_3);
			}
			else {
				bindIssueDate = true;

				sb.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_2);
			}

			sb.append(_FINDER_COLUMN_ISSUEDATE_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIssueDate) {
					queryPos.add(issueDate);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ISSUEDATE_ISSUEDATE_2 =
		"libraryStore.issueDate = ? AND ";

	private static final String _FINDER_COLUMN_ISSUEDATE_ISSUEDATE_3 =
		"(libraryStore.issueDate IS NULL OR libraryStore.issueDate = '') AND ";

	private static final String _FINDER_COLUMN_ISSUEDATE_GROUPID_2 =
		"libraryStore.groupId = ?";

	public LibraryStorePersistenceImpl() {
		setModelClass(LibraryStore.class);

		setModelImplClass(LibraryStoreImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the library store in the entity cache if it is enabled.
	 *
	 * @param libraryStore the library store
	 */
	@Override
	public void cacheResult(LibraryStore libraryStore) {
		entityCache.putResult(
			entityCacheEnabled, LibraryStoreImpl.class,
			libraryStore.getPrimaryKey(), libraryStore);

		finderCache.putResult(
			_finderPathFetchByBookname,
			new Object[] {
				libraryStore.getBookname(), libraryStore.getGroupId()
			},
			libraryStore);

		libraryStore.resetOriginalValues();
	}

	/**
	 * Caches the library stores in the entity cache if it is enabled.
	 *
	 * @param libraryStores the library stores
	 */
	@Override
	public void cacheResult(List<LibraryStore> libraryStores) {
		for (LibraryStore libraryStore : libraryStores) {
			if (entityCache.getResult(
					entityCacheEnabled, LibraryStoreImpl.class,
					libraryStore.getPrimaryKey()) == null) {

				cacheResult(libraryStore);
			}
			else {
				libraryStore.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all library stores.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LibraryStoreImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the library store.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LibraryStore libraryStore) {
		entityCache.removeResult(
			entityCacheEnabled, LibraryStoreImpl.class,
			libraryStore.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LibraryStoreModelImpl)libraryStore, true);
	}

	@Override
	public void clearCache(List<LibraryStore> libraryStores) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LibraryStore libraryStore : libraryStores) {
			entityCache.removeResult(
				entityCacheEnabled, LibraryStoreImpl.class,
				libraryStore.getPrimaryKey());

			clearUniqueFindersCache((LibraryStoreModelImpl)libraryStore, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LibraryStoreImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LibraryStoreModelImpl libraryStoreModelImpl) {

		Object[] args = new Object[] {
			libraryStoreModelImpl.getBookname(),
			libraryStoreModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByBookname, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByBookname, args, libraryStoreModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LibraryStoreModelImpl libraryStoreModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				libraryStoreModelImpl.getBookname(),
				libraryStoreModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByBookname, args);
			finderCache.removeResult(_finderPathFetchByBookname, args);
		}

		if ((libraryStoreModelImpl.getColumnBitmask() &
			 _finderPathFetchByBookname.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				libraryStoreModelImpl.getOriginalBookname(),
				libraryStoreModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByBookname, args);
			finderCache.removeResult(_finderPathFetchByBookname, args);
		}
	}

	/**
	 * Creates a new library store with the primary key. Does not add the library store to the database.
	 *
	 * @param lmsID the primary key for the new library store
	 * @return the new library store
	 */
	@Override
	public LibraryStore create(long lmsID) {
		LibraryStore libraryStore = new LibraryStoreImpl();

		libraryStore.setNew(true);
		libraryStore.setPrimaryKey(lmsID);

		return libraryStore;
	}

	/**
	 * Removes the library store with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store that was removed
	 * @throws NoSuchLibraryStoreException if a library store with the primary key could not be found
	 */
	@Override
	public LibraryStore remove(long lmsID) throws NoSuchLibraryStoreException {
		return remove((Serializable)lmsID);
	}

	/**
	 * Removes the library store with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the library store
	 * @return the library store that was removed
	 * @throws NoSuchLibraryStoreException if a library store with the primary key could not be found
	 */
	@Override
	public LibraryStore remove(Serializable primaryKey)
		throws NoSuchLibraryStoreException {

		Session session = null;

		try {
			session = openSession();

			LibraryStore libraryStore = (LibraryStore)session.get(
				LibraryStoreImpl.class, primaryKey);

			if (libraryStore == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLibraryStoreException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(libraryStore);
		}
		catch (NoSuchLibraryStoreException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LibraryStore removeImpl(LibraryStore libraryStore) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(libraryStore)) {
				libraryStore = (LibraryStore)session.get(
					LibraryStoreImpl.class, libraryStore.getPrimaryKeyObj());
			}

			if (libraryStore != null) {
				session.delete(libraryStore);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (libraryStore != null) {
			clearCache(libraryStore);
		}

		return libraryStore;
	}

	@Override
	public LibraryStore updateImpl(LibraryStore libraryStore) {
		boolean isNew = libraryStore.isNew();

		if (!(libraryStore instanceof LibraryStoreModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(libraryStore.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					libraryStore);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in libraryStore proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LibraryStore implementation " +
					libraryStore.getClass());
		}

		LibraryStoreModelImpl libraryStoreModelImpl =
			(LibraryStoreModelImpl)libraryStore;

		Session session = null;

		try {
			session = openSession();

			if (libraryStore.isNew()) {
				session.save(libraryStore);

				libraryStore.setNew(false);
			}
			else {
				libraryStore = (LibraryStore)session.merge(libraryStore);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				libraryStoreModelImpl.getIssueDate(),
				libraryStoreModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByIssueDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByIssueDate, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((libraryStoreModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByIssueDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					libraryStoreModelImpl.getOriginalIssueDate(),
					libraryStoreModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByIssueDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIssueDate, args);

				args = new Object[] {
					libraryStoreModelImpl.getIssueDate(),
					libraryStoreModelImpl.getGroupId()
				};

				finderCache.removeResult(_finderPathCountByIssueDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIssueDate, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LibraryStoreImpl.class,
			libraryStore.getPrimaryKey(), libraryStore, false);

		clearUniqueFindersCache(libraryStoreModelImpl, false);
		cacheUniqueFindersCache(libraryStoreModelImpl);

		libraryStore.resetOriginalValues();

		return libraryStore;
	}

	/**
	 * Returns the library store with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the library store
	 * @return the library store
	 * @throws NoSuchLibraryStoreException if a library store with the primary key could not be found
	 */
	@Override
	public LibraryStore findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLibraryStoreException {

		LibraryStore libraryStore = fetchByPrimaryKey(primaryKey);

		if (libraryStore == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLibraryStoreException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return libraryStore;
	}

	/**
	 * Returns the library store with the primary key or throws a <code>NoSuchLibraryStoreException</code> if it could not be found.
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store
	 * @throws NoSuchLibraryStoreException if a library store with the primary key could not be found
	 */
	@Override
	public LibraryStore findByPrimaryKey(long lmsID)
		throws NoSuchLibraryStoreException {

		return findByPrimaryKey((Serializable)lmsID);
	}

	/**
	 * Returns the library store with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store, or <code>null</code> if a library store with the primary key could not be found
	 */
	@Override
	public LibraryStore fetchByPrimaryKey(long lmsID) {
		return fetchByPrimaryKey((Serializable)lmsID);
	}

	/**
	 * Returns all the library stores.
	 *
	 * @return the library stores
	 */
	@Override
	public List<LibraryStore> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LibraryStore> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<LibraryStore> findAll(
		int start, int end, OrderByComparator<LibraryStore> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<LibraryStore> findAll(
		int start, int end, OrderByComparator<LibraryStore> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<LibraryStore> list = null;

		if (useFinderCache) {
			list = (List<LibraryStore>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LIBRARYSTORE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LIBRARYSTORE;

				sql = sql.concat(LibraryStoreModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LibraryStore>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the library stores from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LibraryStore libraryStore : findAll()) {
			remove(libraryStore);
		}
	}

	/**
	 * Returns the number of library stores.
	 *
	 * @return the number of library stores
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LIBRARYSTORE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "lmsID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LIBRARYSTORE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LibraryStoreModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the library store persistence.
	 */
	@Activate
	public void activate() {
		LibraryStoreModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LibraryStoreModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LibraryStoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LibraryStoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByBookname = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LibraryStoreImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByBookname",
			new String[] {String.class.getName(), Long.class.getName()},
			LibraryStoreModelImpl.BOOKNAME_COLUMN_BITMASK |
			LibraryStoreModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByBookname = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBookname",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByIssueDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LibraryStoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIssueDate",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByIssueDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LibraryStoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIssueDate",
			new String[] {String.class.getName(), Long.class.getName()},
			LibraryStoreModelImpl.ISSUEDATE_COLUMN_BITMASK |
			LibraryStoreModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByIssueDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIssueDate",
			new String[] {String.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LibraryStoreImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = LMSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.lms.model.LibraryStore"),
			true);
	}

	@Override
	@Reference(
		target = LMSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = LMSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LIBRARYSTORE =
		"SELECT libraryStore FROM LibraryStore libraryStore";

	private static final String _SQL_SELECT_LIBRARYSTORE_WHERE =
		"SELECT libraryStore FROM LibraryStore libraryStore WHERE ";

	private static final String _SQL_COUNT_LIBRARYSTORE =
		"SELECT COUNT(libraryStore) FROM LibraryStore libraryStore";

	private static final String _SQL_COUNT_LIBRARYSTORE_WHERE =
		"SELECT COUNT(libraryStore) FROM LibraryStore libraryStore WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "libraryStore.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LibraryStore exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LibraryStore exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LibraryStorePersistenceImpl.class);

	static {
		try {
			Class.forName(LMSPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}