package courseLookr.repository;

import courseLookr.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcCourseRepository implements CourseRepository {

    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcCourseRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<Course> findCourses(int maxId, int count) {
        List<Course> coursesList = jdbcOperations.query("select id, department, number, credit, description" +
        " from course" +
        " where id < ?" +
        " limit 20",
                new CourseRowMapper(), maxId);
        return coursesList;
    }

    private static class CourseRowMapper implements RowMapper<Course> {
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Course(
                    rs.getInt("id"),
                    rs.getString("department"),
                    rs.getString("number"),
                    rs.getString("credit"),
                    rs.getString("description"));
        }
    }

}
