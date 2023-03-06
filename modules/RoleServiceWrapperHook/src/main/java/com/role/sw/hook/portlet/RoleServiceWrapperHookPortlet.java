package com.role.sw.hook.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleServiceWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	service = ServiceWrapper.class
)
public class RoleServiceWrapperHookPortlet extends RoleServiceWrapper {

	private Log log=LogFactoryUtil.getLog(this.getClass().getName());
	
	public RoleServiceWrapperHookPortlet() {
		super(null);
	}

	@Override
	public Role addRole(String className, long classPK, String name, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, int type, String subtype, ServiceContext serviceContext)
			throws PortalException {
		name="C_"+name;
		log.info("updating the role name from servicewapper...");
		return super.addRole(className, classPK, name, titleMap, descriptionMap, type, subtype, serviceContext);
	}
	
}