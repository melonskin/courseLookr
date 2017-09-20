package courseLookr.web;

import courseLookr.repository.CourseRepository;
import courseLookr.repository.PackageRepository;
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
    private PackageRepository packageRepository;

    @Autowired
    public PackageController(CourseRepository courseRepository, PackageRepository packageRepository) {
        this.courseRepository = courseRepository;
        this.packageRepository = packageRepository;
    }

    @RequestMapping(value="/{packageId}", method= RequestMethod.GET)
    public String getPackage(@PathVariable("packageId") int packageId,
                             Model model) {
        model.addAttribute("packagec", packageRepository.getPackage(packageId));
        model.addAttribute("courses", courseRepository.getCoursesForPackage(packageId));
        return "packagec";
    }
}
