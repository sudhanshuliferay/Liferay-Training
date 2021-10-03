package com.demo.customsql.service.persistence.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.demo.customsql.model.CustomSQLTest;
import com.demo.customsql.model.impl.CustomSQLTestImpl;
import com.demo.customsql.service.persistence.CustomSQLTestFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;

@Component(service = CustomSQLTestFinder.class)
public class CustomSQLTestFinderImpl extends CustomSQLTestFinderBaseImpl implements CustomSQLTestFinder{

	public static final String FIND_BY_USERSCREENNAME =
			CustomSQLTestFinder.class.getName() +
		        ".findByScreenNameLikeUser";
	
	@Reference
	private CustomSQL customSql;
	
	public List<CustomSQLTest> findByScreenNameLikeUser(String screenName){
		Session session=null;
		try {
			session=openSession();
			String userSQlQuery=customSql.get(getClass(),FIND_BY_USERSCREENNAME);
			SQLQuery query=session.createSQLQuery(userSQlQuery);
			System.out.println("sql Qiery is : "+userSQlQuery);
			query.setCacheable(false);
			query.addEntity("fc", CustomSQLTestImpl.class);
			
			QueryPos queryPos=QueryPos.getInstance(query);
			queryPos.add(screenName);
			
			return (List<CustomSQLTest>)query.list();
			
		} catch (Exception e) {
			try {
	            throw new SystemException(e);
	        }
	        catch (SystemException se) {
	            se.printStackTrace();
	        }
	    }
	    finally {
	        closeSession(session);
	    }
		return null;
	}
}
