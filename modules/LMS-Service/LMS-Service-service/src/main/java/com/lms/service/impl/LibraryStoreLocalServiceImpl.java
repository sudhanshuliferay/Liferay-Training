/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lms.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.lms.exception.NoSuchLibraryStoreException;
import com.lms.model.LibraryStore;
import com.lms.model.impl.LibraryStoreImpl;
import com.lms.service.base.LibraryStoreLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the library store local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.lms.service.LibraryStoreLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryStoreLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.lms.model.LibraryStore",
	service = AopService.class
)
public class LibraryStoreLocalServiceImpl
	extends LibraryStoreLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.lms.service.LibraryStoreLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.lms.service.LibraryStoreLocalServiceUtil</code>.
	 */
	
	public boolean saveNewBook(long lmsId,String bookName,String issuedBy,String issueDate,String issueTo,ThemeDisplay display) {
		LibraryStore lms=null;
		if(lmsId>0) {
			lms=libraryStoreLocalService.fetchLibraryStore(lmsId);
		}else {
			lms=new LibraryStoreImpl();
		}
		
		long lmsID=CounterLocalServiceUtil.increment(LibraryStore.class.getName());
		lms.setLmsID(lmsID);
		lms.setBookname(bookName);
		lms.setUploadedBy(issuedBy);
		lms.setIssueDate(issueDate);
		lms.setIssueTo(issueTo);
		lms.setUserId(display.getUserId());
		lms.setGroupId(display.getScopeGroupId());
		lms.setComapnyId(display.getCompanyId());
		
		if(libraryStoreLocalService.updateLibraryStore(lms)!=null) {
			return true;
		}
		
		return false;
	}
	
	public List<LibraryStore> getAllBooksByIssueDate(String issueDate,long groupId){
		return libraryStorePersistence.findByIssueDate(issueDate, groupId);
	}
	
	public LibraryStore getStoreByBookName(String bookname,long comapnyID) throws NoSuchLibraryStoreException {
		return libraryStorePersistence.findByBookname(bookname, comapnyID);
	}
	
	
}