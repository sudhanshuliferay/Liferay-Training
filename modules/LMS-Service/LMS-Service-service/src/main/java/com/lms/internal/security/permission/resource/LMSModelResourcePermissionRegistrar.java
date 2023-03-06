package com.lms.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.lms.model.LibraryStore;
import com.lms.service.LibraryStoreLocalService;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class LMSModelResourcePermissionRegistrar {

	@Reference
	private LibraryStoreLocalService _librarayStoreService;

	@Reference(target = "(resource.name=com.lms)")
	private PortletResourcePermission _portletResourcePermission;

	private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

	@Reference
	private StagingPermission _stagingPermission;

	@Reference
	private WorkflowPermission _workflowPermission;
 
	@Reference
	private GroupLocalService _groupLocalService;

	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("model.class.name", LibraryStore.class.getName());
		
		_serviceRegistration = bundleContext.registerService(
				ModelResourcePermission.class,
				ModelResourcePermissionFactory.create(
					LibraryStore.class, LibraryStore::getLmsID,
					_librarayStoreService::getLibraryStore, _portletResourcePermission,
					(modelResourcePermission, consumer) -> {
						consumer.accept(
							new StagedModelPermissionLogic<>(
								_stagingPermission, "com.lms",
								LibraryStore::getLmsID));
						consumer.accept(
							new WorkflowedModelPermissionLogic<>(
									_workflowPermission, modelResourcePermission,
									_groupLocalService, LibraryStore::getLmsID));
					}),
				properties);
	}

	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}

}
