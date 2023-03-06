package com.strut.login.api;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.StrutsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@SuppressWarnings("deprecation")
@Component(immediate=true,
property= {
		"path=/portal/login"
},service=StrutsAction.class)
public class LoginStructActionHook implements StrutsAction{

	private Log log=LogFactoryUtil.getLog(getClass().getName());

	/*
	 * @Override public String execute(StrutsAction originalStrutsAction,
	 * HttpServletRequest httpServletRequest, HttpServletResponse
	 * httpServletResponse) throws Exception {
	 * log.info("portal login method called from the strut action hook.....");
	 * return originalStrutsAction.execute(originalStrutsAction, httpServletRequest,
	 * httpServletResponse); }
	 */

	@Override
	public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		return null;
	}
	
}