//package com.lms.internal.upgrade;
//
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
//import com.lms.internal.upgrade.v_1_1_0.LMSUpgradeProcess;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(immediate=true,service=UpgradeStepRegistrator.class)
//public class LMSUpgradeRegistrator implements UpgradeStepRegistrator{
//
//	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
//	
//	@Override
//	public void register(Registry registry) {
//		try {
//		log.info("trying to register the upgrade process....");
//		registry.register(
//	             "1.0.0", "1.1.0",
//	            new LMSUpgradeProcess());
//		log.info("registering the upgrade process is successfull...");
//		}catch(Exception e) {
//			
//			log.error("Unable to complete Upgrade Process : "+e.getMessage(),e);
//		}
//		
//	}
//
//}
