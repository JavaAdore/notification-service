
insert into  notification_template (
   id  , code, locale, notification_channel  , subject  , body , is_active  
) values 
(
  nextval('notification_template_pk_seq') , '01' , 'en' , 'EMAIL','EMAIL activation','click on this link <token> ',1

);


insert into  notification_template (
   id  , code, locale, notification_channel  , subject  , body , is_active  
) values  
(
  nextval('notification_template_pk_seq') , '01' , 'en' , 'SMS',null,'click on this link <token> ',1
);



insert into  notification_template (
   id  , code, locale, notification_channel  , subject  , body , is_active  
) values 
(
  nextval('notification_template_pk_seq') , '02' , 'en' , 'EMAIL','forget password','click on this link <token> ',1

);


insert into  notification_template (
   id  , code, locale, notification_channel  , subject  , body , is_active  
) values 
(
  nextval('notification_template_pk_seq') , '02' , 'en' , 'SMS',null,'forget password EMAIL<token> ',1
);

 



 

	 