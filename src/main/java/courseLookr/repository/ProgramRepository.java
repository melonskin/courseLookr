package courseLookr.repository;

import courseLookr.pojo.Interest;
import courseLookr.pojo.Program;
import courseLookr.pojo.Package;

import java.util.List;

public interface ProgramRepository {
    List<Program> getAllPrograms();
    Program getProgram(int id);
    List<Package> getPackagesForProgram(int id);
    List<Interest> getInterestsForProgram(int id);
}
