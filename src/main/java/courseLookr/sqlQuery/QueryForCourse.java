package courseLookr.sqlQuery;

public class QueryForCourse {
    public static final String searchCoursesQuery = "SELECT id, department, number, name, credit, description"
            + " FROM course"
            + " WHERE department LIKE ? AND number LIKE ? AND name LIKE ? LIMIT 25";
    public static final String searchCourse = "SELECT id, department, number, name, credit, description"
            + " FROM course"
            + " WHERE department = ? AND number = ? LIMIT 1";
    public static final String findOneCourseByIdQuery = "SELECT * FROM course WHERE id = ?";
    public static final String findSectionsByCourseIdQuery = "SELECT * FROM section WHERE course_id = ? ORDER BY year ASC, term ASC";
    public static final String updateCourseInfo = "UPDATE course SET name = ?, credit = ?, description = ? WHERE id = ?";
    public static final String getCoursesForPackage = "SELECT * FROM course WHERE id IN " +
                                                        "(SELECT course_id FROM package_courseship WHERE package_id = ? )";
    public static final String getCoursesForInterest = "SELECT * FROM course WHERE id IN " +
                                                        "(SELECT course_id FROM interest_courseship WHERE interest_id = ? )";
}
