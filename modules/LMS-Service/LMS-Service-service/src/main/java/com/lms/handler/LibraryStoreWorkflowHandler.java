package com.lms.handler;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.lms.model.LibraryStore;
import com.lms.service.LibraryStoreLocalService;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = WorkflowHandler.class)
public class LibraryStoreWorkflowHandler extends BaseWorkflowHandler<LibraryStore> {

	@Reference
	private LibraryStoreLocalService libraryStoreLocalService;

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	private ResourceActions _resourceActions;

	@Reference(unbind = "-")
	protected void setResourceActions(ResourceActions resourceActions) {
		_resourceActions = resourceActions;
	}

	@Override
	public String getClassName() {
		return LibraryStore.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return _resourceActions.getModelResource(locale, getClassName());
	}

	@Override
	public LibraryStore updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		try {
			long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
			long rsPk = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
			ServiceContext context = (ServiceContext) workflowContext.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);
			log.info("about to update the workflow status");
			return libraryStoreLocalService.updateStatus(userId, rsPk, status, context);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

}
