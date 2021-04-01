create sequence hibernate_sequence start 1 increment 1;

create table upload_files (
    id int8 not null,
    name varchar(255) not null,
    path varchar(255) not null,
    type varchar(255) not null,
    level int4 not null,
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
create table user_role (
    user_id int8 not null,
    roles varchar(255)
);
create table usr (
    id int8 not null,
    active boolean not null,
    password varchar(255) not null,
    username varchar(255) not null,
    level int4,
    primary key (id)
);

create table student (
    id int8 not null,
    level int4,
    user_id int8 not null,
    primary key (id)
);

alter table if exists person
    add constraint person_user_fk
    foreign key (user_id) references usr;

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;

alter table if exists student
    add constraint student_user_fk
    foreign key (user_id) references usr;