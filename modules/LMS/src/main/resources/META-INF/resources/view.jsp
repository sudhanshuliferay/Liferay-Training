<%@page import="com.lms.util.LMSSearchConatinerFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.ServletRequestUtil"%>
<%@page import="com.lms.display.context.LMSManagmentDisplayContext"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.lms.service.LibraryStoreLocalServiceUtil"%>
<%@page import="com.lms.model.LibraryStore"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>

<%
	String emailAddress=user.getEmailAddress();
	String currentUrl=themeDisplay.getURLCurrent();
	SimpleDateFormat dateFormat=new SimpleDateFormat("dd/mm/yyyy");
	List<LibraryStore> libraryStores=(List<LibraryStore>)renderRequest.getAttribute("stores");
	SearchContainer mysearchContainer=LMSSearchConatinerFactoryUtil.createConatiner(liferayPortletRequest, liferayPortletResponse, "No-result",libraryStores);
	LMSManagmentDisplayContext searchContainerDisplayContext=new LMSManagmentDisplayContext(liferayPortletRequest,liferayPortletResponse,PortalUtil.getHttpServletRequest(renderRequest),mysearchContainer);
	
%>

<portlet:renderURL var="addEntryURL">
	<%-- <portlet:param name="mvcPath" value="/editEntry.jsp"/> --%>
	<portlet:param name="email" value="${emailAddress}"/>
	<portlet:param name="backurl" value="${currentUrl}"/>
	<portlet:param name="mvcRenderCommandName" value="/lms/editEntry"/>
</portlet:renderURL>


<a href="${addEntryURL}">Add Entry</a>

<hr/>

<clay:management-toolbar
	displayContext="<%= searchContainerDisplayContext %>"	
/>


<liferay-ui:search-container delta="10"  deltaConfigurable="true" searchContainer="<%=mysearchContainer %>">
		<liferay-ui:search-container-row className="com.lms.model.LibraryStore" rowVar="library" keyProperty="lmsID">              
			<liferay-ui:search-container-column-text name="book-name" property="bookname" />
			<liferay-ui:search-container-column-text name="issue-date" property="issueDate" />
			<liferay-ui:search-container-column-user name="issue-to" property="issueTo" />
			<liferay-ui:search-container-column-text name="UploadedBy" property="uploadedBy" />  
			<liferay-ui:search-container-column-status property="status" />
			<liferay-ui:search-container-column-jsp  name="Actions" path="/actions.jsp" >
			</liferay-ui:search-container-column-jsp>
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon" paginate="true" searchContainer="<%=searchContainer %>"/>
</liferay-ui:search-container>