package courseLookr.web;

import courseLookr.pojo.Course;
import courseLookr.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
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
        model.addAttribute("sections", courseRepository.findSectionsByCourseId(courseId));
        return "course";
    }

    @RequestMapping(value="/{courseId}/edit", method=RequestMethod.GET)
    public String edit(
            @PathVariable("courseId") int courseId,
            Model model) {
        model.addAttribute("course", courseRepository.findOneById(courseId));
        return "courseEdit";
    }

    @RequestMapping(value="/{courseId}/edit", method=RequestMethod.POST)
    public String editPost(@PathVariable("courseId") int courseId,
                          Model model, @Valid CourseForm form, Errors errors) {
        if (errors.hasErrors()) {
            Course course = courseRepository.findOneById(courseId);
            model.addAttribute("course", course);
            model.addAttribute("errors", errors.getAllErrors());
            return "courseEdit";
        }
        courseRepository.updateCourseInfo(courseId, form);
        return "redirect:/courses/" + courseId;
//        try {
//            http.sendRedirect("/courses/" + courseId);
//        } catch (IOException e){
//        }
    }
}
