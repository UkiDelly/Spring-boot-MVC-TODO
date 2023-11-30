create table if not exists todo
(
    id          int primary key,
    username    varchar(50)  not null,
    description varchar(200) not null,
    target_date date,
    is_done     boolean
);

insert into todo
    (id, username, description, target_date, is_done)
values (10001, 'admin', 'Learn JPA', CURRENT_DATE(), false),
       (10002, 'admin', 'Learn Data JPA', CURRENT_DATE(), false),
       (10003, 'admin', 'Learn Microservices', CURRENT_DATE(), false)