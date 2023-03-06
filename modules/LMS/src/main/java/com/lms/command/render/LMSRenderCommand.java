package com.lms.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.lms.constants.LMSPortletKeys;
import com.lms.model.LibraryStore;
import com.lms.service.LibraryStoreLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + LMSPortletKeys.LMS, "mvc.command.name=/lms/editEntry",
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class LMSRenderCommand implements MVCRenderCommand {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	@Reference
	private MVCRenderCommand mvcRenderCommand;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		log.info("render edit command from LMSRenderCommand");

		String commandName = ParamUtil.getString(renderRequest, "mvcRenderCommandName");
		log.info("Command name is : " + commandName);
		String defaultPage = "/view.jsp";
		if (commandName.equalsIgnoreCase("/lms/editEntry")) {
			defaultPage = "/editEntry.jsp";
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		log.info("search date is : " + dateFormat.format(new Date()));
		List<LibraryStore> libraryStores = LibraryStoreLocalServiceUtil.getLibraryStores(-1, -1);

		renderRequest.setAttribute("stores", libraryStores);

		return defaultPage;
	}

}
