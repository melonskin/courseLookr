package courseLookr.repository;

import courseLookr.sqlQuery.QueryForInterestCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcInterestCourseRepository implements InterestCourseRepository{

    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcInterestCourseRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public void deleteInterestCourseRelation(int interestId, int courseId) {
        jdbcOperations.update(QueryForInterestCourse.deleteInterestCourseRelation, interestId, courseId);
    }
    public void addInterestCourseRelation(int interestId, int courseId) {
        jdbcOperations.update(QueryForInterestCourse.addInterestCourseRelation, interestId, courseId);
    }
}
