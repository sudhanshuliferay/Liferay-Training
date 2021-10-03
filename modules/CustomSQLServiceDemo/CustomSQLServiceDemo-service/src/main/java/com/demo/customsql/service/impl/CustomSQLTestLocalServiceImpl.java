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

package com.demo.customsql.service.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.demo.customsql.model.CustomSQLTest;
import com.demo.customsql.service.base.CustomSQLTestLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.User;

/**
 * The implementation of the custom sql test local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.demo.customsql.service.CustomSQLTestLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomSQLTestLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.demo.customsql.model.CustomSQLTest",
	service = AopService.class
)
public class CustomSQLTestLocalServiceImpl
	extends CustomSQLTestLocalServiceBaseImpl {

	
	public List<CustomSQLTest> findByScreenNameLikeUser(String screenName){ 
		return customSQLTestFinder.findByScreenNameLikeUser(screenName); 
	}
	 
	
}