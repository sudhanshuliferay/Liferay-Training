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

package com.training.customsql.service.impl;

import com.liferay.portal.aop.AopService;
import com.training.customsql.model.Training;
import com.training.customsql.service.base.TrainingLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the training local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.training.customsql.service.TrainingLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrainingLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.training.customsql.model.Training",
	service = AopService.class
)
public class TrainingLocalServiceImpl extends TrainingLocalServiceBaseImpl {

	public List<Training> findTrainingByName(String trainingName){
		
		return trainingFinder.findTrainingByName(trainingName);
	}
}