create table LMS_LibraryStore (
	lmsID LONG not null primary key,
	bookname VARCHAR(75) null,
	issueDate VARCHAR(75) null,
	uploadedBy VARCHAR(75) null,
	issueTo VARCHAR(75) null,
	groupId LONG,
	comapnyId LONG,
	userId LONG
);