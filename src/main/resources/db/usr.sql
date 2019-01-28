create table usr
(
  id        varchar(45)  not null,
  name      varchar(90)  null,
  email     varchar(90)  not null,
  gender    varchar(10)  null,
  locale    varchar(10)  null,
  userpic   varchar(255) null,
  lastvisit varchar(125) null,
  constraint usr_id_uindex
  unique (id)
);

alter table usr
  add primary key (id);
