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
				"key=servlet.session.create.events"
		},
		service = LifecycleAction.class)
public class LoginSessionHook extends Action{

	@Override
	public void run(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ActionException {
		System.out.println("session is created................");
	}
}