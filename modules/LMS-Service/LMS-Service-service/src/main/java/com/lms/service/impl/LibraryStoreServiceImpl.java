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
import com.lms.model.LibraryStore;
import com.lms.model.impl.LibraryStoreImpl;
import com.lms.service.base.LibraryStoreServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the library store remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.lms.service.LibraryStoreService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryStoreServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=lms",
		"json.web.service.context.path=LibraryStore"
	},
	service = AopService.class
)
public class LibraryStoreServiceImpl extends LibraryStoreServiceBaseImpl {
	
	public void saveLibrary(String bookName) {
		LibraryStore lms=new LibraryStoreImpl();
		long lmsID=CounterLocalServiceUtil.increment(LibraryStore.class.getName());
		lms.setLmsID(lmsID);
		lms.setBookname(bookName);
		
		if(libraryStoreLocalService.updateLibraryStore(lms)!=null) {
			System.out.println("Added from webservice Util..");
		}
	}
}