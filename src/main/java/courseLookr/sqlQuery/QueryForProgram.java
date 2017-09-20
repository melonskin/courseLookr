package courseLookr.sqlQuery;

public class QueryForProgram {
    public static final String getAllPrograms = "SELECT * FROM program";
    public static final String getProgram = "SELECT * FROM program WHERE id = ?";
    public static final String getPackagesForProgram = "SELECT * FROM package WHERE program_id = ?";
    public static final String getInterestsForProgram = "SELECT * FROM interest WHERE id IN " +
            "(SELECT interest_id FROM program_interestship WHERE program_id = ? )";
}
