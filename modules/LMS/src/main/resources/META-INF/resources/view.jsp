<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.lms.service.LibraryStoreLocalServiceUtil"%>
<%@page import="com.lms.model.LibraryStore"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>

<%
	String emailAddress=user.getEmailAddress();
	List<LibraryStore> libraryStores=(List<LibraryStore>)renderRequest.getAttribute("stores");
	String currentUrl=themeDisplay.getURLCurrent();
	SimpleDateFormat dateFormat=new SimpleDateFormat("dd/mm/yyyy");
%>


<portlet:renderURL var="addEntryURL">
	<portlet:param name="mvcPath" value="/editEntry.jsp"/>
	<portlet:param name="email" value="${emailAddress}"/>
	<portlet:param name="backurl" value="${currentUrl}"/>
</portlet:renderURL>


<a href="${addEntryURL}">Add Entry</a>

<hr/>

<liferay-ui:search-container cssClass="taglib-empty-result-message-header-has-plus-btn" 
emptyResultsMessage="No-result" delta="5" total="<%=libraryStores.size() %>" deltaConfigurable="true">
		<liferay-ui:search-container-results results="<%=libraryStores %>"/>  
		<liferay-ui:search-container-row className="com.lms.model.LibraryStore" rowVar="library" keyProperty="lmsID">              
			<liferay-ui:search-container-column-text name="book-name" property="bookname" />
			<liferay-ui:search-container-column-text name="issue-date" property="issueDate" />
			<liferay-ui:search-container-column-user name="issue-to" property="issueTo" />
			<liferay-ui:search-container-column-text name="UploadedBy" property="uploadedBy" />  
			
			<liferay-ui:search-container-column-jsp  name="Actions" path="/actions.jsp" >
			</liferay-ui:search-container-column-jsp>
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon" paginate="true" searchContainer="<%=searchContainer %>"/>
</liferay-ui:search-container>