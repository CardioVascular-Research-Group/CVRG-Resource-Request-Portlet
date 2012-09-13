create table JHU_resource_request_ResourceRequest (
	requestId LONG not null primary key,
	requesterId LONG,
	approverId LONG,
	approved BOOLEAN,
	declined BOOLEAN,
	studyId LONG,
	message VARCHAR(75) null,
	dateSent DATE null,
	dateHandled VARCHAR(250) null,
	groupId LONG,
	companyId LONG
);

create table JHU_resource_request_Transaction (
	transactionId LONG not null primary key,
	date_ DATE null,
	memberId LONG,
	action VARCHAR(75) null,
	studyId LONG,
	approverId LONG,
	comment_ VARCHAR(250) null,
	ip VARCHAR(75) null
);