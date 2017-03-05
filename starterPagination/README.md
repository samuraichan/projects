# Starter Pagination

At this point, just testing (against MyBatis) the use of a simple pagination.  The class under test is just
RiskMapper::findAllBySearchFilter(SearchFilter ...)

Prerequisites

    Java 8 @ (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    (Mac) If using postgres, get the .app (Follow installation instructions) @ http://postgresapp.com/
    on CLI, run "createdb -h localhost -p 5432 -U postgres springbootdb"

Generic Steps:

    git clone https://github.com/samuraichan/projects
    cd projects/starterPagination
    mvn tests (7 successful tests should run)
    
Next Steps:
    1. more unit tests to be written to test filtering mechanism
    2. use JPA instead of MyBatis(??)
