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
        <portlet:param name="mvcPath"
            value="/editEntry.jsp" />
            <portlet:param name="backurl"
            value="<%=themeDisplay.getURLCurrent()%>" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
            url="<%=editURL.toString() %>" />

    <portlet:actionURL name="delete" var="deleteURL">
            <portlet:param name="lmsId"
                value="<%= String.valueOf(libraryStore.getLmsID()) %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete image="delete"  url="<%=deleteURL.toString() %>" />
	
</liferay-ui:icon-menu>