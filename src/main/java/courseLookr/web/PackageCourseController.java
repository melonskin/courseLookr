package courseLookr.web;

import courseLookr.pojo.Course;
import courseLookr.pojo.Package;
import courseLookr.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/packageCourse")
public class PackageCourseController {

    private CourseRepository courseRepository;
    private PackageRepository packageRepository;
    private PackageCourseRepository packageCourseRepository;

    private final Logger logger = LoggerFactory.getLogger(PackageCourseController.class);

    @Autowired
    public PackageCourseController(CourseRepository courseRepository, PackageRepository packageRepository
            , PackageCourseRepository packageCourseRepository) {
        this.courseRepository = courseRepository;
        this.packageRepository = packageRepository;
        this.packageCourseRepository = packageCourseRepository;
    }

    @RequestMapping(value = "/{packageId}_{courseId}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("courseId") int courseId,
                         @PathVariable("packageId") int packageId,
                         Model model) {
        logger.debug("start delete");
        packageCourseRepository.deletePackageCourseRelation(packageId, courseId);
        logger.debug("end delete");
        model.addAttribute("package", packageRepository.getPackage(packageId));
        model.addAttribute("courses", courseRepository.getCoursesForPackage(packageId));
        return "redirect:/package/" + packageId;
    }

    @RequestMapping(value = "/{packageId}", method = RequestMethod.POST)
    public String insert(@PathVariable("packageId") int packageId,
                         CourseForm form, Model model) {
        List<Course> courses = courseRepository.searchCourse(form.getDepartment(), form.getNumber());
        if (!courses.isEmpty()) {
            int courseId = courses.get(0).getId();
            packageCourseRepository.addPackageCourseRelation(packageId, courseId);
        }
        model.addAttribute("package", packageRepository.getPackage(packageId));
        model.addAttribute("courses", courseRepository.getCoursesForPackage(packageId));
        return "redirect:/package/" + packageId;
    }
}
