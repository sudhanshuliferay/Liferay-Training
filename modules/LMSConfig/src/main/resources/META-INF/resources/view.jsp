<%@page import="java.util.List"%>
<%@page import="com.lms.service.LibraryStoreLocalServiceUtil"%>
<%@page import="com.lms.model.LibraryStore"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="init.jsp" %>


<%
	String value=(String)renderRequest.getAttribute("sampleurl");
	
%>

Webnservice Url is : <%=value%>
<br/>
Create table propperty from Portal-ext.proeprties file :<%=PropsUtil.get("schema.module.build.auto.upgrade")%>

from Custom SQL : <%List<LibraryStore> list= LibraryStoreLocalServiceUtil.findByBookNameFromCustomSQL("Java");
		System.out.println("list siuze is : "+list.size());
	for(LibraryStore libraryStore:list){
		System.out.println("LMS Id : "+libraryStore.getLmsID());
	}


%>