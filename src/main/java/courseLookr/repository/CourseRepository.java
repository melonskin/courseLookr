package courseLookr.repository;

import courseLookr.pojo.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> searchCourses(String department, String number, String name);
    Course findOneById(int courseId);
}
