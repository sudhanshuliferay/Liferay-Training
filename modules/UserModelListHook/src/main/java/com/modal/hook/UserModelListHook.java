package com.modal.hook;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.lms.model.LibraryStore;
import com.lms.model.impl.LibraryStoreImpl;
import com.lms.service.LibraryStoreLocalServiceUtil;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	service = ModelListener.class
)
public class UserModelListHook extends BaseModelListener<User> {

	@Override
	public void onAfterCreate(User model) throws ModelListenerException {
		System.out.println("onAfterCreate started.....");
		LibraryStore lms=new LibraryStoreImpl();
		long lmsID=CounterLocalServiceUtil.increment(LibraryStore.class.getName());
		
		lms.setLmsID(lmsID);
		lms.setBookname("BookName_"+model.getFullName()+lmsID);
		lms.setUploadedBy(model.getFullName());
		lms.setIssueDate("27/02/2023");
		lms.setIssueTo("asda");
		
		if(LibraryStoreLocalServiceUtil.updateLibraryStore(lms)!=null) {
			System.out.println("Default booo is added for this users... from the model lustener hook");
		}
		
		super.onAfterCreate(model);
	}

}