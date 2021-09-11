<%@ include file="init.jsp" %>

<p>
	<portlet:actionURL var="save"/>
	
	<portlet:renderURL var="secondOne">
		<portlet:param name="mvcPath" value="/second.jsp"/>
	</portlet:renderURL>
	
	
	<aui:a href="<%=secondOne.toString() %>">Go to second page</aui:a>
	
	<br/>
	<br/>
	
	<aui:form action="<%=save.toString()%>" method="POST" name="namefrm">
		<aui:input name="username" type="text" />
		<aui:button type="submit">Submit</aui:button>
	</aui:form>
</p>