create index IX_8304324B on IntegrationInfo (className[$COLUMN_LENGTH:75$]);
create unique index IX_9E6557F1 on IntegrationInfo (groupId, className[$COLUMN_LENGTH:75$]);
create index IX_D1C45A82 on IntegrationInfo (resourceBlockId);