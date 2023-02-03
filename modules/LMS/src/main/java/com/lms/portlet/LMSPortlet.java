package com.lms.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.lms.constants.LMSPortletKeys;
import com.lms.model.LibraryStore;
import com.lms.service.LibraryStoreLocalService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
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
	
	@Reference
	private LibraryStoreLocalService libraryService;
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = getThemeDisplay(renderRequest);
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/mm/yyyy");

		List<LibraryStore> libraryStores=libraryService.getAllBooksByIssueDate(dateFormat.format(new Date()), themeDisplay.getScopeGroupId());
		
		renderRequest.setAttribute("stores", libraryStores);
		
		super.doView(renderRequest, renderResponse);
	}

	private ThemeDisplay getThemeDisplay(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay=(ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay;
	}
	
	public void saveBookEntry(ActionRequest actionRequest,ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = getThemeDisplay(actionRequest);
		
		long lmsId=ParamUtil.getLong(actionRequest, "lmsId");
		String bookName=ParamUtil.getString(actionRequest, "bookName");
		SimpleDateFormat dateFormat=new SimpleDateFormat("mm/dd/yyyy");
		java.util.Date isuueDate=ParamUtil.getDate(actionRequest, "issueDate", dateFormat);
		log.info("isuueDate:"+isuueDate);
		String issuedTo=ParamUtil.getString(actionRequest, "issueTo");
		String issuedBy=ParamUtil.getString(actionRequest, "issueBy");
		
		if(Validator.isNotNull(bookName)) {
			log.info("Book name : "+bookName);
		}
		
		if(Validator.isNotNull(isuueDate)) {
			log.info("isuueDate : "+isuueDate);
		}
		
		if(Validator.isEmailAddress(issuedBy)) {
			log.info("Email Addrerss : "+issuedBy);
		}
		
		if(libraryService.saveNewBook(lmsId,bookName, issuedBy, dateFormat.format(isuueDate),issuedTo,themeDisplay)) {
			log.info("LMS is added successfully");
		}else {
			log.info("LMS is not addded.");
		}
		
		
	}
	
	
	public void delete(ActionRequest actionRequest,ActionResponse actionResponse) {
		long lmsID=ParamUtil.getLong(actionRequest, "lmsId");
		
		try {
			if(libraryService.getLibraryStore(lmsID)!=null){
				libraryService.deleteLibraryStore(lmsID);
				log.info("LMS is deleted successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
}