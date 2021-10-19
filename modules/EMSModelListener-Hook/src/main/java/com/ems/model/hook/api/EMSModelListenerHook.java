package com.ems.model.hook.api;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.employee.model.Employee;
import com.employee.service.EmployeeLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

/**
 * @author sudhanshu
 */
@Component(immediate = true, service = ModelListener.class)
public class EMSModelListenerHook extends BaseModelListener<User> {

	@Reference
	private EmployeeLocalService employeeLocalService;

	@Override
	public void onAfterCreate(User model) throws ModelListenerException {
		
		long empId = CounterLocalServiceUtil.increment(Employee.class.getName());
		Employee employee = employeeLocalService.createEmployee(empId);
		employee.setEmailAddress(model.getEmailAddress());
		employee.setDeptId(10);
		employee.setEname(model.getFullName());
		employee.setUserId(model.getUserId());
		employee.setCreateDate(new Date());
		if (employeeLocalService.addEmployee(employee) != null) {
			System.out.println("Employee is added after creates user.");
		} else {
			System.out.println("Not able to add Employee.");
		}
		super.onAfterCreate(model);
	}
	
}