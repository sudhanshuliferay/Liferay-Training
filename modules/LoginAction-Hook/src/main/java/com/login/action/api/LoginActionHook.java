package com.login.action.api;

import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author sudhanshu
 */

@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.LOGIN, "mvc.command.name=/login/login",
		"service.ranking:Integer=102" }, service = MVCActionCommand.class)

public class LoginActionHook extends BaseMVCActionCommand {

	@Reference(target = "(&(mvc.command.name=/login/login)(javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet)(component.name=com.liferay.login.web.internal.portlet.action.LoginMVCActionCommand))")
	private MVCActionCommand mvcActionCommand;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String email=ParamUtil.getString(actionRequest, "login");
		System.out.println("doProcessAction from loginactionhook");
		boolean isLoggedIn = mvcActionCommand.processAction(actionRequest, actionResponse);
		ThemeDisplay themeDisplay=(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long classNameid=ClassNameLocalServiceUtil.getClassNameId(User.class);
		System.out.println("classname id for the user is : "+classNameid);
		
		if (isLoggedIn) {
			User user=UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), email);
			String userNickName=(String)user.getExpandoBridge().getAttribute("UserNickName");
			System.out.println("userickname is : "+userNickName);
			if(user.getRoles().stream().filter(role-> role.getName().contains("Admin")).collect(Collectors.toList()).size()>0) {
				System.out.println("logged in user is amdin user so we are redirecting it.");
				actionResponse.sendRedirect("/web/guest/employees");
			}else {
				System.out.println("The user is normal user...");
			}
		}else {
			System.out.println("user is not logged in ");
		}

	}

}