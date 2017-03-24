# Starter Pagination

At this point, just testing (against MyBatis) the use of a simple pagination.  The class under test is just RiskMapper

Prerequisites

    Java 8 @ (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    (Mac) If using postgres, get the .app (Follow installation instructions) @ http://postgresapp.com/
    on CLI, run "createdb -h localhost -p 5432 -U postgres springbootdb"

Generic Steps:

    git clone https://github.com/samuraichan/projects
    cd projects/starterPagination
    mvn tests (23 successful tests should run)
    
Next Steps:
    1. more unit tests to be written to test DataTableOutput mechanism
    2. more unit tests to start testing postgres LIMIT and OFFSET (see how this will integrate with
       datatables API - specifically what params that will send upon pagination)
