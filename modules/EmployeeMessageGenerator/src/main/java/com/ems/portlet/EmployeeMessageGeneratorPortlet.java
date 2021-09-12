package com.ems.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.ems.constants.EmployeeMessageGeneratorPortletKeys;
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
		"javax.portlet.display-name=EmployeeMessageGenerator",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeeMessageGeneratorPortletKeys.EMPLOYEEMESSAGEGENERATOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		//default value is true
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.supported-public-render-parameter=thoughtOfDay"
	},
	service = Portlet.class
)
public class EmployeeMessageGeneratorPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay display=(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if(display.isSignedIn()) {
			String userToken="sudhanshuxyz@1234dfasdfasv";
			PortletSession portletSession=renderRequest.getPortletSession(false);
			if(Validator.isNotNull(portletSession)) {
				portletSession.setAttribute("userToken", userToken, PortletSession.APPLICATION_SCOPE);
			}
		}else {
			System.out.println("User is not logged in so not generating user token.");
		}
		super.render(renderRequest, renderResponse);
	}
	
	public void shareThought(ActionRequest actionRequest,ActionResponse actionResponse) {
		String thoughtOfDay=ParamUtil.getString(actionRequest, "thoughtOfday");
		System.out.println("thoughtOfDay fro sender portlet : "+thoughtOfDay);
		actionResponse.getRenderParameters().setValue("thoughtOfDay", thoughtOfDay);
		
	}
	
	
	
}