<%@page import="com.lms.model.LibraryStore"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.taglib.search.ResultRow"%>
<%@ include file="init.jsp" %>

<%
	ResultRow resultRow=(ResultRow)renderRequest.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	LibraryStore libraryStore=null;
	if(resultRow!=null){
		libraryStore=(LibraryStore)resultRow.getObject();
	}
	
%>

<liferay-ui:icon-menu markupView="lexicon">

    <portlet:renderURL var="editURL">
        <portlet:param name="lmsId"
            value="<%=String.valueOf(libraryStore.getLmsID()) %>" />
       <portlet:param name="mvcRenderCommandName" value="/lms/editEntry"/>
            <portlet:param name="backurl"
            value="<%=themeDisplay.getURLCurrent()%>" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
            url="<%=editURL.toString() %>" />

    <portlet:actionURL name="delete" var="deleteURL">
            <portlet:param name="lmsId"
                value="<%= String.valueOf(libraryStore.getLmsID()) %>" />
    </portlet:actionURL>

	<c:if test="<%=LMSPermission.contains(permissionChecker, libraryStore.getLmsID(), ActionKeys.PERMISSIONS) %>">

	    <liferay-security:permissionsURL
	        modelResource="<%= LibraryStore.class.getName() %>"
	        modelResourceDescription="<%= libraryStore.getBookname() %>"
	        resourcePrimKey="<%= String.valueOf(libraryStore.getLmsID()) %>"
	        var="permissionsURL" />
	
	    <liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />

	</c:if>

    <liferay-ui:icon-delete image="delete"  url="<%=deleteURL.toString() %>" />
	
</liferay-ui:icon-menu>