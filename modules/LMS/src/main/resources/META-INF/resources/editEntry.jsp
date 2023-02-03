<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.lms.service.LibraryStoreLocalServiceUtil"%>
<%@page import="com.lms.model.LibraryStore"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.taglib.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<%
	String emailAddress=user.getEmailAddress();
	List<User> users= UserLocalServiceUtil.getUsers(-1, -1);
	long lmsId=ParamUtil.getLong(renderRequest, "lmsId");	
	LibraryStore libraryStore=null;
	if(lmsId>0){
		libraryStore=LibraryStoreLocalServiceUtil.getLibraryStore(lmsId);
	}
	String backurl=ParamUtil.getString(renderRequest, "backurl");
%>

<portlet:actionURL name="saveBookEntry" var="saveBookUrl">
	<portlet:param name="mvcPath" value="/editEntry.jsp"/>
</portlet:actionURL>

<a href="<%=backurl%>">Go Back</a>

<hr/>

<aui:form action="${saveBookUrl}" method="POST" >
	<%if(libraryStore!=null && libraryStore.getLmsID()>0){ %>
		<aui:input name="lmsId" type="hidden" value="<%=libraryStore.getLmsID() %>" />
		<aui:input name="bookName" type="text" label="book-name" required="true" value="<%=libraryStore.getBookname() %>"/>
		<aui:input name="issuedate" type="date" label="issue-date" required="true" value="<%=libraryStore.getIssueDate() %>"  />
		<aui:input name="issueBy" type="hidden" value="<%=emailAddress%>"/>
		<aui:select name="issueTo" label="issue-to" >
		<%for(User user2:users){ %>
			<aui:option value="<%=user2.getEmailAddress() %>" selected='<%=user2.getAddresses().equals(libraryStore.getIssueTo())?true:false %>'><%=user2.getEmailAddress() %></aui:option>
		<%} %>
		</aui:select>
	
	<%}else{ %>
		<aui:input name="bookName" type="text" label="book-name" required="true" />
		<aui:input name="issuedate" type="date" label="issue-date" required="true" />
		<aui:input name="issueBy" type="hidden" value="<%=emailAddress%>"/>
		<aui:select name="issueTo" label="issue-to">
		<%for(User user2:users){ %>
			<aui:option value="<%=user2.getEmailAddress() %>"><%=user2.getEmailAddress() %></aui:option>
		<%} %>
		</aui:select>
	<%} %>
	<aui:button type="submit" value="Submit"/>
	<aui:button type="reset" value="Reset"/>
</aui:form>

