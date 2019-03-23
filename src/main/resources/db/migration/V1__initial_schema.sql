CREATE SEQUENCE user_device_pk_seq START WITH 50;

create table user_device (
   id int8 not null,
   token varchar(255),
   device_type varchar(255),
   user_id int8 not null,
   is_active int4
);



 