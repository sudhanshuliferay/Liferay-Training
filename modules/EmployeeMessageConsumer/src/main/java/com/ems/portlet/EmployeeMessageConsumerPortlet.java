package com.ems.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.ems.constants.EmployeeMessageConsumerPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmployeeMessageConsumer",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeeMessageConsumerPortletKeys.EMPLOYEEMESSAGECONSUMER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.supported-public-render-parameter=thoughtOfDay"
	},
	service = Portlet.class
)
public class EmployeeMessageConsumerPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		ThemeDisplay display=(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		if(display.isSignedIn()) {
			PortletSession portletSession=renderRequest.getPortletSession(false);
			if(Validator.isNotNull(portletSession)) {
				String userToken=(String)portletSession.getAttribute("userToken", PortletSession.APPLICATION_SCOPE);
				System.out.println("user is able to shared access the token and and the token is : "+userToken);
			}
		}else {
			System.out.println("User is not logged in so not access user token.");
		}
		
		String thoughtOfDay=ParamUtil.getString(renderRequest, "thoughtOfDay");
		System.out.println("thoughtOfDay fro reciver portlet : "+thoughtOfDay);
		renderRequest.setAttribute("thoughtOfDay", thoughtOfDay);
		
		super.render(renderRequest, renderResponse);
	}
	
	
}