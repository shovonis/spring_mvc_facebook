Simple Spring 4 CRUD Application 
==================================

Technology Used: 
----------------
- Spring MVC 4 
- SiteMesh 
- Hibernate 4.3
- JPA 
- EhCache
- LogBack

HOW TO RUN : 
-------------
- git clone https://github.com/shovonis/spring_mvc_facebook.git
- Download  Tomcat 7 From http://tomcat.apache.org/download-70.cgi
- unzip  Tomcat. 
- Import as maven project from Eclipse/IntellijIdea
- Show the tomcat home directory.
- Create a database name  'mvc_facebook' in your localhost
- JNDI DataSource Setup: 
    - Add this line inside <context> </context> in tomcat/conf/context.xml
    
     ```xml
      
      <ResourceLink name="jdbc/facebook"
                      global="jdbc/MyFB"
                      auth="Container"
                      type="javax.sql.DataSource" />
                      
      ```               
    - Add the following line inside <GlobalNamingResources> </GlobalNamingResources> in tomcat/conf/server.xml
     ```xml
      
      <Resource name="jdbc/MyFB"
          global="jdbc/MyFB"
          auth="Container"
          type="javax.sql.DataSource"
          driverClassName="com.mysql.jdbc.Driver"
          url="jdbc:mysql://localhost:3306/mvc_facebook"
          username="root"
          password="therap"
          maxActive="100"
          maxIdle="20"
          minIdle="5"
          maxWait="10000"/>
          
     ```  
                       
- Build with Maven 
- Deploy

