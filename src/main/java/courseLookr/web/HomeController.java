package courseLookr.web;

import courseLookr.pojo.Course;
import courseLookr.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    private CourseRepository courseRepository;

    @Autowired
    public HomeController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @RequestMapping(method = GET)
    public String home() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String searchCourses(CourseForm form, Model model) throws Exception {
        model.addAttribute("coursesList",
                courseRepository.searchCourses(
                        form.getDepartment(),
                        form.getNumber(),
                        form.getName()));
        return "courses";
    }

}
