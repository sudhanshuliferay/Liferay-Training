create index IX_622987FF on Customsql_CustomSQLTest (field2);
create index IX_BC3BEA47 on Customsql_CustomSQLTest (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B2785689 on Customsql_CustomSQLTest (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C39C7D08 on FOO_CustomSQLTest (field2);
create index IX_924AE810 on FOO_CustomSQLTest (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_368E3292 on FOO_CustomSQLTest (uuid_[$COLUMN_LENGTH:75$], groupId);