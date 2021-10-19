package com.ems.lang.hook;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.UTF8Control;

@Component(immediate = true, property = { "language.id=fr_fr" }, service = ResourceBundle.class)
public class FrenchLanguageHook extends ResourceBundle {

	private ResourceBundle bundle = ResourceBundle.getBundle("content.Language", Locale.FRANCE, UTF8Control.INSTANCE);

	@Override
	public Enumeration<String> getKeys() {
		return bundle.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		return bundle.getObject(key);
	}

}
