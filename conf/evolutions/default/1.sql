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

create table area (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_area primary key (id))
;

create table courses (
  id                        bigint not null,
  name                      varchar(255),
  area_id                   bigint,
  tutor_id                  bigint,
  constraint pk_courses primary key (id))
;

create table course_aux (
  id                        bigint not null,
  course_id                 bigint,
  theme_id                  bigint,
  level_aux_id              bigint,
  constraint uq_course_aux_level_aux_id unique (level_aux_id),
  constraint pk_course_aux primary key (id))
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

create table level_aux (
  id                        bigint not null,
  level_id                  bigint,
  constraint pk_level_aux primary key (id))
;

create table report (
  id                        bigint not null,
  theme_id                  bigint,
  tutor_id                  bigint,
  date_registry             timestamp,
  date_submit               timestamp,
  var_submit                boolean,
  constraint uq_report_theme_id unique (theme_id),
  constraint pk_report primary key (id))
;

create table report_aux (
  id                        bigint not null,
  report_id                 bigint,
  constraint pk_report_aux primary key (id))
;

create table theme (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_theme primary key (id))
;

create table tutors (
  id                        bigint not null,
  user_tutor                varchar(255),
  admin_id                  bigint,
  password                  varchar(255),
  name                      varchar(255),
  last_name                 varchar(255),
  phone                     varchar(255),
  email                     varchar(255),
  constraint pk_tutors primary key (id))
;

create sequence administrador_seq;

create sequence area_seq;

create sequence courses_seq;

create sequence course_aux_seq;

create sequence file_seq;

create sequence file_aux_seq;

create sequence level_seq;

create sequence level_aux_seq;

create sequence report_seq;

create sequence report_aux_seq;

create sequence theme_seq;

create sequence tutors_seq;

alter table courses add constraint fk_courses_area_1 foreign key (area_id) references area (id) on delete restrict on update restrict;
create index ix_courses_area_1 on courses (area_id);
alter table courses add constraint fk_courses_tutor_2 foreign key (tutor_id) references tutors (id) on delete restrict on update restrict;
create index ix_courses_tutor_2 on courses (tutor_id);
alter table course_aux add constraint fk_course_aux_course_3 foreign key (course_id) references courses (id) on delete restrict on update restrict;
create index ix_course_aux_course_3 on course_aux (course_id);
alter table course_aux add constraint fk_course_aux_theme_4 foreign key (theme_id) references theme (id) on delete restrict on update restrict;
create index ix_course_aux_theme_4 on course_aux (theme_id);
alter table course_aux add constraint fk_course_aux_level_aux_5 foreign key (level_aux_id) references level_aux (id) on delete restrict on update restrict;
create index ix_course_aux_level_aux_5 on course_aux (level_aux_id);
alter table file_aux add constraint fk_file_aux_file_6 foreign key (file_id) references file (id) on delete restrict on update restrict;
create index ix_file_aux_file_6 on file_aux (file_id);
alter table file_aux add constraint fk_file_aux_report_aux_7 foreign key (report_aux_id) references report_aux (id) on delete restrict on update restrict;
create index ix_file_aux_report_aux_7 on file_aux (report_aux_id);
alter table level_aux add constraint fk_level_aux_level_8 foreign key (level_id) references level (id) on delete restrict on update restrict;
create index ix_level_aux_level_8 on level_aux (level_id);
alter table report add constraint fk_report_theme_9 foreign key (theme_id) references theme (id) on delete restrict on update restrict;
create index ix_report_theme_9 on report (theme_id);
alter table report add constraint fk_report_tutor_10 foreign key (tutor_id) references tutors (id) on delete restrict on update restrict;
create index ix_report_tutor_10 on report (tutor_id);
alter table report_aux add constraint fk_report_aux_report_11 foreign key (report_id) references report (id) on delete restrict on update restrict;
create index ix_report_aux_report_11 on report_aux (report_id);
alter table tutors add constraint fk_tutors_admin_12 foreign key (admin_id) references administrador (id) on delete restrict on update restrict;
create index ix_tutors_admin_12 on tutors (admin_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists administrador;

drop table if exists area;

drop table if exists courses;

drop table if exists course_aux;

drop table if exists file;

drop table if exists file_aux;

drop table if exists level;

drop table if exists level_aux;

drop table if exists report;

drop table if exists report_aux;

drop table if exists theme;

drop table if exists tutors;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists administrador_seq;

drop sequence if exists area_seq;

drop sequence if exists courses_seq;

drop sequence if exists course_aux_seq;

drop sequence if exists file_seq;

drop sequence if exists file_aux_seq;

drop sequence if exists level_seq;

drop sequence if exists level_aux_seq;

drop sequence if exists report_seq;

drop sequence if exists report_aux_seq;

drop sequence if exists theme_seq;

drop sequence if exists tutors_seq;

