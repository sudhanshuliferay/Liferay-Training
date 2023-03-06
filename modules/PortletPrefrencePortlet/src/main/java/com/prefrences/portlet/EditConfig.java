package com.prefrences.portlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(
		id = "com.prefrences.portlet.EditConfig"
	)
public interface EditConfig {

	
	@Meta.AD(required=false)
	public String colorName();
	
}
