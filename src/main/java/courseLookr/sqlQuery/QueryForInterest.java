package courseLookr.sqlQuery;

public class QueryForInterest {
    public static final String getInterest = "SELECT * FROM interest WHERE id = ?";
    public static final String getInterestsForProgram = "SELECT * FROM interest WHERE id IN " +
            "(SELECT interest_id FROM program_interestship WHERE program_id = ? )";
}
