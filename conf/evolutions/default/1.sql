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

create table course (
  id                        bigint not null,
  name                      varchar(255),
  area_id                   bigint,
  constraint pk_course primary key (id))
;

create table files (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_files primary key (id))
;

create table file_auxs (
  id                        bigint not null,
  file_id                   bigint,
  report_aux_id             bigint,
  constraint pk_file_auxs primary key (id))
;

create table level (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_level primary key (id))
;

create table reports (
  id                        bigint not null,
  theme_id                  bigint,
  tutor_id                  bigint,
  date_registry             timestamp,
  date_submit               timestamp,
  var_submit                boolean,
  constraint pk_reports primary key (id))
;

create table report_auxs (
  id                        bigint not null,
  report_id                 bigint,
  constraint pk_report_auxs primary key (id))
;

create table themes (
  id                        bigint not null,
  level_id                  bigint,
  name                      varchar(255),
  constraint pk_themes primary key (id))
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

create table course_level (
  course_id                      bigint not null,
  level_id                       bigint not null,
  constraint pk_course_level primary key (course_id, level_id))
;

create table level_course (
  level_id                       bigint not null,
  course_id                      bigint not null,
  constraint pk_level_course primary key (level_id, course_id))
;

create table tutor_course (
  tutor_id                       bigint not null,
  course_id                      bigint not null,
  constraint pk_tutor_course primary key (tutor_id, course_id))
;
create sequence administrador_seq;

create sequence area_seq;

create sequence course_seq;

create sequence files_seq;

create sequence file_auxs_seq;

create sequence level_seq;

create sequence reports_seq;

create sequence report_auxs_seq;

create sequence themes_seq;

create sequence tutor_seq;

alter table course add constraint fk_course_area_1 foreign key (area_id) references area (id) on delete restrict on update restrict;
create index ix_course_area_1 on course (area_id);
alter table file_auxs add constraint fk_file_auxs_file_2 foreign key (file_id) references files (id) on delete restrict on update restrict;
create index ix_file_auxs_file_2 on file_auxs (file_id);
alter table file_auxs add constraint fk_file_auxs_report_aux_3 foreign key (report_aux_id) references report_auxs (id) on delete restrict on update restrict;
create index ix_file_auxs_report_aux_3 on file_auxs (report_aux_id);
alter table reports add constraint fk_reports_theme_4 foreign key (theme_id) references themes (id) on delete restrict on update restrict;
create index ix_reports_theme_4 on reports (theme_id);
alter table reports add constraint fk_reports_tutor_5 foreign key (tutor_id) references tutor (id) on delete restrict on update restrict;
create index ix_reports_tutor_5 on reports (tutor_id);
alter table report_auxs add constraint fk_report_auxs_report_6 foreign key (report_id) references reports (id) on delete restrict on update restrict;
create index ix_report_auxs_report_6 on report_auxs (report_id);
alter table themes add constraint fk_themes_level_7 foreign key (level_id) references level (id) on delete restrict on update restrict;
create index ix_themes_level_7 on themes (level_id);
alter table tutor add constraint fk_tutor_admin_8 foreign key (admin_id) references administrador (id) on delete restrict on update restrict;
create index ix_tutor_admin_8 on tutor (admin_id);



alter table course_tutor add constraint fk_course_tutor_course_01 foreign key (course_id) references course (id) on delete restrict on update restrict;

alter table course_tutor add constraint fk_course_tutor_tutor_02 foreign key (tutor_id) references tutor (id) on delete restrict on update restrict;

alter table course_level add constraint fk_course_level_course_01 foreign key (course_id) references course (id) on delete restrict on update restrict;

alter table course_level add constraint fk_course_level_level_02 foreign key (level_id) references level (id) on delete restrict on update restrict;

alter table level_course add constraint fk_level_course_level_01 foreign key (level_id) references level (id) on delete restrict on update restrict;

alter table level_course add constraint fk_level_course_course_02 foreign key (course_id) references course (id) on delete restrict on update restrict;

alter table tutor_course add constraint fk_tutor_course_tutor_01 foreign key (tutor_id) references tutor (id) on delete restrict on update restrict;

alter table tutor_course add constraint fk_tutor_course_course_02 foreign key (course_id) references course (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists administrador;

drop table if exists area;

drop table if exists course;

drop table if exists course_tutor;

drop table if exists course_level;

drop table if exists files;

drop table if exists file_auxs;

drop table if exists level;

drop table if exists level_course;

drop table if exists reports;

drop table if exists report_auxs;

drop table if exists themes;

drop table if exists tutor;

drop table if exists tutor_course;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists administrador_seq;

drop sequence if exists area_seq;

drop sequence if exists course_seq;

drop sequence if exists files_seq;

drop sequence if exists file_auxs_seq;

drop sequence if exists level_seq;

drop sequence if exists reports_seq;

drop sequence if exists report_auxs_seq;

drop sequence if exists themes_seq;

drop sequence if exists tutor_seq;

