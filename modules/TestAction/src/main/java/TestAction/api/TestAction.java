package TestAction.api;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.PortletKeys;

/**
 * @author sudhanshu
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+PortletKeys.LOGIN,
				"mvc.command.name=/login/login",
				"service.ranking:Integer=103"
		},
		service = MVCActionCommand.class
		)
public class TestAction extends BaseMVCActionCommand{


	@Reference(target = "(component.name=com.liferay.login.web.internal.portlet.action.LoginMVCActionCommand)")
	private MVCActionCommand actionCommand;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("processaction from test........");
		actionCommand.processAction(actionRequest, actionResponse);
	}
	
}