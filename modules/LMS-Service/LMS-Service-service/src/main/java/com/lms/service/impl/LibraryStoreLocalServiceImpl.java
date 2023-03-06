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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
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
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.lms.service.LibraryStoreLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryStoreLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.lms.model.LibraryStore", service = AopService.class)
public class LibraryStoreLocalServiceImpl extends LibraryStoreLocalServiceBaseImpl {

	private Log log = LogFactoryUtil.getLog(getClass().getName());

	@Indexable(type = IndexableType.REINDEX)
	public LibraryStore saveNewBook(long lmsId, String bookName, String issuedBy, String issueDate, String issueTo,
			ThemeDisplay display, ServiceContext serviceContext) throws PortalException {
		LibraryStore lms = null;
		try {
			boolean isUpdate = lmsId > 0;
			if (isUpdate) {
				lms = libraryStoreLocalService.fetchLibraryStore(lmsId);
			} else {
				lms = new LibraryStoreImpl();
				long lmsID = CounterLocalServiceUtil.increment(LibraryStore.class.getName());
				lms.setLmsID(lmsID);
			}

			lms.setBookname(bookName);
			lms.setUploadedBy(issuedBy);
			lms.setIssueDate(issueDate);
			lms.setIssueTo(issueTo);
			lms.setUserId(display.getUserId());
			lms.setGroupId(display.getScopeGroupId());
			lms.setCompanyId(display.getCompanyId());
			if (isUpdate) {
				lms.setModifiedDate(new Date());
			} else {
				lms.setCreatedDate(new Date());
			}

			lms = libraryStoreLocalService.updateLibraryStore(lms);
			if (lms == null) {
				return null;
			}

			if (isUpdate) {
				resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
						LibraryStore.class.getName(), lms.getLmsID(), serviceContext.getGroupPermissions(),
						serviceContext.getGuestPermissions());
			} else {
				resourceLocalService.addResources(display.getCompanyId(), display.getScopeGroupId(),
						display.getUserId(), LibraryStore.class.getName(), lmsId, false, true, true);
			}

			AssetEntry assetEntry = assetEntryLocalService.updateEntry(display.getUserId(), display.getScopeGroupId(),
					lms.getCreatedDate(), lms.getModifiedDate(), LibraryStore.class.getName(), lms.getLmsID(), null, 0,
					serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true, null, null,
					null, null, ContentTypes.TEXT_HTML, lms.getBookname(), null, null, null, null, 0, 0, null);

			assetLinkLocalService.updateLinks(display.getUserId(), assetEntry.getEntryId(),
					serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);

			WorkflowHandlerRegistryUtil.startWorkflowInstance(lms.getCompanyId(), lms.getGroupId(), lms.getUserId(),
					LibraryStore.class.getName(), lms.getPrimaryKey(), lms, serviceContext);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return lms;
	}

	public List<LibraryStore> findByBookNameFromCustomSQL(String bookName) {
		System.out.println("calling find by Book name: " + bookName);
		return libraryStoreFinder.findByBookName(bookName);
	}

	public List<LibraryStore> getAllBooksByIssueDate(String issueDate, long groupId) {
		return libraryStorePersistence.findByIssueDate(issueDate, groupId);
	}

	public LibraryStore getStoreByBookName(String bookname, long comapnyID) throws NoSuchLibraryStoreException {
		return libraryStorePersistence.findByBookname(bookname, comapnyID);
	}

	@Indexable(type = IndexableType.DELETE)
	public LibraryStore deleteLibraryStore(long lmsId, ServiceContext serviceContext) throws PortalException {
		LibraryStore libraryStore = getLibraryStore(lmsId);
		libraryStore = libraryStoreLocalService.deleteLibraryStore(libraryStore);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(), LibraryStore.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, libraryStore.getLmsID());
 
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(LibraryStore.class.getName(), lmsId);
		if(Validator.isNotNull(assetEntry)) {
			assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
			assetEntryLocalService.deleteAssetEntry(assetEntry);
		}
		workflowInstanceLinkLocalService.deleteWorkflowInstanceLink(libraryStore.getCompanyId(),
				libraryStore.getGroupId(), LibraryStore.class.getName(), lmsId);

		return libraryStore;
	}

	public LibraryStore updateStatus(long userId, long lmsId, int status, ServiceContext serviceContext)
			throws PortalException, SystemException {
		try {
			User user = userLocalService.getUser(userId);
			LibraryStore libraryStore = getLibraryStore(lmsId);
			libraryStore.setStatus(status);
			libraryStore.setStatusByUserId(user.getUserId());
			libraryStore.setStatusByUserName(user.getFullName());
			libraryStore.setStatusByUserUuid(user.getUuid());
			libraryStore.setStatusDate(new Date());
			if (libraryStorePersistence.update(libraryStore) != null) {
				log.info("Libraray Store " + lmsId + " Updated with workflow status: " + status);
			}
			if (status == WorkflowConstants.STATUS_APPROVED) {
				assetEntryLocalService.updateVisible(LibraryStore.class.getName(), lmsId, true);
			} else {
				assetEntryLocalService.updateVisible(LibraryStore.class.getName(), lmsId, false);
			}
			return libraryStore;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

}