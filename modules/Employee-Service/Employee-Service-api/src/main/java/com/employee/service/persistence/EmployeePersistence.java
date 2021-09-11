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

package com.employee.service.persistence;

import com.employee.exception.NoSuchEmployeeException;
import com.employee.model.Employee;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeUtil
 * @generated
 */
@ProviderType
public interface EmployeePersistence extends BasePersistence<Employee> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeUtil} to access the employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the employee where empid = &#63; and deptId = &#63; and ename = &#63; or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param empid the empid
	 * @param deptId the dept ID
	 * @param ename the ename
	 * @return the matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public Employee findByEmployeesByEmpIDDeptIdEname(
			long empid, long deptId, String ename)
		throws NoSuchEmployeeException;

	/**
	 * Returns the employee where empid = &#63; and deptId = &#63; and ename = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param empid the empid
	 * @param deptId the dept ID
	 * @param ename the ename
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByEmployeesByEmpIDDeptIdEname(
		long empid, long deptId, String ename);

	/**
	 * Returns the employee where empid = &#63; and deptId = &#63; and ename = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param empid the empid
	 * @param deptId the dept ID
	 * @param ename the ename
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public Employee fetchByEmployeesByEmpIDDeptIdEname(
		long empid, long deptId, String ename, boolean useFinderCache);

	/**
	 * Removes the employee where empid = &#63; and deptId = &#63; and ename = &#63; from the database.
	 *
	 * @param empid the empid
	 * @param deptId the dept ID
	 * @param ename the ename
	 * @return the employee that was removed
	 */
	public Employee removeByEmployeesByEmpIDDeptIdEname(
			long empid, long deptId, String ename)
		throws NoSuchEmployeeException;

	/**
	 * Returns the number of employees where empid = &#63; and deptId = &#63; and ename = &#63;.
	 *
	 * @param empid the empid
	 * @param deptId the dept ID
	 * @param ename the ename
	 * @return the number of matching employees
	 */
	public int countByEmployeesByEmpIDDeptIdEname(
		long empid, long deptId, String ename);

	/**
	 * Caches the employee in the entity cache if it is enabled.
	 *
	 * @param employee the employee
	 */
	public void cacheResult(Employee employee);

	/**
	 * Caches the employees in the entity cache if it is enabled.
	 *
	 * @param employees the employees
	 */
	public void cacheResult(java.util.List<Employee> employees);

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param empid the primary key for the new employee
	 * @return the new employee
	 */
	public Employee create(long empid);

	/**
	 * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empid the primary key of the employee
	 * @return the employee that was removed
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public Employee remove(long empid) throws NoSuchEmployeeException;

	public Employee updateImpl(Employee employee);

	/**
	 * Returns the employee with the primary key or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param empid the primary key of the employee
	 * @return the employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public Employee findByPrimaryKey(long empid) throws NoSuchEmployeeException;

	/**
	 * Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empid the primary key of the employee
	 * @return the employee, or <code>null</code> if a employee with the primary key could not be found
	 */
	public Employee fetchByPrimaryKey(long empid);

	/**
	 * Returns all the employees.
	 *
	 * @return the employees
	 */
	public java.util.List<Employee> findAll();

	/**
	 * Returns a range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of employees
	 */
	public java.util.List<Employee> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employees
	 */
	public java.util.List<Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employees
	 */
	public java.util.List<Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Employee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employees from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
	public int countAll();

}