<%@ include file="init.jsp" %>

<portlet:actionURL name="shareThought" var="shareThoughtURL" />

<aui:form action="${shareThoughtURL }" method="post" name="<portlet:namespace/>thoughtForm">

	<aui:input name="thoughtOfday" type="text"/>
	<aui:button name="Save" type="submit" value="Save" />
</aui:form>


