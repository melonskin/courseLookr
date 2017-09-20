package courseLookr.web;

import courseLookr.repository.CourseRepository;
import courseLookr.repository.PackageRepository;
import courseLookr.repository.ProgramRepository;
import courseLookr.pojo.Package;
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
    private ProgramRepository programRepository;

    @Autowired
    public PackageController(CourseRepository courseRepository, PackageRepository packageRepository
                            , ProgramRepository programRepository) {
        this.courseRepository = courseRepository;
        this.packageRepository = packageRepository;
        this.programRepository = programRepository;
    }

    @RequestMapping(value="/{packageId}", method= RequestMethod.GET)
    public String getPackage(@PathVariable("packageId") int packageId,
                             Model model) {
        Package packagec = packageRepository.getPackage(packageId);
        model.addAttribute("program", programRepository.getProgram(packagec.getProgram_id()));
        model.addAttribute("packagec", packageRepository.getPackage(packageId));
        model.addAttribute("courses", courseRepository.getCoursesForPackage(packageId));
        return "packagec";
    }
}
