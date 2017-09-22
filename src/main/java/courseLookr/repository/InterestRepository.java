package courseLookr.repository;

import courseLookr.pojo.Interest;

import java.util.List;

public interface InterestRepository {
    public Interest getInterest(int id);
    List<Interest> getInterestsForProgram(int programId);

}
