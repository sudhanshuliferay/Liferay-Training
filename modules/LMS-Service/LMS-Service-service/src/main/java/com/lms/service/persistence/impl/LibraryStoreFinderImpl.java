package com.lms.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.lms.model.LibraryStore;
import com.lms.service.persistence.LibraryStoreFinder;

import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(service = LibraryStoreFinder.class)
public class LibraryStoreFinderImpl extends LibraryStoreFinderBaseImpl implements LibraryStoreFinder {

	public List<LibraryStore> findByBookName(String bookname) {
		System.out.println("Openming the seesion");
		Session session = openSession();
		try {
			System.out.println("Seesione Opened");
			SQLQuery query = session.createSQLQuery(
					CustomSQLUtil.get(getClass(), "com.lms.service.persistence.LibraryStoreFinder.findByBookName"));
			query.addEntity("LMS_LibraryStore", LibraryStore.class);

			QueryPos pos = QueryPos.getInstance(query);

			pos.add(bookname);

			List<LibraryStore> libraryStores = (List<LibraryStore>) QueryUtil.list(query, getDialect(), -1, -1);
			System.out.println("The retrun size is : " + libraryStores.size());
			return libraryStores;
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}finally {
			closeSession(session);
		}
		return Collections.EMPTY_LIST;
	}

}
