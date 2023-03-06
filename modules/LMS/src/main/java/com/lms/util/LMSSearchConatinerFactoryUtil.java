package com.lms.util;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.lms.model.LibraryStore;

import java.util.List;

public class LMSSearchConatinerFactoryUtil {

	private static Log log=LogFactoryUtil.getLog(LMSSearchConatinerFactoryUtil.class.getName());
	
	public static SearchContainer<LibraryStore> createConatiner(LiferayPortletRequest liferayPortletRequest,LiferayPortletResponse liferayPortletResponse, String emptyResultsMessage,List<LibraryStore> libraryStores){
		SearchContainer<LibraryStore> searchContainer=new SearchContainer<LibraryStore>
		(liferayPortletRequest, PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse), null, emptyResultsMessage);
		
		log.info("total results are : "+libraryStores.size());
		searchContainer.setSearch(true);
		searchContainer.setResults(libraryStores);
		searchContainer.setTotal(libraryStores.size());
		searchContainer.setCssClass("taglib-empty-result-message-header-has-plus-btn");
		
		return searchContainer;
	}
}
