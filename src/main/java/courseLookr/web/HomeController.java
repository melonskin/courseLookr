package courseLookr.web;

import courseLookr.pojo.Course;
import courseLookr.repository.CourseRepository;
import courseLookr.repository.ProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private ProgramRepository programRepository;

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @Autowired
    public HomeController(CourseRepository courseRepository, ProgramRepository programRepository) {
        this.courseRepository = courseRepository;
        this.programRepository = programRepository;
    }

    @RequestMapping(method = GET)
    public String home(Model model) {
        model.addAttribute("programs",
                programRepository.getAllPrograms());
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
