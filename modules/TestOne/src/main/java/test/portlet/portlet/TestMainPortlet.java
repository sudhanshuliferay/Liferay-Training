package test.portlet.portlet;

import test.portlet.constants.TestMainPortletKeys;

import com.employee.model.Employee;
import com.employee.model.impl.EmployeeImpl;
import com.employee.service.EmployeeLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=TestMain",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TestMainPortletKeys.TESTMAIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TestMainPortlet extends MVCPortlet {

	@Override
	public void destroy() {
		System.out.println("destroy the test portlet");
		super.destroy();
	}
	

	@Override
	public void init() throws PortletException {
		System.out.println("initalizing the test portlet");
		super.init();
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		System.out.println("processaction the test portlet");
		String ename=actionRequest.getParameter("username");
		
		Employee employee=new EmployeeImpl();
	
		long empId=CounterLocalServiceUtil.increment(Employee.class.getName());
		
		employee.setEmpid(empId);
		employee.setEname(ename);
		employee.setDeptId(10);
		
		Employee employee2=EmployeeLocalServiceUtil.addEmployee(employee);
		if(employee2!=null) {
			System.out.println("employee added into db.");
		}
		
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println("render from the test portlet");
		Enumeration<String> reqAttr=renderRequest.getAttributeNames();
		while (reqAttr.hasMoreElements()) {
			String string = (String) reqAttr.nextElement();
			System.out.println("name : "+string+" value : "+renderRequest.getAttribute(string));
		}
		super.render(renderRequest, renderResponse);
	}
	
}