package courseLookr.repository;

import courseLookr.sqlQuery.QueryForPackageCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPackageCourseRepository implements PackageCourseRepository {

    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcPackageCourseRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    public void deletePackageCourseRelation(int packageId, int courseId) {
        jdbcOperations.update(QueryForPackageCourse.deletePackageCourseRelation, packageId, courseId);

    }
    public void addPackageCourseRelation(int packageId, int courseId) {
        jdbcOperations.update(QueryForPackageCourse.addPackageCourseRelation, packageId, courseId);
    }
}
