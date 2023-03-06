create table LMS_LibraryStore (
	uuid_ VARCHAR(75) null,
	lmsID LONG not null primary key,
	bookname VARCHAR(75) null,
	issueDate VARCHAR(75) null,
	uploadedBy VARCHAR(75) null,
	issueTo VARCHAR(75) null,
	authorName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	createdDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);