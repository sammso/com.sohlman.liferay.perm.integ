create table IntegrationInfo (
	integrationInfoId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	resourceBlockId LONG,
	className VARCHAR(75) null
);