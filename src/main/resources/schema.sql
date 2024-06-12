drop table LISTS if exists;
drop table TASKS if exists;

create table LISTS (LIST_ID varchar(36), NAME varchar(256) not null, unique(LIST_ID));
create table TASKS (ID varchar(36), NAME varchar(256) not null, DESCRIPTION varchar(1024), LIST_ID varchar(36), unique(ID));
       
alter table TASKS add constraint FK_LIST_TASK foreign key (LIST_ID) references LISTS(LIST_ID) on delete cascade;


