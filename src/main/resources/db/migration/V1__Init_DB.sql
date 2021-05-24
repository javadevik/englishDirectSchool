create sequence hibernate_sequence start 1 increment 1;

create table grp (
    id int8 not null,
    name varchar(255),
    primary key (id)
);
create table user_role (
    user_id int8 not null,
    roles varchar(255)
);
create table history_edu (
    id int8 not null,
    end_level int4 not null,
    end_studying_date date,
    start_level int4,
    start_studying_date date,
    student_id int8,
    primary key (id)
);
create table person (
    id int8 not null,
    address varchar(255),
    email varchar(255),
    last_name varchar(255),
    name varchar(255),
    passport_number int8,
    phone varchar(255),
    tax_number int8,
    user_id int8,
    primary key (id)
);
create table student (
    id int8 not null,
    active boolean not null,
    level int4,
    group_id int8,
    person_id int8,
    primary key (id)
);
create table upload_files (
    id int8 not null,
    user_id int8 not null,
    level int4 not null,
    name varchar(255),
    path varchar(255),
    type varchar(255),
    upload_date date,
    primary key (id)
);
create table usr (
    id int8 not null,
    active boolean not null,
    password varchar(255),
    username varchar(255),
    primary key (id)
);

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;

alter table if exists history_edu
    add constraint history_edu_student_fk
    foreign key (student_id) references student;

alter table if exists person
    add constraint person_user_fk
    foreign key (user_id) references usr;

alter table if exists student
    add constraint student_group_fk
    foreign key (group_id) references grp;

alter table if exists student
    add constraint student_person_fk
    foreign key (person_id) references person;

alter table if exists upload_files
    add constraint upload_file_student_fk
    foreign key (user_id) references usr;



-- create table upload_files (
--     id int8 not null,
--     name varchar(255) not null,
--     path varchar(255) not null,
--     type varchar(255) not null,
--     level int4 not null,
--     primary key (id)
-- );
--
-- create table person (
--     id int8 not null,
--     address varchar(255),
--     email varchar(255),
--     last_name varchar(255),
--     name varchar(255),
--     passport_number int8,
--     phone varchar(255),
--     tax_number int8,
--     user_id int8,
--     primary key (id)
-- );
-- create table user_role (
--     user_id int8 not null,
--     roles varchar(255)
-- );
-- create table usr (
--     id int8 not null,
--     active boolean not null,
--     password varchar(255) not null,
--     username varchar(255) not null,
--     primary key (id)
-- );
--
-- create table student (
--     id int8 not null,
--     level int4,
--     active boolean not null,
--     person_id int8 not null,
--     group_id int8,
--     primary key (id)
-- );
--
-- create table history_edu (
--     id int8 not null,
--     startStudying date not null,
--     startLevel int4,
--     endStudying date,
--     endLevel int4,
--     primary key (id)
-- );
--
-- create table grp (
--     id int8 not null,
--     name varchar(255) not null,
--     primary key (id)
-- );
--
-- alter table if exists person
--     add constraint person_user_fk
--     foreign key (user_id) references usr;
--
-- alter table if exists user_role
--     add constraint user_role_user_fk
--     foreign key (user_id) references usr;
--
-- alter table if exists student
--     add constraint student_person_fk
--     foreign key (person_id) references person;
--
-- alter table if exists student
--     add constraint student_group_fk
--     foreign key (group_id) references grp;
