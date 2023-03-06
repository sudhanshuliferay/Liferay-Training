package com.data.schedular;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.lms.model.LibraryStore;
import com.lms.model.impl.LibraryStoreImpl;
import com.lms.service.LibraryStoreLocalServiceUtil;

import java.util.Date;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

@Component(immediate = true, property = { "cron.expression= 0 0/01 1/1 1/1 * ?" }, service = DataReaderSchedular.class)
public class DataReaderSchedular extends BaseMessageListener {

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Override
	protected void doReceive(Message message) throws Exception {
		log.info("Dorecivemessage is executing in evry 1 minute");
		
	}

	@Activate
	@Modified//1
	protected void activate(Map<String, Object> properties) throws SchedulerException {
		try {
			String cronExpression = GetterUtil.getString(properties.get("cron.expression"), "cronExpression");
			log.info(" cronExpression: " + cronExpression);

			String listenerClass = getClass().getName();
			Trigger jobTrigger = TriggerFactoryUtil.createTrigger(listenerClass, listenerClass, new Date(), null,
					cronExpression);

			SchedulerEntryImpl schedulerEntryImpl = new SchedulerEntryImpl(listenerClass,jobTrigger,"Schedualr for demo data");

			SchedulerEngineHelperUtil.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);

			/*
			 * LibraryStore lms=new LibraryStoreImpl(); long
			 * lmsID=CounterLocalServiceUtil.increment(LibraryStore.class.getName());
			 * 
			 * lms.setLmsID(lmsID); lms.setBookname("BookName_"+lmsID);
			 * lms.setUploadedBy("Sudhanshu"); lms.setIssueDate("27/02/2023");
			 * lms.setIssueTo("asda");
			 * 
			 * if(LibraryStoreLocalServiceUtil.updateLibraryStore(lms)!=null) { System.out.
			 * println("Default booo is added for this users... from the model lustener hook"
			 * ); }
			 */
			
		} catch (Exception e) {
			log.error(e);
		}
	}

	@Deactivate
	protected void deactive() {
		log.info("deregistering the schedualr");
		SchedulerEngineHelperUtil.unregister(this);
	}
}