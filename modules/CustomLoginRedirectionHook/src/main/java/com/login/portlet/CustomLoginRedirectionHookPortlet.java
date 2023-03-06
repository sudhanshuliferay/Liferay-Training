package com.login.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author sudhanshu
 */
@Component(immediate = true, property = { "javax.portlet.name=" + PortletKeys.LOGIN, "mvc.command.name=/login/login",
		"service.ranking:Integer=101" }, service = MVCActionCommand.class)
public class CustomLoginRedirectionHookPortlet extends BaseMVCActionCommand {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference(target = "(&(mvc.command.name=/login/login)(javax.portlet.name=" + PortletKeys.LOGIN + ")"
			+ "(component.name=com.liferay.login.web.internal.portlet.action.LoginMVCActionCommand))")
	private MVCActionCommand mvcActionCommand;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		boolean res = mvcActionCommand.processAction(actionRequest, actionResponse);
		log.info("custom login from mvcActionCommand................");
		
		Enumeration<String> enums=actionRequest.getAttributeNames();
		while (enums.hasMoreElements()) {
			String name = (String) enums.nextElement();
			log.info("Attr name : "+name+" value : "+actionRequest.getAttribute(name));
		}
		
		if (res) {
			ThemeDisplay tDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String siteName = tDisplay.getSiteGroupName();
			PortalUtil.initUser(PortalUtil.getHttpServletRequest(actionRequest));
			if (tDisplay.getUser().getUserGroups().stream().filter((u) -> u.getName().contains("HR")).findAny()
					.isPresent()) {
				actionResponse.sendRedirect("/group/custom-site/customredirect");
			}
		}

	}
}