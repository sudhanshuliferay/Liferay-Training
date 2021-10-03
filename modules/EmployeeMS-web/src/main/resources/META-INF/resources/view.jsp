<%@ include file="init.jsp" %>

<%
	//portletSession => this is object only accebile in the current portlet. Inter Portlet Communication, portlet_scope,application_scope | 
	//session => HTTPSession global object for complete liferay portal.
	//portletConfig => all the information saved into init param you get from the portletconfig.
	//config => all the information saved into init param you get from the config.
	//application => all the information saved into init param you get from the servlet context for complete Liferay application.
	//plid => portletID
	
	List<Employee> employees=(List<Employee>)renderRequest.getAttribute("employees");
	int cur=(int)renderRequest.getAttribute("cur");
	int delta=(int)renderRequest.getAttribute("delta");
	
	if(cur==0){
		cur=1;
	}
	if(delta==0){
		delta=5;
	}
	
%>

<portlet:renderURL var="addEmployeeVar">
	<portlet:param name="mvcPath" value="/editEmployee.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="addDepartmentVar">
	<portlet:param name="mvcPath" value="/editDepartment.jsp"/>
</portlet:renderURL>

<c:choose>
	<c:when test="<%=themeDisplay.isSignedIn() %>">
		<%
			
				boolean isAccessible=user.getRoles().stream().anyMatch((role)->{
					return role.getName().equalsIgnoreCase("Adminstart") || role.getName().equalsIgnoreCase("HR"); 
				});
				%>
					<aui:button-row>
						<aui:button href="${addEmployeeVar}" cssClass="btn-primary" value="Add Employee"/>
						<aui:button href="${addDepartmentVar}" cssClass="btn-primary" value="Add Department"/>
					</aui:button-row>
		<%if(employees!=null && !employees.isEmpty()){ %>
			<liferay-ui:search-container delta="5" deltaParam="delta" curParam="cur" var="empSearchContainer" emptyResultsMessage="">
			     <liferay-ui:search-container-results>
			     <% 
			     //Optional
			      empSearchContainer.setTotal(EmployeeLocalServiceUtil.getEmployeesCount());
			      empSearchContainer.setResults(employees);
			      %>
			 	</liferay-ui:search-container-results>
			 
				 <liferay-ui:search-container-row className="com.employee.model.Employee" modelVar="emp" keyProperty="empid" > 
				      	
				      	<liferay-ui:search-container-column-text property="empid" name="#Id" orderable="true" orderableProperty="empid"/>
				      	<liferay-ui:search-container-column-text property="ename" name="#Ename" orderable="true" orderableProperty="ename" />
				      	
				      	<liferay-ui:search-container-column-text property="deptId" name="#Dept Id" orderable="true" orderableProperty="deptId" />
				      	<liferay-ui:search-container-column-jsp align="right" path="/actions.jsp" />
				  </liferay-ui:search-container-row>
				  <liferay-ui:search-iterator markupView="lexicon" displayStyle="list"/>
			</liferay-ui:search-container>
		<%}else{ %>
			<h1>You don't have any employees.</h1>
		<%} %>
	</c:when>
	<c:otherwise>
			<h1>Please <a href="<%=themeDisplay.getURLSignIn() %>">Sign In </h1> to see the content of this page.
	</c:otherwise>
</c:choose>



