package courseLookr.repository;

public interface InterestCourseRepository {
    public void deleteInterestCourseRelation(int interestId, int courseId);
    public void addInterestCourseRelation(int interestId, int courseId);
}
