<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.employee.service.DepartmentLocalServiceUtil"%>
<%@page import="com.employee.model.Department"%>
<%@ include file="init.jsp"%>

<%
	List<Department> departments=DepartmentLocalServiceUtil.getDepartments(-1, -1);
	PortletURL renderUrl =  null;
	if(departments.isEmpty()){
		renderUrl=PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		renderUrl.setWindowState(LiferayWindowState.NORMAL);
		renderUrl.setPortletMode(LiferayPortletMode.VIEW);
		renderUrl.setParameter("mvcPath", "/addDepartment.jsp");
		%>
		<h1>You Don't have any department you should first <strong><em><a href="<%=renderUrl.toString()%>">Create Department</a></em></strong>.
		<%
	}else{
%>

<portlet:actionURL name="saveEmployee" var="saveEmployeeURL" />

<portlet:resourceURL var="getTeamsUrl" id="getTeams" />

<aui:form name="saveEmployeeFrm" action="${saveEmployeeURL}" method="post">

	<aui:input name="ename" type="text" />
	<aui:input name="emailAddress" type="text" />
	<aui:input name="hrName" type="text" />
	<aui:select name="deptName" id="deptName" onChange="getTeams()">
		<aui:option value="0">--Select department name--</aui:option>
		<%for(Department department:departments) {%>
			<aui:option value="<%=department.getDeptId() %>"><%=department.getDeptName()%></aui:option>
		<%} %>
	</aui:select>
	<aui:select name="assignedTeamsId" >
		<aui:option value="10">10</aui:option>
		<aui:option value="20">20</aui:option>
		<aui:option value="30">30</aui:option>
	</aui:select>

	<aui:button type="submit"></aui:button>
</aui:form>

<%} %>

<script type="text/javascript">
function getTeams(){
    AUI().use('aui-io-request', function(A){
        A.io.request('${getTeamsUrl}', {
               method: 'post',
               data:{
            	 <portlet:namespace/>deptName : $("#deptName").val()  
               },
               on: {
                       success: function() {
                        alert(this.get('getTeams'));
                    }
              }
        });
    });
}
</script>