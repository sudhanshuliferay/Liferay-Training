create table CSQL_Training (
	uuid_ VARCHAR(75) null,
	trainingId LONG not null primary key,
	userId LONG,
	companyId LONG,
	groupId LONG,
	trainingName VARCHAR(75) null
);