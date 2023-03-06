create index IX_C30E19E9 on LMS_LibraryStore (bookname[$COLUMN_LENGTH:75$], groupId);
create index IX_41D96A2C on LMS_LibraryStore (issueDate[$COLUMN_LENGTH:75$], groupId);
create index IX_6DFE59ED on LMS_LibraryStore (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_FD3E77AF on LMS_LibraryStore (uuid_[$COLUMN_LENGTH:75$], groupId);