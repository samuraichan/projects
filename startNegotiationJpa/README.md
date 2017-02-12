# Starter Negotiation Jpa

Took the original negotiation JPA branch and added RDBMS postgres 

Prerequisites

    Java 8 @ (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    (Mac) If using postgres, get the .app (Follow installation instructions) @ http://postgresapp.com/
    on CLI, run "createdb -h localhost -p 5432 -U postgres springbootdb"

Generic Steps:

    git clone https://github.com/samuraichan/projects
    cd projects/startNegotiationJpa
    mvn spring-boot:run
    http://localhost:8080/starter/
    
Next Steps:
	Deploy against Heroku and verify postgres add on operates correctly
