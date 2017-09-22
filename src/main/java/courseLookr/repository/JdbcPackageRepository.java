package courseLookr.repository;

import courseLookr.pojo.Package;
import courseLookr.sqlQuery.QueryForPackage;
import courseLookr.sqlQuery.QueryForProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcPackageRepository implements PackageRepository{

    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcPackageRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public Package getPackage(int id) {
        return jdbcOperations.queryForObject(QueryForPackage.getPackage, new PackageRowMapper(), id);
    }

    public List<Package> getPackagesForProgram(int programId) {
        return jdbcOperations.query(QueryForPackage.getPackagesForProgram, new PackageRowMapper(), programId);
    }

    private static class PackageRowMapper implements RowMapper<Package> {
        public Package mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Package(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("no_required"),
                    rs.getInt("program_id"));

        }
    }
}
