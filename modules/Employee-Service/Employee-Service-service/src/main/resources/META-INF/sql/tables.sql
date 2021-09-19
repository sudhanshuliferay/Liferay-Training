create table FOO_Department (
	deptId LONG not null primary key,
	deptName VARCHAR(75) null,
	userId LONG,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table FOO_Employee (
	empid LONG not null primary key,
	ename VARCHAR(50) null,
	deptId LONG,
	emailAddress VARCHAR(75) null,
	hrName VARCHAR(75) null,
	assignedTeamsId LONG,
	userId LONG,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);