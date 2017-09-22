package courseLookr.sqlQuery;

public class QueryForInterestCourse {
    public static final String deleteInterestCourseRelation = "DELETE FROM interest_courseship " +
            "WHERE interest_id = ? AND course_id = ?";
    public static final String addInterestCourseRelation = "INSERT INTO interest_courseship (interest_id, course_id)" +
            " VALUES(?, ?) ON DUPLICATE KEY UPDATE interest_id=interest_id;";
}
