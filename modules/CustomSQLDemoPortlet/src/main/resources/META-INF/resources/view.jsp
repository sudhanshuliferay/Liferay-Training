<%@page import="com.demo.customsql.model.CustomSQLTest"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<%
	List<CustomSQLTest> users=(List<CustomSQLTest>)request.getAttribute("users");
	for(CustomSQLTest userFinde:users){
%>
	UserId : <h1><%=userFinde.getUserId() %></h1><br/>
<%
	}
%>