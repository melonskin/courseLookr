package courseLookr.web;

import courseLookr.pojo.Course;
import courseLookr.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private CourseRepository courseRepository;

    @Autowired
    public CourseController(
            CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String courses(Model model) {
        List<Course> courseList = courseRepository.findCourses(
                Integer.MAX_VALUE, 20);
        System.out.println(courseList.size());
        model.addAttribute("coursesList",
                courseRepository.findCourses(
                        Integer.MAX_VALUE, 20));
        return "courses";
    }
}
