package courseLookr.repository;

import courseLookr.pojo.Program;

import java.util.List;

public interface ProgramRepository {
    List<Program> getAllPrograms();
    Program getProgram(int id);
}
