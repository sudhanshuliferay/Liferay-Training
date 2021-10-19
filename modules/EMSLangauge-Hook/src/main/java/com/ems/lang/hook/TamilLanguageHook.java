package com.ems.lang.hook;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.UTF8Control;

@Component(immediate = true, property = { "language.id=ta_IN" }, service = ResourceBundle.class)
public class TamilLanguageHook extends ResourceBundle {

	//Internationalization or localization 
	private ResourceBundle bundle = ResourceBundle.getBundle("content.Language", new Locale("ta","IN"), UTF8Control.INSTANCE);

	@Override
	public Enumeration<String> getKeys() {
		return bundle.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		return bundle.getObject(key);
	}

}
