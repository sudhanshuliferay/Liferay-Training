package com.lms.internal.security.permission.resource;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class LMSPermission {

	private static PortletResourcePermission _portletResourcePermission;

	@Reference(target = "(resource.name=com.lms)", unbind = "-")
	protected void setPortletResourcePermission(PortletResourcePermission portletResourcePermission) {

		_portletResourcePermission = portletResourcePermission;
	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {

		return _portletResourcePermission.contains(permissionChecker, groupId, actionId);

	}

}
