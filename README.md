# Description
This project integrate Spring Boot/JDBC/AOP/Security, so if your doesn't want to connect to 
DataBase and disable authentication. You should set the below configuration in the Controller:
``` java
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
``` 
