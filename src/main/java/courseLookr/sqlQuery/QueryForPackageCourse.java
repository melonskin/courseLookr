package courseLookr.sqlQuery;

public class QueryForPackageCourse {
    public static final String deletePackageCourseRelation = "DELETE FROM package_courseship " +
            "WHERE package_id = ? AND course_id = ?";
    public static final String addPackageCourseRelation = "INSERT INTO package_courseship (package_id, course_id)" +
            " VALUES(?, ?) ON DUPLICATE KEY UPDATE package_id=package_id;";
}
