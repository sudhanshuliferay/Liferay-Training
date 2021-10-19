package com.ems.lang.hook;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.UTF8Control;

@Component(immediate = true, property = { "language.id=en_US" }, service = ResourceBundle.class)
public class CustomLanguageHook extends ResourceBundle {

	private ResourceBundle bundle = ResourceBundle.getBundle("content.Language", UTF8Control.INSTANCE);

	@Override
	public Enumeration<String> getKeys() {
		return bundle.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		return bundle.getObject(key);
	}

}
