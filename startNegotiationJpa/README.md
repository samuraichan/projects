# Starter

- H2 console enabled
- Hibernate envers enabled
- Risk / Submissions enabled
- Envers is configured to run Mirror tables and to track super classes of entities while tracking
  @version (optimistic locking property)

Next Steps:
- Start understanding the revision numbers associated with a unit or work
- Look at https://docs.jboss.org/hibernate/orm/3.6/reference/en-US/html/transactions.html (13.1.1)
- https://visola.github.io/2012/11/12/dao-repository-and-service-digging-deeper/
- does @Transaction really take care of the concept of a Business tier transaction (unit of work)?
- try to incorporate writing to an Event table that issues the "start" of the unit of work, upon the completion of the unit or work, the event is then updated with a complete status
- the event should have an "owner" of the event, the owner can then be tracked with revision to see its complete history (what events were done on that owner during x through y, etc)


Generic Steps:

  1. git clone https://github.com/samuraichan/projects
  2. cd projects/startNegotiationJpa
  3. mvn spring-boot:run or just do a mvn test (to run tests using Spring JPA)
  4. http://localhost:8080/starter/
