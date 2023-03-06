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

package com.lms.service.base;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import com.lms.model.LibraryStore;
import com.lms.service.LibraryStoreLocalService;
import com.lms.service.persistence.LibraryStoreFinder;
import com.lms.service.persistence.LibraryStorePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the library store local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.lms.service.impl.LibraryStoreLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.lms.service.impl.LibraryStoreLocalServiceImpl
 * @generated
 */
public abstract class LibraryStoreLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, LibraryStoreLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>LibraryStoreLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.lms.service.LibraryStoreLocalServiceUtil</code>.
	 */

	/**
	 * Adds the library store to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryStoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param libraryStore the library store
	 * @return the library store that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LibraryStore addLibraryStore(LibraryStore libraryStore) {
		libraryStore.setNew(true);

		return libraryStorePersistence.update(libraryStore);
	}

	/**
	 * Creates a new library store with the primary key. Does not add the library store to the database.
	 *
	 * @param lmsID the primary key for the new library store
	 * @return the new library store
	 */
	@Override
	@Transactional(enabled = false)
	public LibraryStore createLibraryStore(long lmsID) {
		return libraryStorePersistence.create(lmsID);
	}

	/**
	 * Deletes the library store with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryStoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store that was removed
	 * @throws PortalException if a library store with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LibraryStore deleteLibraryStore(long lmsID) throws PortalException {
		return libraryStorePersistence.remove(lmsID);
	}

	/**
	 * Deletes the library store from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryStoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param libraryStore the library store
	 * @return the library store that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LibraryStore deleteLibraryStore(LibraryStore libraryStore) {
		return libraryStorePersistence.remove(libraryStore);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			LibraryStore.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return libraryStorePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.lms.model.impl.LibraryStoreModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return libraryStorePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.lms.model.impl.LibraryStoreModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return libraryStorePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return libraryStorePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return libraryStorePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public LibraryStore fetchLibraryStore(long lmsID) {
		return libraryStorePersistence.fetchByPrimaryKey(lmsID);
	}

	/**
	 * Returns the library store matching the UUID and group.
	 *
	 * @param uuid the library store's UUID
	 * @param groupId the primary key of the group
	 * @return the matching library store, or <code>null</code> if a matching library store could not be found
	 */
	@Override
	public LibraryStore fetchLibraryStoreByUuidAndGroupId(
		String uuid, long groupId) {

		return libraryStorePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the library store with the primary key.
	 *
	 * @param lmsID the primary key of the library store
	 * @return the library store
	 * @throws PortalException if a library store with the primary key could not be found
	 */
	@Override
	public LibraryStore getLibraryStore(long lmsID) throws PortalException {
		return libraryStorePersistence.findByPrimaryKey(lmsID);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(libraryStoreLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(LibraryStore.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("lmsID");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			libraryStoreLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(LibraryStore.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("lmsID");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(libraryStoreLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(LibraryStore.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("lmsID");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion =
						portletDataContext.getDateRangeCriteria("modifiedDate");

					Criterion statusDateCriterion =
						portletDataContext.getDateRangeCriteria("statusDate");

					if ((modifiedDateCriterion != null) &&
						(statusDateCriterion != null)) {

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty =
						PropertyFactoryUtil.forName("status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(
							workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler =
							StagedModelDataHandlerRegistryUtil.
								getStagedModelDataHandler(
									LibraryStore.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<LibraryStore>() {

				@Override
				public void performAction(LibraryStore libraryStore)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, libraryStore);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(LibraryStore.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return libraryStoreLocalService.deleteLibraryStore(
			(LibraryStore)persistedModel);
	}

	public BasePersistence<LibraryStore> getBasePersistence() {
		return libraryStorePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return libraryStorePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the library stores matching the UUID and company.
	 *
	 * @param uuid the UUID of the library stores
	 * @param companyId the primary key of the company
	 * @return the matching library stores, or an empty list if no matches were found
	 */
	@Override
	public List<LibraryStore> getLibraryStoresByUuidAndCompanyId(
		String uuid, long companyId) {

		return libraryStorePersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of library stores matching the UUID and company.
	 *
	 * @param uuid the UUID of the library stores
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of library stores
	 * @param end the upper bound of the range of library stores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching library stores, or an empty list if no matches were found
	 */
	@Override
	public List<LibraryStore> getLibraryStoresByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LibraryStore> orderByComparator) {

		return libraryStorePersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the library store matching the UUID and group.
	 *
	 * @param uuid the library store's UUID
	 * @param groupId the primary key of the group
	 * @return the matching library store
	 * @throws PortalException if a matching library store could not be found
	 */
	@Override
	public LibraryStore getLibraryStoreByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return libraryStorePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the library stores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.lms.model.impl.LibraryStoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of library stores
	 * @param end the upper bound of the range of library stores (not inclusive)
	 * @return the range of library stores
	 */
	@Override
	public List<LibraryStore> getLibraryStores(int start, int end) {
		return libraryStorePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of library stores.
	 *
	 * @return the number of library stores
	 */
	@Override
	public int getLibraryStoresCount() {
		return libraryStorePersistence.countAll();
	}

	/**
	 * Updates the library store in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryStoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param libraryStore the library store
	 * @return the library store that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LibraryStore updateLibraryStore(LibraryStore libraryStore) {
		return libraryStorePersistence.update(libraryStore);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			LibraryStoreLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		libraryStoreLocalService = (LibraryStoreLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return LibraryStoreLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return LibraryStore.class;
	}

	protected String getModelClassName() {
		return LibraryStore.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = libraryStorePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	protected LibraryStoreLocalService libraryStoreLocalService;

	@Reference
	protected LibraryStorePersistence libraryStorePersistence;

	@Reference
	protected LibraryStoreFinder libraryStoreFinder;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		workflowInstanceLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

}