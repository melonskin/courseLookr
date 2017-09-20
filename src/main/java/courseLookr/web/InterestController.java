package courseLookr.web;

import courseLookr.repository.CourseRepository;
import courseLookr.repository.InterestRepository;
import courseLookr.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/interest")
public class InterestController {

    private CourseRepository courseRepository;
    private InterestRepository interestRepository;

    @Autowired
    public InterestController(CourseRepository courseRepository, InterestRepository interestRepository) {
        this.courseRepository = courseRepository;
        this.interestRepository = interestRepository;
    }

    @RequestMapping(value="/{interestId}", method= RequestMethod.GET)
    public String getInterest(@PathVariable("interestId") int interestId,
                             Model model) {
        model.addAttribute("interest", interestRepository.getInterest(interestId));
        model.addAttribute("courses", courseRepository.getCoursesForInterest(interestId));
        return "interest";
    }
}
