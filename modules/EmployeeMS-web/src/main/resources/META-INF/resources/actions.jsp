<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="init.jsp"%>

<%
	ResultRow resultRow=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Employee employee=(Employee)resultRow.getObject();
%>

<liferay-ui:icon-menu markupView="lexicon">

    <portlet:renderURL var="editURL">
        <portlet:param name="empId"
            value="<%=String.valueOf(employee.getEmpid()) %>" />
        <portlet:param name="mvcPath"
            value="/editEmployee.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
            url="<%=editURL.toString() %>" />

    <portlet:actionURL name="deleteEmployee" var="deleteURL">
            <portlet:param name="empId"
                value="<%= String.valueOf(employee.getEmpid()) %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

</liferay-ui:icon-menu>