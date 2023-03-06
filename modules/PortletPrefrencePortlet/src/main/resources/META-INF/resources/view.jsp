<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="init.jsp" %>

<%
boolean doConfigure = Validator.isNull(colorName);

%>

<aui:form>

	<aui:input name="<portlet:namespace/>username"/>
</aui:form>

<form>

	<input name="<portlet:namespace/>somename"/>
</form>

<c:choose>
	<c:when test="<%= doConfigure %>">
		<liferay-ui:message
			key="blade_configurationaction_portlet_BladeMessagePortlet.no-config"
		/>
	</c:when>
	<c:otherwise>
		<p style=" color: <%= colorName %>;">
			<liferay-ui:message
				key="blade_configurationaction_portlet_BladeMessagePortlet.caption"
			/>
		</p>
	</c:otherwise>
</c:choose>
