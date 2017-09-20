package courseLookr.sqlQuery;

public class QueryForPackage {
    public static final String getPackage = "SELECT * FROM package WHERE id = ?";
    public static final String getPackagesForProgram = "SELECT * FROM package WHERE program_id = ?";

}
