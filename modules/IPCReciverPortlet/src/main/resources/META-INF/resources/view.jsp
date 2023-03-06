<%@ include file="init.jsp" %>

<script>
Liferay.fire(
	    'customEventName',
	    {
	        message: 'Hello, portlet2!'
	    }
	);
</script>

<h1>
	Below is the feedback message from : ${feedbackMessage}.
</h1>
