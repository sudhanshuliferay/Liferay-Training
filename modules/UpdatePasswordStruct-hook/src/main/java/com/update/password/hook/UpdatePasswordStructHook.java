package com.update.password.hook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author sudhanshu
 */

/*
 * @Component(immediate = true,
 * 
 * property = { "path=/portal/update_password" }, service = StrutsAction.class )
 */

public class UpdatePasswordStructHook implements StrutsAction{
	
	@Override
	public String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		System.out.println("password of : "+ParamUtil.getString(httpServletRequest, "password1"));
		return null;
	}
	
//		System.out.println("password of : "+ParamUtil.getString(httpServletRequest, "password1"));
}