package com.lms.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.lms.constants.LMSPortletKeys;
import com.lms.service.LibraryStoreLocalServiceUtil;

import java.text.SimpleDateFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate=true,
property= {
		"javax.portlet.name="+LMSPortletKeys.LMS,
		"mvc.command.name=/addEntry",
		"service.ranking:Integer=100"
},service=MVCActionCommand.class
)
public class LMSActionCommand extends BaseMVCActionCommand{

	private Log log=LogFactoryUtil.getLog(this.getClass().getName());

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("saving book from the action command.");
		ThemeDisplay themeDisplay=(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext=ServiceContextFactory.getInstance(actionRequest);
		long lmsId=ParamUtil.getLong(actionRequest, "lmsId");
		String bookName=ParamUtil.getString(actionRequest, "bookName");
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
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
		
		if(LibraryStoreLocalServiceUtil.saveNewBook(lmsId,bookName, issuedBy, dateFormat.format(isuueDate),issuedTo,themeDisplay,serviceContext) != null) {
			log.info("LMS is added successfully");
		}else {
			log.info("LMS is not addded.");
		}
	}
	

}
