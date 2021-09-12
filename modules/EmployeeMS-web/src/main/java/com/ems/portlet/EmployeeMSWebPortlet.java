package com.ems.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.employee.exception.NoSuchDepartmentException;
import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.service.DepartmentLocalServiceUtil;
import com.employee.service.EmployeeLocalService;
import com.ems.constants.EmployeeMSWebPortletKeys;
import com.ems.constants.WebParamConstants;
import com.ems.util.WebEMSUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author sudhanshu
 */
@Component(immediate = true, property = { 
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.render-weight=2",
			"javax.portlet.portlet-mode=text/html;view,edit,help",
			"javax.portlet.init-param.edit-template=/editConfiguration.jsp",
			"javax.portlet.init-param.help-template=/help.jsp",
			"com.liferay.portlet.header-portlet-css=/css/main.css", 
			"com.liferay.portlet.instanceable=true",
			"com.liferay.portlet.private-session-attributes=false",
			"javax.portlet.display-name=EmployeeMSWeb", 
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + EmployeeMSWebPortletKeys.EMPLOYEEMSWEB,
			"javax.portlet.resource-bundle=content.Language",
			"com.liferay.portlet.private-session-attributes=false",
			"javax.portlet.security-role-ref=power-user,user" 
		}, service = Portlet.class)
public class EmployeeMSWebPortlet extends MVCPortlet {

	@Reference
	private EmployeeLocalService employeeLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	private final Log LOG = LogFactoryUtil.getLog(EmployeeMSWebPortlet.class.getName());
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		Employee employee = employeeLocalService.getAllEmpByEmpIdDeptIdEname(1, "sudhanshu", 10);
		if (Validator.isNotNull(employee)) {
			LOG.info("Employee has been found..." + employee.getEname());
		}
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int delta = ParamUtil.getInteger(renderRequest, "delta", 5);
		int startIndex = cur == 1 ? 0 : delta * (cur - 1);
		int endIndex = cur == 1 ? delta
				: delta > employeeLocalService.getEmployeesCount() ? employeeLocalService.getEmployeesCount()
						: startIndex + delta;
		LOG.info("start : " + startIndex + " end : " + endIndex);
		List<Employee> employees = employeeLocalService.getEmployees(startIndex, endIndex);
		if (Validator.isNotNull(employees) && !employees.isEmpty()) {
			LOG.info("The count of employee is : " + employeeLocalService.getEmployeesCount());
			renderRequest.setAttribute("employees", employees);
		} else {
			LOG.info("No employees found.");
		}
		renderRequest.setAttribute("cur", cur);
		renderRequest.setAttribute("delta", delta);

		super.render(renderRequest, renderResponse);
	}

	/**
	 * processAction method for saving employee.
	 */
	public void saveEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {
		long deptId = ParamUtil.getLong(actionRequest, WebParamConstants.DEPT_DEPTNAME, 0);
		String empName = ParamUtil.getString(actionRequest, WebParamConstants.EMP_ENAME, StringPool.BLANK);
		String emailAddress = ParamUtil.getString(actionRequest, WebParamConstants.EMP_EMAILADDRESS, StringPool.BLANK);
		long assignedTeamsId = ParamUtil.getLong(actionRequest, WebParamConstants.EMP_ASSIGNEDTEAMSID, 0);
		ThemeDisplay themeDisplay = WebEMSUtil.getThemeDisplay(actionRequest);
		try {
			if (Validator.isNotNull(empName) && Validator.isEmailAddress(emailAddress) && Validator.isNotNull(deptId)) {
				Department department = DepartmentLocalServiceUtil.fetchDepartment(deptId);
				if (Validator.isNull(department)) {
					throw new NoSuchDepartmentException("No department found with dept id : " + deptId);
				}
				long empId = counterLocalService.increment(Employee.class.getName());
				Employee employee = employeeLocalService.createEmployee(empId);
				employee.setEname(empName);
				employee.setDeptId(department.getDeptId());
				employee.setCreateDate(new Date());
				employee.setUserId(themeDisplay.getUserId());
				employee.setGroupId(themeDisplay.getScopeGroupId());
				employee.setCompanyId(themeDisplay.getCompanyId());
				employeeLocalService.addEmployee(employee);
				LOG.info("Employee is added successfully.");
			} else {
				LOG.info("please fill all the required fields.");
			}
		} catch (NoSuchDepartmentException departmentException) {
			LOG.error(departmentException.getMessage(), departmentException);
		}
	}

	/**
	 * processAction method for saving Department.
	 */
	public void saveDepartment(ActionRequest actionRequest, ActionResponse actionResponse) {
		String deptName = ParamUtil.getString(actionRequest, WebParamConstants.DEPT_DEPTNAME, StringPool.BLANK);
		ThemeDisplay themeDisplay = WebEMSUtil.getThemeDisplay(actionRequest);
		if (Validator.isNotNull(deptName)) {
			long deptId = counterLocalService.increment(Department.class.getName());
			Department department = DepartmentLocalServiceUtil.createDepartment(deptId);
			department.setDeptName(deptName);
			if (Validator.isNotNull(themeDisplay)) {
				department.setUserId(themeDisplay.getUserId());
				department.setGroupId(themeDisplay.getScopeGroupId());
				department.setCompanyId(themeDisplay.getCompanyId());
			}
			DepartmentLocalServiceUtil.addDepartment(department);
			LOG.info("Deptname is added successfully.");
		} else {
			LOG.info("deptname is null or blank or has invalid data.");
		}
	}

	/**
	 * processAction method for delete employee.
	 */
	public void deleteEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {
		long empId = ParamUtil.getLong(actionRequest, WebParamConstants.EMP_EMPID, 0);
		try {
			if (employeeLocalService.deleteEmployee(empId) != null) {
				LOG.info("Department is added successfull.");
			}
		} catch (PortalException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	@Override
	protected boolean callResourceMethod(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		String id = resourceRequest.getResourceID();
		try {
			System.out.println("resource method called with id : "+id);
			PrintWriter out = resourceResponse.getWriter();
			if (id.contains("getTeams")) {
				JSONArray teamsJsonArr = WebEMSUtil.getTeams(-1, -1);
				System.out.println("wrting json string...."+teamsJsonArr.toString());
				out.write(teamsJsonArr.toString());
				
			} else if (id.contains("getDepartments")) {
				JSONArray deptsJsonArr = WebEMSUtil.getDepartments(-1, -1);
				out.write(deptsJsonArr.toString());
			}
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}

		return super.callResourceMethod(resourceRequest, resourceResponse);
	}

}