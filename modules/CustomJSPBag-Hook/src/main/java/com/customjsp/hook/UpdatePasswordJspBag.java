package com.customjsp.hook;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.deploy.hot.CustomJspBag;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.url.URLContainer;

@Component(immediate = true, property = { "context.id=UpdatePasswordJspBag", "context.name=Custom JSP Bag",
		"service.ranking:Integer=100" })
public class UpdatePasswordJspBag implements CustomJspBag {

	private Log log=LogFactoryUtil.getLog(this.getClass());
	
	@Override
	public String getCustomJspDir() {
		return "META-INF/jsps/";
	}

	@Override
	public List<String> getCustomJsps() {
		return _customJsps;
	}

	@org.osgi.service.component.annotations.Activate
	protected void activate(BundleContext bundleContext) {
		_bundle = bundleContext.getBundle();

		_customJsps = new ArrayList<>();

		Enumeration<URL> entries = _bundle.findEntries(getCustomJspDir(), "*.jsp", true);

		while (entries.hasMoreElements()) {
			URL url = entries.nextElement();
			log.info("path : "+url.getPath());
			_customJsps.add(url.getPath());
		}

	}

	@Override
	public URLContainer getURLContainer() {
		return _urlContainer;
	}

	private final URLContainer _urlContainer = new URLContainer() {

		@Override
		public URL getResource(String name) {
			return _bundle.getEntry(name);
		}

		@Override
		public Set<String> getResources(String path) {
			Set<String> paths = new HashSet<>();

			for (String entry : _customJsps) {
				if (entry.startsWith(path)) {
					paths.add(entry);
				}
			}
			log.info(paths);
			return paths;
		}

	};

	@Override
	public boolean isCustomJspGlobal() {
		return true;
	}

	private Bundle _bundle;
	private List<String> _customJsps;

}
