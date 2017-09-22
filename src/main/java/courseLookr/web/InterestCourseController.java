package courseLookr.web;

import courseLookr.pojo.Course;
import courseLookr.repository.CourseRepository;
import courseLookr.repository.InterestCourseRepository;
import courseLookr.repository.InterestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/interestCourse")
public class InterestCourseController {

    private CourseRepository courseRepository;
    private InterestRepository interestRepository;
    private InterestCourseRepository interestCourseRepository;

    private final Logger logger = LoggerFactory.getLogger(InterestCourseController.class);

    @Autowired
    public InterestCourseController(CourseRepository courseRepository, InterestRepository interestRepository
                                    , InterestCourseRepository interestCourseRepository) {
        this.courseRepository = courseRepository;
        this.interestRepository = interestRepository;
        this.interestCourseRepository = interestCourseRepository;
    }

    @RequestMapping(value = "/{interestId}_{courseId}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable ("courseId") int courseId,
                         @PathVariable("interestId") int interestId,
                         Model model) {
        logger.debug("start delete");
        interestCourseRepository.deleteInterestCourseRelation(interestId, courseId);
        logger.debug("end delete");
        model.addAttribute("interest", interestRepository.getInterest(interestId));
        model.addAttribute("courses", courseRepository.getCoursesForInterest(interestId));
        return "redirect:/interest/" + interestId;
    }

    @RequestMapping(value = "/{interestId}", method = RequestMethod.POST)
    public String insert(@PathVariable("interestId") int interestId,
                         CourseForm form, Model model) {
        Course course = courseRepository.searchCourse(form.getDepartment(), form.getNumber());
        if (course != null) {
            int courseId = course.getId();
            interestCourseRepository.addInterestCourseRelation(interestId, courseId);
        }
        model.addAttribute("interest", interestRepository.getInterest(interestId));
        model.addAttribute("courses", courseRepository.getCoursesForInterest(interestId));
        return "redirect:/interest/" + interestId;
    }
}
