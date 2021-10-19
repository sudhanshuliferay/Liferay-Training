package com.login.event.hook.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author sudhanshu
 */

@Component(immediate = true, property = { "key=login.events.pre" }, service = LifecycleAction.class)
public class LoginPreEventHook extends Action {

	@Override
	public void run(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ActionException {
		String otpStr = ParamUtil.getString(httpServletRequest, "otp");
		/*
		 * try { if (otpStr.length() == 6) { long otp = Long.parseLong(otpStr); if (otp
		 * > 000000l) { System.out.println("otp successfully validated."); } else {
		 * httpServletResponse.sendError(401); } } else {
		 * System.out.println("otp has some error sending 401 code.");
		 * httpServletResponse.sendRedirect("/c/portal/logout"); } } catch (IOException
		 * e) { e.printStackTrace(); }
		 */
	}
}