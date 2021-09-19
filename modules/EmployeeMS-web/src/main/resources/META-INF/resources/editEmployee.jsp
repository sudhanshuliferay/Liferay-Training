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
		long empId=ParamUtil.getLong(request, "empId",0);
		Employee employee=null;
		if(empId>0){
			employee=EmployeeLocalServiceUtil.fetchEmployee(empId);
		}
%>

<portlet:actionURL name="saveEmployee" var="saveEmployeeURL" />

<portlet:resourceURL var="getTeamsUrl" id="getTeams" />

<aui:form name="saveEmployeeFrm" action="${saveEmployeeURL}" method="post">
	<aui:input name="empId" type="hidden" value="<%=String.valueOf(empId) %>"/>
	<aui:input name="ename" type="text" value="<%=WebEMSUtil.getValue(employee, "ename") %>"/>
	<aui:input name="emailAddress" type="text" value="<%=WebEMSUtil.getValue(employee, "emailAddress") %>"/>
	<aui:input name="hrName" type="text" value="<%=WebEMSUtil.getValue(employee, "hrName") %>"/>
	<aui:select name="deptName" id="deptName" onChange="getTeams()">
		<aui:option value="0">--Select department name--</aui:option>
		<%for(Department department:departments) {
			String empDeptId=WebEMSUtil.getValue(employee, "deptName");
			boolean isSelected=empDeptId.equalsIgnoreCase(StringPool.BLANK)?false:Long.valueOf(empDeptId)==department.getDeptId();
			if(isSelected){
		%>
			<aui:option value="<%=String.valueOf(department.getDeptId()) %>" selected="true">
			<%=department.getDeptName()%></aui:option>
		<%}else{
			%>
			<aui:option value="<%=String.valueOf(department.getDeptId()) %>" >
			<%=department.getDeptName()%></aui:option>
			<%
			}
		} %>
	</aui:select>
	<aui:select name="assignedTeamsId" id="assignedTeamsId" >
		<aui:option value="10">10</aui:option>
		<aui:option value="20">20</aui:option>
		<aui:option value="30">30</aui:option>
	</aui:select>

	<aui:button type="submit"></aui:button>
</aui:form>

<%} %>

<!-- <script type="text/javascript">
function getTeams(){
    AUI().use('aui-io-request', function(A){
        A.io.request('${getTeamsUrl}', {
               method: 'post',
               dataType:'json',
               data: {
                   <portlet:namespace />deptId: A.one("#<portlet:namespace/>deptName").val()
               },
               on: {
                       success: function(data) {
                    	   debugger;
                        alert(this.get('responseData'));
                    }
              }
        });
    });
}
</script> -->