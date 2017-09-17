package courseLookr.repository;

import courseLookr.pojo.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findCourses(int maxId, int count);
}
