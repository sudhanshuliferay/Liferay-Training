package com.sender.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sender.constants.IPCSenderPortletKeys;

import java.io.IOException;
import java.io.Serializable;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudhanshu
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=IPCSender", "javax.portlet.supported-public-render-parameter=userMessage",
		"com.liferay.portlet.private-session-attributes=false", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + IPCSenderPortletKeys.IPCSENDER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class IPCSenderPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletSession portletSession = renderRequest.getPortletSession(false);
		if (Validator.isNotNull(portletSession)) {
			String fromEmployee = (String) portletSession.getAttribute("fromEmployee",
					PortletSession.APPLICATION_SCOPE);
			System.out.println("from portletsession : " + fromEmployee);
		}

		super.render(renderRequest, renderResponse);
	}

	public void sendMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		String userMessage = ParamUtil.getString(actionRequest, "userMessage");
		actionResponse.getRenderParameters().setValue("userMessage", userMessage);
		QName eventName = new QName("http://example.com/events", "exampleEvent");
		actionResponse.setEvent(eventName, new IPCEvent(eventName, userMessage));
	}

	class IPCEvent implements Event, Serializable {

		private QName eventName;
		private String userMessage;
		private static final long serialVersionUID = 1L;

		IPCEvent(QName eventName, String userMessage) {
			this.eventName = eventName;
			this.userMessage = userMessage;
		}

		@Override
		public Serializable getValue() {
			// TODO Auto-generated method stub
			return userMessage;
		}

		@Override
		public QName getQName() {
			return eventName;
		}

		@Override
		public String getName() {
			return "exampleEvent";
		}

	}
}