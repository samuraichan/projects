# Starter

Just started doing hierarchy class saving between a Risk / Submission.  

Note: running unit tests can't get the session transaction to work with Hibernate since by default uses lazy loading (ie, risk.getSubmissions). Running the full app Spring seems to enable OpenSessionInViewFilter.java which takes care of this issue.

Next stage will be to understand how Hibernate envers works when saving a risk that only has its properties modified while submissions are left alone, etc.  Thus, need to add audit capability to Risk_Header and Risk_Body

Generic Steps:

  1. git clone https://github.com/samuraichan/projects && git checkout feature-starter-jpa
  2. cd projects/starterJpa
  3. mvn spring-boot:run or just do a mvn test (to run tests using Spring JPA)
  4. http://localhost:8080/starter/
  5. (also) you can view the h2 console http://localhost:8080/starter/console
