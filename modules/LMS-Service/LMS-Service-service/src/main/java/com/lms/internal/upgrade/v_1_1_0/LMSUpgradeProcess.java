//package com.lms.internal.upgrade.v_1_1_0;
//
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.upgrade.UpgradeMVCCVersion;
//import com.liferay.portal.kernel.upgrade.UpgradeProcess;
//import com.liferay.portal.kernel.util.StringUtil;
//import com.lms.model.LibraryStore;
//
//public class LMSUpgradeProcess  {
//
//	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
//
//	@Override
//	protected void doUpgrade() throws Exception {
//		log.info("starting LMS upgrade proces.....");
//		String createTemplate = StringUtil.read(LMSUpgradeProcess.class.getResourceAsStream("dependencies/updates.sql"));
//		boolean hasTable=doHasTable("LMS_LibraryStore");
//		if(!hasTable) {
//			runSQLTemplateString(createTemplate, false, false);
//		}
//		
//		//upgrade(UpgradeMVCCVersion.class);
//
//		alter(LibraryStore.class, new AlterTableAddColumn("authorName"));
//		log.info("LMS upgrade process is completed.....");
//	}
//
//}
