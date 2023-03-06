package com.lms.panel.application.list;

import com.lms.panel.constants.LMSConfigPanelCategoryKeys;
import com.lms.panel.constants.LMSConfigPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + LMSConfigPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class LMSConfigPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return LMSConfigPortletKeys.LMSCONFIG;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + LMSConfigPortletKeys.LMSCONFIG + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}