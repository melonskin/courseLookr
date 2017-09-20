package courseLookr.web;

import courseLookr.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/package")
public class PackageController {

    private CourseRepository courseRepository;

    @Autowired
    public PackageController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    //TODO
    @RequestMapping(value="/{packageId}", method= RequestMethod.GET)
    public String getPackage(@PathVariable("packageId") int packageId,
                             Model model) {

        return "packagec";
    }
}
