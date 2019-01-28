create table commands
(
  id     int auto_increment,
  target varchar(45)         not null,
  type   varchar(5)          not null,
  status tinyint default '0' not null,
  constraint commands_id_uindex
  unique (id)
);

alter table commands
  add primary key (id);
