package com.prefrences.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.prefrences.constants.MyPortletPrefrencePortletKeys;

import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	configurationPid="com.prefrences.portlet.EditConfig",
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MyPortletPrefrence",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MyPortletPrefrencePortletKeys.MYPORTLETPREFRENCE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MyPortletPrefrencePortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(
			MyPortletPrefrencePortlet.class);

	private volatile EditConfig _editConfiguration;
	
	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException, java.io.IOException {

		if (_log.isInfoEnabled()) {
			_log.info("Blade Message Portlet render");
		}

		renderRequest.setAttribute(
				EditConfig.class.getName(),
			_editConfiguration);

		super.doView(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_log.info("Map : "+properties);
		_editConfiguration = ConfigurableUtil.createConfigurable(
				EditConfig.class, properties);
	}

}