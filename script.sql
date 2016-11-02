CREATE TABLE Product (
    id serial not null constraint pk_product primary key,
    nm_product Varchar(50) not null,
    impost integer,
    product_type integer not null
);

create table impost (
    id serial not null constraint pk_impost primary key,
    nm_impost varchar(10) not null,
    vl_percentage float not null
);

create table Product_Type (
    id serial not null constraint pk_product_type primary key,
    nm_type varchar(20) not null,
    impost integer
);

ALTER TABLE product ADD CONSTRAINT fk_product_impost FOREIGN KEY (impost)
REFERENCES impost(id) MATCH FULL;

ALTER TABLE Product_Type ADD CONSTRAINT fk_product_type_impost FOREIGN KEY (impost)
REFERENCES impost(id) MATCH FULL;

ALTER TABLE product ADD CONSTRAINT fk_product_product_type FOREIGN KEY (product_type)
REFERENCES Product_Type(id) MATCH FULL;