package courseLookr.repository;

import courseLookr.pojo.Course;
import courseLookr.pojo.Section;
import courseLookr.sqlQuery.QueryForCourse;
import courseLookr.web.CourseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowCallbackHandler;
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

    public List<Course> searchCourse(String department, String number) {
        return jdbcOperations.query(QueryForCourse.searchCourse, new CourseRowMapper(), department, number);
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
        return jdbcOperations.query(QueryForCourse.searchCoursesQuery,
                new CourseRowMapper(), queryValues[0], queryValues[1], queryValues[2]);
    }

    public Course findOneById(int courseId) {
        return jdbcOperations.queryForObject(QueryForCourse.findOneCourseByIdQuery, new CourseRowMapper(), courseId);
    }

    public List<Section> findSectionsByCourseId(int courseId) {
        return jdbcOperations.query(QueryForCourse.findSectionsByCourseIdQuery, new SectionRowMapper(), courseId);
    }

    public void updateCourseInfo(int courseId, CourseForm form) {
        jdbcOperations.update(QueryForCourse.updateCourseInfo,
                form.getName(), form.getCredit(), form.getDescription(), courseId);
    }

    public List<Course> getCoursesForPackage(int packageId) {
        return jdbcOperations.query(QueryForCourse.getCoursesForPackage, new CourseRowMapper(), packageId);
    }

    public List<Course> getCoursesForInterest(int interestId) {
        return jdbcOperations.query(QueryForCourse.getCoursesForInterest, new CourseRowMapper(), interestId);
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

    private static class SectionRowMapper implements RowMapper<Section> {
        public Section mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Section(
                    rs.getString("number"),
                    rs.getString("instructor"),
                    rs.getString("term"),
                    rs.getString("year"),
                    rs.getDouble("gpa"),
                    rs.getInt("student"),
                    rs.getDouble("a"),
                    rs.getDouble("b"),
                    rs.getDouble("c"),
                    rs.getDouble("d"),
                    rs.getDouble("f"),
                    rs.getDouble("q"),
                    rs.getInt("course_id"));
        }
    }
}
