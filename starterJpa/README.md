# Starter

Just started playing with Hibernate's envers. Created a Book entity and envers hooks into 
the table BOOK_AUDIT and SYSTEM_REVISION. Both the audit table and revsion are populated 
implicitly and are required by Hibernate.

Also added H2 console

Note: simple bigint column to timestamp: select id, DATEADD('MILLISECOND', (timestamp/1000), DATE '1970-01-01') from system_revision;

Generic Steps:

  1. git clone https://github.com/samuraichan/projects && git checkout feature-starter-jpa
  2. cd projects/starterJpa
  3. mvn spring-boot:run or just do a mvn test (to run tests using Spring JPA)
  4. http://localhost:8080/starter/
  5. (also) you can view the h2 console http://localhost:8080/starter/console
