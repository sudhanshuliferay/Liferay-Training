package com.lms.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.lms.model.LibraryStore;

import javax.servlet.http.HttpServletRequest;

public class LMSManagmentDisplayContext extends SearchContainerManagementToolbarDisplayContext{
	
	public LMSManagmentDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, HttpServletRequest httpServletRequest,
			SearchContainer<LibraryStore> searchContainer) {
		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest, searchContainer);
	}

	@Override
	protected String getOrderByCol() {
			
		return "bookname";
	}

	@Override
	protected String getDisplayStyle() {
		
		return super.getDisplayStyle();
	}

	@Override
	protected String[] getNavigationKeys() {
		
		return new String[] {"all", "pending", "done"};
	}

	@Override
	protected String[] getOrderByKeys() {
		
		return new String[] {"bookname", "issueDate", "issueTo"};
	}

	@Override
	public int getItemsTotal() {
		return searchContainer.getTotal();
	}

	@Override
	public Boolean isDisabled() {
		return false;
	}
	
}
