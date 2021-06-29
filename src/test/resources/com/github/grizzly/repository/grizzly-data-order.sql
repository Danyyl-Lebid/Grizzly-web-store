insert into public.orders (id, user_id, status, create_date, modify_date)
values (1, 1, 'OPEN', '2020-07-29T19:30:40','2020-07-29T19:30:40');
insert into public.orders (id, user_id, status, create_date, modify_date)
values (2, 2, 'OPEN', '2020-07-29T19:30:40','2020-07-29T19:30:40');
insert into public.orders (id, user_id, status, create_date, modify_date)
values (3, 1, 'OPEN', '2020-07-29T19:30:40','2020-07-29T19:30:40');
insert into public.orders (id, user_id, status, create_date, modify_date)
values (4, 1, 'COMPLETED', '2020-03-29T19:30:40','2020-03-29T19:30:40');

insert into PUBLIC.users (id, first_name, last_name, login, password, email, phone, created_at, updated_at, active,
                          is_verified)
values (1,
        'user1_firstName',
        'user1_lastName',
        'user1_login',
        'user1_password',
        'user1_@email.com',
        'user1_phone',
        '1970-01-01 00:00:00-00',
        null,
        'OFF',
        'NO');

insert into PUBLIC.users (id, first_name, last_name, login, password, email, phone, created_at, updated_at, active,
                          is_verified)
values (2,
        'user2_firstName',
        'user2_lastName',
        'user2_login',
        'user2_password',
        'user2_@email.com',
        'user2_phone',
        '1969-12-31 21:00:00-00',
        null,
        'OFF',
        'NO');

insert into PUBLIC.products (id, name, description, image, price, quantity, category_id)
values (1,
        'Milk',
        '2,6%',
        null,
        '11.22',
        11,
        1);

insert into PUBLIC.products (id, name, description, image, price, quantity, category_id)
values (2,
        'Bread',
        'yammi',
        null,
        '3.33',
        110,
        1);

insert into PUBLIC.products (id, name, description, image, price, quantity, category_id)
values (3,
        'Cheese',
        '40%',
        null,
        '89.7',
        13,
        1);


insert into PUBLIC.order_items (id, quantity,  price, order_id, product_id)
values (1,
        3,
        '11.22',
        1,
        1);

insert into PUBLIC.order_items (id, quantity,  price, order_id, product_id)
values (2,
        5,
        '3.33',
        1,
        2);

insert into PUBLIC.order_items (id, quantity,  price, order_id, product_id)
values (3,
        1,
        '89.7',
        1,
        3);

insert into PUBLIC.order_items (id, quantity,  price, order_id, product_id)
values (4,
        2,
        '11.22',
        2,
        1);

insert into PUBLIC.order_items (id, quantity,  price, order_id, product_id)
values (5,
        1,
        '3.33',
        2,
        2);

insert into PUBLIC.order_items (id, quantity,  price, order_id, product_id)
values (6,
        1,
        '3.33',
        3,
        2);

insert into PUBLIC.order_items (id, quantity,  price, order_id, product_id)
values (7,
        10,
        '89.7',
        3,
        3);

insert into PUBLIC.category (id, parent_id, name, description)
values (1,
        null,
        'product',
        'products');
