drop table Books;
create table if not exists Books
(
    id bigint auto_increment primary key,
    title varchar(120),
    author varchar(120),
    release_date date,
    description text
);