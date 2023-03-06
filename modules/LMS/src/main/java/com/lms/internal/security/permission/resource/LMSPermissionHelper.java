package com.lms.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.lms.model.LibraryStore;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class LMSPermissionHelper {

	private static ModelResourcePermission<LibraryStore> _lmsModelResourcePermission;

	@Reference(target = "(model.class.name=com.lms.model.LibraryStore)", unbind = "-")
	protected void setEntryModelPermission(ModelResourcePermission<LibraryStore> modelResourcePermission) {

		_lmsModelResourcePermission = modelResourcePermission;
	}

	public static boolean contains(PermissionChecker permissionChecker, LibraryStore guestbook, String actionId)
			throws PortalException {

		return _lmsModelResourcePermission.contains(permissionChecker, guestbook, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long guestbookId, String actionId)
			throws PortalException {

		return _lmsModelResourcePermission.contains(permissionChecker, guestbookId, actionId);
	}

}
