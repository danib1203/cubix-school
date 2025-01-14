create table course
(
    id   integer not null,
    name varchar(255),
    primary key (id)
);

create table student_courses_to_learn
(
    courses_to_learn_id integer not null,
    students_id         integer not null,
    primary key (courses_to_learn_id, students_id)
);
create table teacher_courses_to_teach
(
    courses_to_teach_id integer not null,
    teachers_id         integer not null,
    primary key (courses_to_teach_id, teachers_id)
);

alter table if exists student_courses_to_learn add constraint FK4gnibtgipw8151a3752r320u7 foreign key (courses_to_learn_id) references course;
alter table if exists student_courses_to_learn add constraint FKfse6onh49qcak29s1ukbiwseb foreign key (students_id) references student;
alter table if exists teacher_courses_to_teach add constraint FK7ajjmjjprk0v3e7uygs8h44cu foreign key (courses_to_teach_id) references course;
alter table if exists teacher_courses_to_teach add constraint FK2i6t0r85gqnjlm9cmgjvi3111 foreign key (teachers_id) references teacher;
