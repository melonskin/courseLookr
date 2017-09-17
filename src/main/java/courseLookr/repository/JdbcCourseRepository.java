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

    public List<Course> searchCourses(String department, String number, String name) {
        String[] queryValues = new String[3];
        if (department == null || department.equals("")) {
            queryValues[0] = "%";
        } else {
            queryValues[0] = department.trim().toUpperCase();
        }
        if (number == null || number.equals("")) {
            queryValues[1] = "%";
        } else {
            queryValues[1] = number.trim();
        }
        if (name == null || name.equals("")) {
            queryValues[2] = "%";
        } else {
            queryValues[2] = "%" + name.trim().toLowerCase() + "%";
        }
        List<Course> coursesList = jdbcOperations.query("select id, department, number, name, credit, description"
                + " from course"
                + " where department like ? and number like ? and name like ?",
                new CourseRowMapper(), queryValues[0], queryValues[1], queryValues[2]);
        return coursesList;
    }

    public Course findOneById(int courseId) {
        return jdbcOperations.queryForObject("select * from course where id = ?", new CourseRowMapper(), courseId);
    }

    private static class CourseRowMapper implements RowMapper<Course> {
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Course(
                    rs.getInt("id"),
                    rs.getString("department"),
                    rs.getString("number"),
                    rs.getString("name"),
                    rs.getString("credit"),
                    rs.getString("description"));
        }
    }
}
