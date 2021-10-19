package com.ems.dl.hook;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.employee.model.Employee;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * @author sudhanshu
 */
@Component(immediate = true, property = {}, service = ServiceWrapper.class)
public class EmployeeLocalServiceWrapper extends com.employee.service.EmployeeLocalServiceWrapper {

	private Log log=LogFactoryUtil.getLog(this.getClass());
	
	public EmployeeLocalServiceWrapper() {
		super(null);
	}

	@Override
	public Employee createEmployee(long empid) {
		log.info("the generated id is : " + empid + " from employee locaservice.");
		return super.createEmployee(empid);
	}

	@Override
	public List<Employee> listAll() {
		log.info("Getting all the list of employees from service wrapper hook.");
		return super.listAll();
	}

}