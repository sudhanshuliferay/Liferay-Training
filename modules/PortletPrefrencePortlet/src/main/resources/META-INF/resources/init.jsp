<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.prefrences.portlet.EditConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
EditConfig editConfig =
(EditConfig)
renderRequest.getAttribute(EditConfig.class.getName());
String colorName="";
if(Validator.isNull(colorName)){
	colorName=portletPreferences.getValue("colorName", editConfig.colorName());
}
%>