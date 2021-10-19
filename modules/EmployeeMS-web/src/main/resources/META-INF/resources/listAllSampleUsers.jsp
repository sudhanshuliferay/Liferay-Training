<%@ include file="init.jsp" %>

<%
	List<Employee> employees=(List<Employee>)renderRequest.getAttribute("samplesEmployees");
%>

<% for(Employee employee:employees){ %>
	Employee email Address,name,: <%=
			employee.getEmailAddress()+","+employee.getEname()
	%>
	<br/>
<%}%>