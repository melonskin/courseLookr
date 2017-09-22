package courseLookr.repository;

public interface PackageCourseRepository {
    public void deletePackageCourseRelation(int packageId, int courseId);
    public void addPackageCourseRelation(int packageId, int courseId);
}
