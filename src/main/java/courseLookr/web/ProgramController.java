package courseLookr.web;

import courseLookr.pojo.Package;
import courseLookr.pojo.Interest;
import courseLookr.pojo.Program;

import courseLookr.repository.InterestRepository;
import courseLookr.repository.PackageRepository;
import courseLookr.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/program")
public class ProgramController {

    private ProgramRepository programRepository;
    private PackageRepository packageRepository;
    private InterestRepository interestRepository;

    @Autowired
    public ProgramController(ProgramRepository programRepository, PackageRepository packageRepository,
                             InterestRepository interestRepository) {
        this.programRepository = programRepository;
        this.packageRepository = packageRepository;
        this.interestRepository = interestRepository;
    }

    @RequestMapping(value="/{programId}", method= RequestMethod.GET)
    public String course(@PathVariable("programId") int programId,
                         Model model) {
        Program program = programRepository.getProgram(programId);
        List<Package> packages = packageRepository.getPackagesForProgram(programId);
        List<Interest> interests = interestRepository.getInterestsForProgram(programId);
        model.addAttribute("program", program);
        model.addAttribute("packages", packages);
        model.addAttribute("interests", interests);
        return "program";
    }
}
