create table if not exists Books
(
    id bigint auto_increment primary key,
    title varchar(120),
    author varchar(120),
    release_date date,
    description text
);

create table if not exists Orders
(
    id bigint auto_increment primary key,
    name varchar(30),
    surname varchar(30),
    telephone varchar(12),
    email varchar(30),
    street varchar(30),
    city varchar(30),
    postal_code varchar(6)
);

create table if not exists Order_Books
(
    order_id bigint references Orders(id),
    book_id bigint references Books(id)
);