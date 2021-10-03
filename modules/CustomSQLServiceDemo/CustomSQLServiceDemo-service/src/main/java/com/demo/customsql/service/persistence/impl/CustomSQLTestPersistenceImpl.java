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

package com.demo.customsql.service.persistence.impl;

import com.demo.customsql.exception.NoSuchCustomSQLTestException;
import com.demo.customsql.model.CustomSQLTest;
import com.demo.customsql.model.CustomSQLTestTable;
import com.demo.customsql.model.impl.CustomSQLTestImpl;
import com.demo.customsql.model.impl.CustomSQLTestModelImpl;
import com.demo.customsql.service.persistence.CustomSQLTestPersistence;
import com.demo.customsql.service.persistence.impl.constants.CustomsqlPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
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
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the custom sql test service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {CustomSQLTestPersistence.class, BasePersistence.class})
public class CustomSQLTestPersistenceImpl
	extends BasePersistenceImpl<CustomSQLTest>
	implements CustomSQLTestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CustomSQLTestUtil</code> to access the custom sql test persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CustomSQLTestImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the custom sql tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching custom sql tests
	 */
	@Override
	public List<CustomSQLTest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomSQLTest> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CustomSQLTest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CustomSQLTest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CustomSQLTest> list = null;

		if (useFinderCache) {
			list = (List<CustomSQLTest>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CustomSQLTest customSQLTest : list) {
					if (!uuid.equals(customSQLTest.getUuid())) {
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
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CUSTOMSQLTEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomSQLTestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<CustomSQLTest>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest findByUuid_First(
			String uuid, OrderByComparator<CustomSQLTest> orderByComparator)
		throws NoSuchCustomSQLTestException {

		CustomSQLTest customSQLTest = fetchByUuid_First(
			uuid, orderByComparator);

		if (customSQLTest != null) {
			return customSQLTest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCustomSQLTestException(sb.toString());
	}

	/**
	 * Returns the first custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest fetchByUuid_First(
		String uuid, OrderByComparator<CustomSQLTest> orderByComparator) {

		List<CustomSQLTest> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest findByUuid_Last(
			String uuid, OrderByComparator<CustomSQLTest> orderByComparator)
		throws NoSuchCustomSQLTestException {

		CustomSQLTest customSQLTest = fetchByUuid_Last(uuid, orderByComparator);

		if (customSQLTest != null) {
			return customSQLTest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCustomSQLTestException(sb.toString());
	}

	/**
	 * Returns the last custom sql test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest fetchByUuid_Last(
		String uuid, OrderByComparator<CustomSQLTest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CustomSQLTest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomSQLTest[] findByUuid_PrevAndNext(
			long fooId, String uuid,
			OrderByComparator<CustomSQLTest> orderByComparator)
		throws NoSuchCustomSQLTestException {

		uuid = Objects.toString(uuid, "");

		CustomSQLTest customSQLTest = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			CustomSQLTest[] array = new CustomSQLTestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, customSQLTest, uuid, orderByComparator, true);

			array[1] = customSQLTest;

			array[2] = getByUuid_PrevAndNext(
				session, customSQLTest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomSQLTest getByUuid_PrevAndNext(
		Session session, CustomSQLTest customSQLTest, String uuid,
		OrderByComparator<CustomSQLTest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CUSTOMSQLTEST_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

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
			sb.append(CustomSQLTestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						customSQLTest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomSQLTest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the custom sql tests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CustomSQLTest customSQLTest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(customSQLTest);
		}
	}

	/**
	 * Returns the number of custom sql tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching custom sql tests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CUSTOMSQLTEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"customSQLTest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(customSQLTest.uuid IS NULL OR customSQLTest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the custom sql test where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCustomSQLTestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest findByUUID_G(String uuid, long groupId)
		throws NoSuchCustomSQLTestException {

		CustomSQLTest customSQLTest = fetchByUUID_G(uuid, groupId);

		if (customSQLTest == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCustomSQLTestException(sb.toString());
		}

		return customSQLTest;
	}

	/**
	 * Returns the custom sql test where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the custom sql test where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof CustomSQLTest) {
			CustomSQLTest customSQLTest = (CustomSQLTest)result;

			if (!Objects.equals(uuid, customSQLTest.getUuid()) ||
				(groupId != customSQLTest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CUSTOMSQLTEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<CustomSQLTest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CustomSQLTest customSQLTest = list.get(0);

					result = customSQLTest;

					cacheResult(customSQLTest);
				}
			}
			catch (Exception exception) {
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
			return (CustomSQLTest)result;
		}
	}

	/**
	 * Removes the custom sql test where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the custom sql test that was removed
	 */
	@Override
	public CustomSQLTest removeByUUID_G(String uuid, long groupId)
		throws NoSuchCustomSQLTestException {

		CustomSQLTest customSQLTest = findByUUID_G(uuid, groupId);

		return remove(customSQLTest);
	}

	/**
	 * Returns the number of custom sql tests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching custom sql tests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CUSTOMSQLTEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"customSQLTest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(customSQLTest.uuid IS NULL OR customSQLTest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"customSQLTest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the custom sql tests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching custom sql tests
	 */
	@Override
	public List<CustomSQLTest> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomSQLTest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<CustomSQLTest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CustomSQLTest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CustomSQLTest> list = null;

		if (useFinderCache) {
			list = (List<CustomSQLTest>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CustomSQLTest customSQLTest : list) {
					if (!uuid.equals(customSQLTest.getUuid()) ||
						(companyId != customSQLTest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CUSTOMSQLTEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomSQLTestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<CustomSQLTest>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CustomSQLTest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CustomSQLTest> orderByComparator)
		throws NoSuchCustomSQLTestException {

		CustomSQLTest customSQLTest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (customSQLTest != null) {
			return customSQLTest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCustomSQLTestException(sb.toString());
	}

	/**
	 * Returns the first custom sql test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		List<CustomSQLTest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomSQLTest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CustomSQLTest> orderByComparator)
		throws NoSuchCustomSQLTestException {

		CustomSQLTest customSQLTest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (customSQLTest != null) {
			return customSQLTest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCustomSQLTestException(sb.toString());
	}

	/**
	 * Returns the last custom sql test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CustomSQLTest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomSQLTest[] findByUuid_C_PrevAndNext(
			long fooId, String uuid, long companyId,
			OrderByComparator<CustomSQLTest> orderByComparator)
		throws NoSuchCustomSQLTestException {

		uuid = Objects.toString(uuid, "");

		CustomSQLTest customSQLTest = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			CustomSQLTest[] array = new CustomSQLTestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, customSQLTest, uuid, companyId, orderByComparator,
				true);

			array[1] = customSQLTest;

			array[2] = getByUuid_C_PrevAndNext(
				session, customSQLTest, uuid, companyId, orderByComparator,
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

	protected CustomSQLTest getByUuid_C_PrevAndNext(
		Session session, CustomSQLTest customSQLTest, String uuid,
		long companyId, OrderByComparator<CustomSQLTest> orderByComparator,
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

		sb.append(_SQL_SELECT_CUSTOMSQLTEST_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(CustomSQLTestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						customSQLTest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomSQLTest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the custom sql tests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CustomSQLTest customSQLTest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(customSQLTest);
		}
	}

	/**
	 * Returns the number of custom sql tests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching custom sql tests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CUSTOMSQLTEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"customSQLTest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(customSQLTest.uuid IS NULL OR customSQLTest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"customSQLTest.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByField2;
	private FinderPath _finderPathWithoutPaginationFindByField2;
	private FinderPath _finderPathCountByField2;

	/**
	 * Returns all the custom sql tests where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the matching custom sql tests
	 */
	@Override
	public List<CustomSQLTest> findByField2(boolean field2) {
		return findByField2(field2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomSQLTest> findByField2(
		boolean field2, int start, int end) {

		return findByField2(field2, start, end, null);
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
	@Override
	public List<CustomSQLTest> findByField2(
		boolean field2, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return findByField2(field2, start, end, orderByComparator, true);
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
	@Override
	public List<CustomSQLTest> findByField2(
		boolean field2, int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByField2;
				finderArgs = new Object[] {field2};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByField2;
			finderArgs = new Object[] {field2, start, end, orderByComparator};
		}

		List<CustomSQLTest> list = null;

		if (useFinderCache) {
			list = (List<CustomSQLTest>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CustomSQLTest customSQLTest : list) {
					if (field2 != customSQLTest.isField2()) {
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
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CUSTOMSQLTEST_WHERE);

			sb.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomSQLTestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(field2);

				list = (List<CustomSQLTest>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest findByField2_First(
			boolean field2, OrderByComparator<CustomSQLTest> orderByComparator)
		throws NoSuchCustomSQLTestException {

		CustomSQLTest customSQLTest = fetchByField2_First(
			field2, orderByComparator);

		if (customSQLTest != null) {
			return customSQLTest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("field2=");
		sb.append(field2);

		sb.append("}");

		throw new NoSuchCustomSQLTestException(sb.toString());
	}

	/**
	 * Returns the first custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest fetchByField2_First(
		boolean field2, OrderByComparator<CustomSQLTest> orderByComparator) {

		List<CustomSQLTest> list = findByField2(
			field2, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test
	 * @throws NoSuchCustomSQLTestException if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest findByField2_Last(
			boolean field2, OrderByComparator<CustomSQLTest> orderByComparator)
		throws NoSuchCustomSQLTestException {

		CustomSQLTest customSQLTest = fetchByField2_Last(
			field2, orderByComparator);

		if (customSQLTest != null) {
			return customSQLTest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("field2=");
		sb.append(field2);

		sb.append("}");

		throw new NoSuchCustomSQLTestException(sb.toString());
	}

	/**
	 * Returns the last custom sql test in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom sql test, or <code>null</code> if a matching custom sql test could not be found
	 */
	@Override
	public CustomSQLTest fetchByField2_Last(
		boolean field2, OrderByComparator<CustomSQLTest> orderByComparator) {

		int count = countByField2(field2);

		if (count == 0) {
			return null;
		}

		List<CustomSQLTest> list = findByField2(
			field2, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CustomSQLTest[] findByField2_PrevAndNext(
			long fooId, boolean field2,
			OrderByComparator<CustomSQLTest> orderByComparator)
		throws NoSuchCustomSQLTestException {

		CustomSQLTest customSQLTest = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			CustomSQLTest[] array = new CustomSQLTestImpl[3];

			array[0] = getByField2_PrevAndNext(
				session, customSQLTest, field2, orderByComparator, true);

			array[1] = customSQLTest;

			array[2] = getByField2_PrevAndNext(
				session, customSQLTest, field2, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomSQLTest getByField2_PrevAndNext(
		Session session, CustomSQLTest customSQLTest, boolean field2,
		OrderByComparator<CustomSQLTest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CUSTOMSQLTEST_WHERE);

		sb.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

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
			sb.append(CustomSQLTestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(field2);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						customSQLTest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomSQLTest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the custom sql tests where field2 = &#63; from the database.
	 *
	 * @param field2 the field2
	 */
	@Override
	public void removeByField2(boolean field2) {
		for (CustomSQLTest customSQLTest :
				findByField2(
					field2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(customSQLTest);
		}
	}

	/**
	 * Returns the number of custom sql tests where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the number of matching custom sql tests
	 */
	@Override
	public int countByField2(boolean field2) {
		FinderPath finderPath = _finderPathCountByField2;

		Object[] finderArgs = new Object[] {field2};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CUSTOMSQLTEST_WHERE);

			sb.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(field2);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIELD2_FIELD2_2 =
		"customSQLTest.field2 = ?";

	public CustomSQLTestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CustomSQLTest.class);

		setModelImplClass(CustomSQLTestImpl.class);
		setModelPKClass(long.class);

		setTable(CustomSQLTestTable.INSTANCE);
	}

	/**
	 * Caches the custom sql test in the entity cache if it is enabled.
	 *
	 * @param customSQLTest the custom sql test
	 */
	@Override
	public void cacheResult(CustomSQLTest customSQLTest) {
		entityCache.putResult(
			CustomSQLTestImpl.class, customSQLTest.getPrimaryKey(),
			customSQLTest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {customSQLTest.getUuid(), customSQLTest.getGroupId()},
			customSQLTest);
	}

	/**
	 * Caches the custom sql tests in the entity cache if it is enabled.
	 *
	 * @param customSQLTests the custom sql tests
	 */
	@Override
	public void cacheResult(List<CustomSQLTest> customSQLTests) {
		for (CustomSQLTest customSQLTest : customSQLTests) {
			if (entityCache.getResult(
					CustomSQLTestImpl.class, customSQLTest.getPrimaryKey()) ==
						null) {

				cacheResult(customSQLTest);
			}
		}
	}

	/**
	 * Clears the cache for all custom sql tests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CustomSQLTestImpl.class);

		finderCache.clearCache(CustomSQLTestImpl.class);
	}

	/**
	 * Clears the cache for the custom sql test.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustomSQLTest customSQLTest) {
		entityCache.removeResult(CustomSQLTestImpl.class, customSQLTest);
	}

	@Override
	public void clearCache(List<CustomSQLTest> customSQLTests) {
		for (CustomSQLTest customSQLTest : customSQLTests) {
			entityCache.removeResult(CustomSQLTestImpl.class, customSQLTest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CustomSQLTestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CustomSQLTestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CustomSQLTestModelImpl customSQLTestModelImpl) {

		Object[] args = new Object[] {
			customSQLTestModelImpl.getUuid(),
			customSQLTestModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, customSQLTestModelImpl);
	}

	/**
	 * Creates a new custom sql test with the primary key. Does not add the custom sql test to the database.
	 *
	 * @param fooId the primary key for the new custom sql test
	 * @return the new custom sql test
	 */
	@Override
	public CustomSQLTest create(long fooId) {
		CustomSQLTest customSQLTest = new CustomSQLTestImpl();

		customSQLTest.setNew(true);
		customSQLTest.setPrimaryKey(fooId);

		String uuid = PortalUUIDUtil.generate();

		customSQLTest.setUuid(uuid);

		customSQLTest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return customSQLTest;
	}

	/**
	 * Removes the custom sql test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test that was removed
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	@Override
	public CustomSQLTest remove(long fooId)
		throws NoSuchCustomSQLTestException {

		return remove((Serializable)fooId);
	}

	/**
	 * Removes the custom sql test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom sql test
	 * @return the custom sql test that was removed
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	@Override
	public CustomSQLTest remove(Serializable primaryKey)
		throws NoSuchCustomSQLTestException {

		Session session = null;

		try {
			session = openSession();

			CustomSQLTest customSQLTest = (CustomSQLTest)session.get(
				CustomSQLTestImpl.class, primaryKey);

			if (customSQLTest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomSQLTestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(customSQLTest);
		}
		catch (NoSuchCustomSQLTestException noSuchEntityException) {
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
	protected CustomSQLTest removeImpl(CustomSQLTest customSQLTest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customSQLTest)) {
				customSQLTest = (CustomSQLTest)session.get(
					CustomSQLTestImpl.class, customSQLTest.getPrimaryKeyObj());
			}

			if (customSQLTest != null) {
				session.delete(customSQLTest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (customSQLTest != null) {
			clearCache(customSQLTest);
		}

		return customSQLTest;
	}

	@Override
	public CustomSQLTest updateImpl(CustomSQLTest customSQLTest) {
		boolean isNew = customSQLTest.isNew();

		if (!(customSQLTest instanceof CustomSQLTestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(customSQLTest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					customSQLTest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in customSQLTest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CustomSQLTest implementation " +
					customSQLTest.getClass());
		}

		CustomSQLTestModelImpl customSQLTestModelImpl =
			(CustomSQLTestModelImpl)customSQLTest;

		if (Validator.isNull(customSQLTest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			customSQLTest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (customSQLTest.getCreateDate() == null)) {
			if (serviceContext == null) {
				customSQLTest.setCreateDate(date);
			}
			else {
				customSQLTest.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!customSQLTestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				customSQLTest.setModifiedDate(date);
			}
			else {
				customSQLTest.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(customSQLTest);
			}
			else {
				customSQLTest = (CustomSQLTest)session.merge(customSQLTest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CustomSQLTestImpl.class, customSQLTestModelImpl, false, true);

		cacheUniqueFindersCache(customSQLTestModelImpl);

		if (isNew) {
			customSQLTest.setNew(false);
		}

		customSQLTest.resetOriginalValues();

		return customSQLTest;
	}

	/**
	 * Returns the custom sql test with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom sql test
	 * @return the custom sql test
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	@Override
	public CustomSQLTest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomSQLTestException {

		CustomSQLTest customSQLTest = fetchByPrimaryKey(primaryKey);

		if (customSQLTest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomSQLTestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return customSQLTest;
	}

	/**
	 * Returns the custom sql test with the primary key or throws a <code>NoSuchCustomSQLTestException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test
	 * @throws NoSuchCustomSQLTestException if a custom sql test with the primary key could not be found
	 */
	@Override
	public CustomSQLTest findByPrimaryKey(long fooId)
		throws NoSuchCustomSQLTestException {

		return findByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns the custom sql test with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the custom sql test
	 * @return the custom sql test, or <code>null</code> if a custom sql test with the primary key could not be found
	 */
	@Override
	public CustomSQLTest fetchByPrimaryKey(long fooId) {
		return fetchByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns all the custom sql tests.
	 *
	 * @return the custom sql tests
	 */
	@Override
	public List<CustomSQLTest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CustomSQLTest> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CustomSQLTest> findAll(
		int start, int end,
		OrderByComparator<CustomSQLTest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CustomSQLTest> findAll(
		int start, int end, OrderByComparator<CustomSQLTest> orderByComparator,
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

		List<CustomSQLTest> list = null;

		if (useFinderCache) {
			list = (List<CustomSQLTest>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CUSTOMSQLTEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMSQLTEST;

				sql = sql.concat(CustomSQLTestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CustomSQLTest>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the custom sql tests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CustomSQLTest customSQLTest : findAll()) {
			remove(customSQLTest);
		}
	}

	/**
	 * Returns the number of custom sql tests.
	 *
	 * @return the number of custom sql tests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CUSTOMSQLTEST);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "fooId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CUSTOMSQLTEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustomSQLTestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom sql test persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CustomSQLTestModelArgumentsResolver(),
			new HashMapDictionary<>());

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByField2 = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField2",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"field2"}, true);

		_finderPathWithoutPaginationFindByField2 = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField2",
			new String[] {Boolean.class.getName()}, new String[] {"field2"},
			true);

		_finderPathCountByField2 = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField2",
			new String[] {Boolean.class.getName()}, new String[] {"field2"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CustomSQLTestImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	@Override
	@Reference(
		target = CustomsqlPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CustomsqlPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CustomsqlPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CUSTOMSQLTEST =
		"SELECT customSQLTest FROM CustomSQLTest customSQLTest";

	private static final String _SQL_SELECT_CUSTOMSQLTEST_WHERE =
		"SELECT customSQLTest FROM CustomSQLTest customSQLTest WHERE ";

	private static final String _SQL_COUNT_CUSTOMSQLTEST =
		"SELECT COUNT(customSQLTest) FROM CustomSQLTest customSQLTest";

	private static final String _SQL_COUNT_CUSTOMSQLTEST_WHERE =
		"SELECT COUNT(customSQLTest) FROM CustomSQLTest customSQLTest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "customSQLTest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CustomSQLTest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CustomSQLTest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CustomSQLTestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class CustomSQLTestModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			CustomSQLTestModelImpl customSQLTestModelImpl =
				(CustomSQLTestModelImpl)baseModel;

			long columnBitmask = customSQLTestModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(customSQLTestModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						customSQLTestModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(customSQLTestModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return CustomSQLTestImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return CustomSQLTestTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			CustomSQLTestModelImpl customSQLTestModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						customSQLTestModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = customSQLTestModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= CustomSQLTestModelImpl.getColumnBitmask(
				"field1");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}