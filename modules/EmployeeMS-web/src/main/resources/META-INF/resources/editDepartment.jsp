<%@ include file="init.jsp" %>


<portlet:actionURL name="saveDepartment" var="saveDepartmentURL" />

<aui:form name="saveDepartmentFrm" action="${saveDepartmentURL}" method="post">

	<aui:input name="deptName" type="text" />

	<aui:button type="submit"></aui:button>
</aui:form>