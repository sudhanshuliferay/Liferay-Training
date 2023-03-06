
package com.modal.hook;

import org.osgi.framework.BundleContext;

/**
 * @author sudhanshu
 */
public class BundleActivator implements org.osgi.framework.BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println(this.getClass()+"Bundle activatro is started.....");
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println(this.getClass()+"Bundle activatro is stopped.....");
	}

}
