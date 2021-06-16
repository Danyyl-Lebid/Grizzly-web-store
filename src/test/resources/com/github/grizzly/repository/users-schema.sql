drop table if exists public.users CASCADE;

create table users
(
    id          bigint generated by default as identity,
    active      VARCHAR(16) not null,
    created_at  timestamp   not null,
    email       VARCHAR(32) not null,
    first_name  VARCHAR(32) not null,
    last_name   VARCHAR(32) not null,
    login       VARCHAR(32) not null,
    password    VARCHAR(16) not null,
    phone       VARCHAR(16) not null,
    updated_at  timestamp,
    is_verified VARCHAR(16) not null,
    primary key (id)
);