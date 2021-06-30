drop table if exists public.review CASCADE;


create table review
(
    id           bigserial not null
        constraint review_pkey
            primary key,
    created_date timestamp not null,
    user_id      bigint    not null,
    product_id   bigint    not null,
    rate         integer   not null,
    review       varchar(256),
    products     bigint
);
