create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
create sequence revinfo_seq start with 1 increment by 50;
create table course (id serial not null, name varchar(255), primary key (id));
create table course_aud (id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table revinfo (rev integer not null, revtstmp bigint, primary key (rev));
create table student (birth_date date, central_identification integer not null, id serial not null, semester integer not null, used_free_semesters integer not null, name varchar(255), primary key (id));
create table student_aud (birth_date date, central_identification integer, id integer not null, rev integer not null, revtype smallint, semester integer, used_free_semesters integer, name varchar(255), primary key (id, rev));
create table student_courses_to_learn_aud (courses_to_learn_id integer not null, rev integer not null, revtype smallint, students_id integer not null, primary key (courses_to_learn_id, rev, students_id));
create table student_courses_to_learn (courses_to_learn_id integer not null, students_id integer not null, primary key (courses_to_learn_id, students_id));
create table teacher (birthdate date, id serial not null, name varchar(255), primary key (id));
create table teacher_aud (birthdate date, id integer not null, rev integer not null, revtype smallint, name varchar(255), primary key (id, rev));
create table teacher_courses_to_teach_aud (courses_to_teach_id integer not null, rev integer not null, revtype smallint, teachers_id integer not null, primary key (courses_to_teach_id, rev, teachers_id));
create table teacher_courses_to_teach (courses_to_teach_id integer not null, teachers_id integer not null, primary key (courses_to_teach_id, teachers_id));
alter table if exists course_aud add constraint FK7wota7b9g9bu9by751v8r8j65 foreign key (rev) references revinfo;
alter table if exists student_aud add constraint FKj009xm0wjydklskl2dgnfyyjq foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn_aud add constraint FKd1bvlrmk1w0ueb6hsigdtgeqm foreign key (rev) references revinfo;
alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_aud add constraint FKsg6tnk689ja9qg8qhnyarygx5 foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach_aud add constraint FK2kejtyvx7lmc3tcxrv4jkcnvm foreign key (rev) references revinfo;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
