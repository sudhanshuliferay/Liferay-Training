package com.lms.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.lms.constants.LMSPortletKeys;
import com.lms.service.LibraryStoreLocalServiceUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.Library",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false	",
		"javax.portlet.display-name=LMS",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LMSPortletKeys.LMS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user"
	},
	service = Portlet.class
)
public class LMSPortlet extends MVCPortlet {

	private Log log=LogFactoryUtil.getLog(LMSPortlet.class);
	
	private void dynamicQuery() {
		DynamicQuery dynamicQuery= UserLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.like("screenName", "%default%"));
		
		List<User> users= UserLocalServiceUtil.dynamicQuery(dynamicQuery);
		for (User user : users) {
			System.out.println("Email Address : "+user.getEmailAddress()+" with userid : "+user.getUserId());
		}
	}

	private ThemeDisplay getThemeDisplay(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay=(ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay;
	}
	
	
	public void delete(ActionRequest actionRequest,ActionResponse actionResponse) {
		long lmsID=ParamUtil.getLong(actionRequest, "lmsId");
		
		try {
			if(LibraryStoreLocalServiceUtil.getLibraryStore(lmsID)!=null){
				LibraryStoreLocalServiceUtil.deleteLibraryStore(lmsID, getServiceContext(actionRequest));
				log.info("LMS is deleted successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	private ServiceContext getServiceContext(ActionRequest actionRequest) throws PortalException {
		return ServiceContextFactory.getInstance(actionRequest);
	}
	
}