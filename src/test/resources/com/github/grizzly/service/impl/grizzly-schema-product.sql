drop table if exists public.products CASCADE;

create table products
(
    id bigint generated by default as identity,
    description VARCHAR(256),
    image varchar(255),
    name VARCHAR(64),
    price decimal(19,2),
    quantity integer,
    category_id bigint,
    state VARCHAR(32),
    primary key (id)
);

drop table if exists public.category CASCADE;

create table category
(
    id          bigint generated by default as identity,
    description VARCHAR(256) not null,
    name        VARCHAR(32)  not null,
    parent_id   bigint,
    primary key (id)
);