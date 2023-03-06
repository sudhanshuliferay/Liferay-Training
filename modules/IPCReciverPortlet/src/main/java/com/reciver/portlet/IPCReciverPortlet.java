package com.reciver.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.PortalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.reciver.constants.IPCReciverPortletKeys;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Cookie;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudhanshu
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=IPCReciver", "javax.portlet.supported-public-render-parameter=userMessage",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + IPCReciverPortletKeys.IPCRECIVER, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class IPCReciverPortlet extends MVCPortlet implements EventPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String feedbackMessage = ParamUtil.getString(renderRequest, "userMessage");

		PortletSession portletSession = renderRequest.getPortletSession(false);
		portletSession.setAttribute("fromEmployee", "Sudhanshu Shukla", PortletSession.APPLICATION_SCOPE);
		
		Cookie []cookies=PortalUtil.getHttpServletRequest(renderRequest).getCookies();
		
		
		renderRequest.setAttribute("feedbackMessage", feedbackMessage);
		super.render(renderRequest, renderResponse);
	}

	@ProcessEvent(qname="http://example.com/events",name="exampleEvent")
	public void processEvent(EventRequest request, EventResponse response)
			throws PortletException, java.io.IOException {
		Event event=request.getEvent();
		String usermessage=(String) event.getValue();
		System.out.println("data revived from event is : "+usermessage);
	}

}