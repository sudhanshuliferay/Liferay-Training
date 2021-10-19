package com.ems.dl.hook;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryServiceWrapper;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * @author sudhanshu
 */
@Component(immediate = true, property = {}, service = ServiceWrapper.class)
public class DLServiceWrapperHook extends DLFileEntryServiceWrapper {

	private final Log log = LogFactoryUtil.getLog(this.getClass());

	public DLServiceWrapperHook() {
		super(null);
	}

	@Override
	public DLFileEntry addFileEntry(String externalReferenceCode, long groupId, long repositoryId, long folderId,
			String sourceFileName, String mimeType, String title, String description, String changeLog,
			long fileEntryTypeId, Map<String, DDMFormValues> ddmFormValuesMap, File file, InputStream inputStream,
			long size, Date expirationDate, Date reviewDate, ServiceContext serviceContext) throws PortalException {
		
		//ServiceContext
		//groupId,
		//companyId,
		//userId
		
		Set<Map.Entry<String, DDMFormValues>> entries= ddmFormValuesMap.entrySet();
		
		for (Map.Entry<String, DDMFormValues> entry : entries) {
			log.info("Key : "+entry.getKey()+", value : "+entry.getValue());
		}
		
		Group group = GroupLocalServiceUtil.fetchGroup(groupId);

		if (group.getName().contains("Liferay")) {
			log.info("Not allowed to upload file in default site of Liferay");
			return null;
		}
		return super.addFileEntry(externalReferenceCode, groupId, repositoryId, folderId, sourceFileName, mimeType,
				title, description, changeLog, fileEntryTypeId, ddmFormValuesMap, file, inputStream, size,
				expirationDate, reviewDate, serviceContext);
	}

}