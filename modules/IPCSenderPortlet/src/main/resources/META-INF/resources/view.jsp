<%@ include file="init.jsp" %>

<portlet:actionURL name="sendMessage" var="sendMessageURL" />

<h1 id="sayHello"></h1>

<aui:form action="${sendMessageURL}" method="post" name="sendMessage">
	<aui:input name="userMessage" type="text" required="true"/>
	<aui:button type="submit" value="Send Feedback Message"/>
</aui:form>

<script>
Liferay.on(
	    'customEventName',
	    function(event) {
	        var message = event.message;
	        console.log("Event reviced: "+message);
	        document.getElementById("sayHello").innerHTML=message;
	    }
	);
</script>