package com.training.customsql.service.persistence.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.training.customsql.model.Training;
import com.training.customsql.model.impl.TrainingImpl;
import com.training.customsql.service.persistence.TrainingFinder;

@Component(service = TrainingFinder.class)
public class TrainingFinderImpl extends TrainingFinderBaseImpl implements TrainingFinder{

	@Reference
	private CustomSQL customSQL;
	
	public List<Training> findTrainingByName(String trainingName){
		Session session=null;
		try {
			session=openSession();
			
			String userSQlQuery=customSQL.get(getClass(), TrainingFinder.class.getName()+".findTrainingByName");
			SQLQuery query=session.createSQLQuery(userSQlQuery);
			System.out.println("sql Qiery is : "+userSQlQuery);
			query.setCacheable(false);
			query.addEntity("c", TrainingImpl.class);
			
			QueryPos queryPos=QueryPos.getInstance(query);
			queryPos.add(trainingName);
			
			return (List<Training>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        closeSession(session);
	    }
		return null;
	}
	
}
