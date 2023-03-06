package com.langauge.portlet;

import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudhanshu
 */
@Component(
	immediate = true,
	property = {
		"language.id=en_us"
	},
	service = ResourceBundle.class
)
public class LanguageHookPortlet extends ResourceBundle {

	private Log log=LogFactoryUtil.getLog(getClass());
	
	ResourceBundle bundle=ResourceBundle.getBundle("content.Language", new Locale("en","US"), UTF8Control.INSTANCE);
	
	@Override
	public Enumeration<String> getKeys() {
		log.info("getting all keys");
		return bundle.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		log.info("getting key : "+key);
		return bundle.getObject(key);
	}
	
}