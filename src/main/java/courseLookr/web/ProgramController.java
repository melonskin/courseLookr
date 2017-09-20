package courseLookr.web;

import courseLookr.pojo.Program;
import courseLookr.repository.CourseRepository;
import courseLookr.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/program")
public class ProgramController {

    private ProgramRepository programRepository;

    @Autowired
    public ProgramController(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    //TODO
    @RequestMapping(value="/{programId}", method= RequestMethod.GET)
    public String course(@PathVariable("programId") int programId,
                         Model model) {

        return "program";
    }
}
