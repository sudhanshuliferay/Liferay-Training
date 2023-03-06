package com.lms.url.mapper;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.lms.constants.LMSPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(immediate=true,
		property= {
				"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
				"javax.portlet.name="+LMSPortletKeys.LMS
		},
		service=FriendlyURLMapper.class
		)
public class LMSFriendlyUrlMapper extends DefaultFriendlyURLMapper{

	@Override
	public String getMapping() {
		return "lms";
	}
	
}
