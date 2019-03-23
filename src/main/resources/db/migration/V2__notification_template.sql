CREATE SEQUENCE notification_template_pk_seq START WITH 50;

create table notification_template (
   id int8 not null,
   code varchar(9),
   locale varchar(9),
   notification_channel varchar(9),
   subject varchar(100),
   body varchar(255),
    is_active int4
);



 
CREATE UNIQUE INDEX unique_template ON notification_template (code,locale,notification_channel); 
	 