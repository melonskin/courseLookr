package courseLookr.repository;

import courseLookr.pojo.Course;
import courseLookr.pojo.Section;
import courseLookr.web.CourseForm;

import java.util.List;

public interface CourseRepository {
    List<Course> searchCourses(String department, String number, String name);
    Course findOneById(int courseId);
    List<Section> findSectionsByCourseId(int courseId);
    void updateCourseInfo(int courseId, CourseForm form);
}
