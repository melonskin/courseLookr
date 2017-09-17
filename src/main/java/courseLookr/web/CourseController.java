package courseLookr.web;

import courseLookr.pojo.Course;
import courseLookr.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value="/{courseId}", method=RequestMethod.GET)
    public String course(
            @PathVariable("courseId") int courseId,
            Model model) {
        model.addAttribute("course", courseRepository.findOneById(courseId));
        return "course";
    }
}
