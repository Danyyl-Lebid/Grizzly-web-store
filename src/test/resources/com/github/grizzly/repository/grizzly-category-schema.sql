drop table if exists public.category CASCADE;

create table category
(
    id          bigserial    not null
        constraint category_pkey
            primary key,
    description varchar(256) not null,
    name        varchar(32)  not null,
    parent_id   bigint
);
