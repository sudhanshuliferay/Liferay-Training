package com.login.event.portlet;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	property = {
		"key=login.events.post"
	},
	service = LifecycleAction.class
)
public class PreLoginEventHookPortlet implements LifecycleAction {

	private Log log=LogFactoryUtil.getLog(this.getClass().getName());
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		log.info("Login Post Event Triggered.");
		HttpServletRequest request =lifecycleEvent.getRequest();
		Enumeration<String> enums=request.getAttributeNames();
		while (enums.hasMoreElements()) {
			String name = (String) enums.nextElement();
			log.info("Attr name : "+name+" value : "+request.getAttribute(name));
		}
	}
	
}