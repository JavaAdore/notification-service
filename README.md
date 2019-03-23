# notification-service
centralized service used by other micro services to populate messages notification using predefined templates with various locale in database and push them to the right rabbidMQ exchange, through this service either user can register his mobile devices to get push notifications on</br>
Mostly used by 
<a href="https://github.com/JavaAdore/authorization-server"> authorization server </a> for verification and rest password, etc .. <br/>

# prerequisites
config server should be up and run<br/>
<a href="https://github.com/JavaAdore/config-server">https://github.com/JavaAdore/config-server</a> <br/>
eureka server should be up and run<br/>
<a href="https://github.com/JavaAdore/eureka-server">https://github.com/JavaAdore/eureka-server</a> <br/>
 

zipkin server nice be up and run<br/>
<a href="https://github.com/JavaAdore/zipkin-server">https://github.com/JavaAdore/zipkin-server</a> <br/>

Postgres DB <br/>
RabbitMQ <br/>
Ensure rabbitMQ has exchange called "notification.exchange" <br/>
Ensure exchange "notification.exchange" has valid routing for messages with routing key "email" and "sms" ;<br/>
 


 

environment variables should be added

# ZIPKIN_SERVER_IP = 127.0.0.1
127.0.0.1 the ip of machine where zipkin server runs
# SLEUTH_LOGGING_LEVEL=info
level of sleuth loggin

# RABBITMQ_LISTENER_IP = 127.0.0.1
# RABBITMQ_LISTENER_PORT = 5672
# RABBITMQ_DEFAULT_USER = user
change user to username of rabbitmq
# RABBITMQ_DEFAULT_PASS = password
change password to username of rabbitmq


# POSTGRES_SERVER_IP    = 127.0.0.1
# POSTGRES_SERVER_PORT  = 5432
# POSTGRES_DBNAME 	    = postgres     
 
 
# AUTHORIZATION_SERVER_IP=127.0.0.1
# AUTHORIZATION_SERVER_PORT=8888

# EUREKA_SERVER_IP      = 127.0.0.1
# EUREKA_SERVER_PORT    = 8761




# notification-service provides the following functionalities

void populateAndSendNotification(NotificationModel verificationStatusModel) throws ServiceException;


# build
as root/Administration <br/>
mvn clean install docker:removeImage docker:build
# run
java -jar target/user-server.jar
