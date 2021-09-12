<%@ include file="init.jsp" %>

<portlet:actionURL name="sendMessage" var="sendMessageURL" />

<aui:form action="${sendMessageURL}" method="post" name="sendMessage">
	<aui:input name="userMessage" type="text" required="true"/>
	<aui:button type="submit" value="Send Feedback Message"/>
</aui:form>