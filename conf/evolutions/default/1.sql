# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table administrador (
  id                        bigint not null,
  user_admin                varchar(255),
  password                  varchar(255),
  name                      varchar(255),
  last_name                 varchar(255),
  phone                     varchar(255),
  email                     varchar(255),
  constraint pk_administrador primary key (id))
;

create table area_course (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_area_course primary key (id))
;

create table course (
  id                        bigint not null,
  name                      varchar(255),
  area_id                   bigint,
  constraint pk_course primary key (id))
;

create table file (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_file primary key (id))
;

create table file_aux (
  id                        bigint not null,
  file_id                   bigint,
  report_aux_id             bigint,
  constraint pk_file_aux primary key (id))
;

create table level (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_level primary key (id))
;

create table report (
  id                        bigint not null,
  theme_id                  bigint,
  tutor_id                  bigint,
  date_registry             timestamp,
  date_submit               timestamp,
  var_submit                boolean,
  constraint pk_report primary key (id))
;

create table report_aux (
  id                        bigint not null,
  report_id                 bigint,
  constraint pk_report_aux primary key (id))
;

create table theme (
  id                        bigint not null,
  course_id                 bigint,
  level_id                  bigint,
  name                      varchar(255),
  constraint pk_theme primary key (id))
;

create table tutor (
  id                        bigint not null,
  user_tutor                varchar(255),
  admin_id                  bigint,
  password                  varchar(255),
  name                      varchar(255),
  last_name                 varchar(255),
  phone                     varchar(255),
  email                     varchar(255),
  constraint pk_tutor primary key (id))
;


create table course_tutor (
  course_id                      bigint not null,
  tutor_id                       bigint not null,
  constraint pk_course_tutor primary key (course_id, tutor_id))
;

create table tutor_course (
  tutor_id                       bigint not null,
  course_id                      bigint not null,
  constraint pk_tutor_course primary key (tutor_id, course_id))
;
create sequence administrador_seq;

create sequence area_course_seq;

create sequence course_seq;

create sequence file_seq;

create sequence file_aux_seq;

create sequence level_seq;

create sequence report_seq;

create sequence report_aux_seq;

create sequence theme_seq;

create sequence tutor_seq;

alter table course add constraint fk_course_area_1 foreign key (area_id) references area_course (id) on delete restrict on update restrict;
create index ix_course_area_1 on course (area_id);
alter table file_aux add constraint fk_file_aux_file_2 foreign key (file_id) references file (id) on delete restrict on update restrict;
create index ix_file_aux_file_2 on file_aux (file_id);
alter table file_aux add constraint fk_file_aux_report_aux_3 foreign key (report_aux_id) references report_aux (id) on delete restrict on update restrict;
create index ix_file_aux_report_aux_3 on file_aux (report_aux_id);
alter table report add constraint fk_report_theme_4 foreign key (theme_id) references theme (id) on delete restrict on update restrict;
create index ix_report_theme_4 on report (theme_id);
alter table report add constraint fk_report_tutor_5 foreign key (tutor_id) references tutor (id) on delete restrict on update restrict;
create index ix_report_tutor_5 on report (tutor_id);
alter table report_aux add constraint fk_report_aux_report_6 foreign key (report_id) references report (id) on delete restrict on update restrict;
create index ix_report_aux_report_6 on report_aux (report_id);
alter table theme add constraint fk_theme_course_7 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_theme_course_7 on theme (course_id);
alter table theme add constraint fk_theme_level_8 foreign key (level_id) references level (id) on delete restrict on update restrict;
create index ix_theme_level_8 on theme (level_id);
alter table tutor add constraint fk_tutor_admin_9 foreign key (admin_id) references administrador (id) on delete restrict on update restrict;
create index ix_tutor_admin_9 on tutor (admin_id);



alter table course_tutor add constraint fk_course_tutor_course_01 foreign key (course_id) references course (id) on delete restrict on update restrict;

alter table course_tutor add constraint fk_course_tutor_tutor_02 foreign key (tutor_id) references tutor (id) on delete restrict on update restrict;

alter table tutor_course add constraint fk_tutor_course_tutor_01 foreign key (tutor_id) references tutor (id) on delete restrict on update restrict;

alter table tutor_course add constraint fk_tutor_course_course_02 foreign key (course_id) references course (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists administrador;

drop table if exists area_course;

drop table if exists course;

drop table if exists course_tutor;

drop table if exists file;

drop table if exists file_aux;

drop table if exists level;

drop table if exists report;

drop table if exists report_aux;

drop table if exists theme;

drop table if exists tutor;

drop table if exists tutor_course;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists administrador_seq;

drop sequence if exists area_course_seq;

drop sequence if exists course_seq;

drop sequence if exists file_seq;

drop sequence if exists file_aux_seq;

drop sequence if exists level_seq;

drop sequence if exists report_seq;

drop sequence if exists report_aux_seq;

drop sequence if exists theme_seq;

drop sequence if exists tutor_seq;

