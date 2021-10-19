package com.login.event.hook.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;

@Component(
		immediate = true,
		property = {
				"key=logout.events.pre"
		},
		service = LifecycleAction.class)
public class LogoutPostEvent extends Action{

	@Override
	public void run(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ActionException {
		System.out.println("logout pre event...............");
	}
}