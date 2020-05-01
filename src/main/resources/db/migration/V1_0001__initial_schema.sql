create schema if not exists products;

create table if not exists products.customer (
    id long auto_increment primary key,
    first_name varchar(250) NOT NULL,
    last_name varchar(250) NOT NULL
);

create table if not exists products.product (
    id long auto_increment primary key,
    name varchar(250) NOT NULL
);

create table if not exists products.customer_product_assignment (
    customer_id long not null,
    product_id long not null,
    constraint customer_product_assignment_unique unique (customer_id, product_id)
);