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

create table areas (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_areas primary key (id))
;

create table courses (
  id                        bigint not null,
  name                      varchar(255),
  area_id                   bigint,
  constraint pk_courses primary key (id))
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

create table levels (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_levels primary key (id))
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
  course_id                 bigint,
  name                      varchar(255),
  constraint pk_themes primary key (id))
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


create table courses_tutors (
  courses_id                     bigint not null,
  tutors_id                      bigint not null,
  constraint pk_courses_tutors primary key (courses_id, tutors_id))
;

create table courses_levels (
  courses_id                     bigint not null,
  levels_id                      bigint not null,
  constraint pk_courses_levels primary key (courses_id, levels_id))
;

create table levels_courses (
  levels_id                      bigint not null,
  courses_id                     bigint not null,
  constraint pk_levels_courses primary key (levels_id, courses_id))
;

create table tutors_courses (
  tutors_id                      bigint not null,
  courses_id                     bigint not null,
  constraint pk_tutors_courses primary key (tutors_id, courses_id))
;
create sequence administrador_seq;

create sequence areas_seq;

create sequence courses_seq;

create sequence files_seq;

create sequence file_auxs_seq;

create sequence levels_seq;

create sequence reports_seq;

create sequence report_auxs_seq;

create sequence themes_seq;

create sequence tutors_seq;

alter table courses add constraint fk_courses_area_1 foreign key (area_id) references areas (id) on delete restrict on update restrict;
create index ix_courses_area_1 on courses (area_id);
alter table file_auxs add constraint fk_file_auxs_file_2 foreign key (file_id) references files (id) on delete restrict on update restrict;
create index ix_file_auxs_file_2 on file_auxs (file_id);
alter table file_auxs add constraint fk_file_auxs_report_aux_3 foreign key (report_aux_id) references report_auxs (id) on delete restrict on update restrict;
create index ix_file_auxs_report_aux_3 on file_auxs (report_aux_id);
alter table reports add constraint fk_reports_theme_4 foreign key (theme_id) references themes (id) on delete restrict on update restrict;
create index ix_reports_theme_4 on reports (theme_id);
alter table reports add constraint fk_reports_tutor_5 foreign key (tutor_id) references tutors (id) on delete restrict on update restrict;
create index ix_reports_tutor_5 on reports (tutor_id);
alter table report_auxs add constraint fk_report_auxs_report_6 foreign key (report_id) references reports (id) on delete restrict on update restrict;
create index ix_report_auxs_report_6 on report_auxs (report_id);
alter table themes add constraint fk_themes_level_7 foreign key (level_id) references levels (id) on delete restrict on update restrict;
create index ix_themes_level_7 on themes (level_id);
alter table themes add constraint fk_themes_course_8 foreign key (course_id) references courses (id) on delete restrict on update restrict;
create index ix_themes_course_8 on themes (course_id);
alter table tutors add constraint fk_tutors_admin_9 foreign key (admin_id) references administrador (id) on delete restrict on update restrict;
create index ix_tutors_admin_9 on tutors (admin_id);



alter table courses_tutors add constraint fk_courses_tutors_courses_01 foreign key (courses_id) references courses (id) on delete restrict on update restrict;

alter table courses_tutors add constraint fk_courses_tutors_tutors_02 foreign key (tutors_id) references tutors (id) on delete restrict on update restrict;

alter table courses_levels add constraint fk_courses_levels_courses_01 foreign key (courses_id) references courses (id) on delete restrict on update restrict;

alter table courses_levels add constraint fk_courses_levels_levels_02 foreign key (levels_id) references levels (id) on delete restrict on update restrict;

alter table levels_courses add constraint fk_levels_courses_levels_01 foreign key (levels_id) references levels (id) on delete restrict on update restrict;

alter table levels_courses add constraint fk_levels_courses_courses_02 foreign key (courses_id) references courses (id) on delete restrict on update restrict;

alter table tutors_courses add constraint fk_tutors_courses_tutors_01 foreign key (tutors_id) references tutors (id) on delete restrict on update restrict;

alter table tutors_courses add constraint fk_tutors_courses_courses_02 foreign key (courses_id) references courses (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists administrador;

drop table if exists areas;

drop table if exists courses;

drop table if exists courses_tutors;

drop table if exists courses_levels;

drop table if exists files;

drop table if exists file_auxs;

drop table if exists levels;

drop table if exists levels_courses;

drop table if exists reports;

drop table if exists report_auxs;

drop table if exists themes;

drop table if exists tutors;

drop table if exists tutors_courses;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists administrador_seq;

drop sequence if exists areas_seq;

drop sequence if exists courses_seq;

drop sequence if exists files_seq;

drop sequence if exists file_auxs_seq;

drop sequence if exists levels_seq;

drop sequence if exists reports_seq;

drop sequence if exists report_auxs_seq;

drop sequence if exists themes_seq;

drop sequence if exists tutors_seq;

