package courseLookr.repository;

import courseLookr.pojo.Course;
import courseLookr.pojo.Program;
import courseLookr.sqlQuery.QueryForProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcProgramRepository implements ProgramRepository {

    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcProgramRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<Program> getAllPrograms() {
        return jdbcOperations.query(QueryForProgram.getAllPrograms, new ProgramRowMapper());
    }

    public Program getProgram(int id) {
        return jdbcOperations.queryForObject(QueryForProgram.getProgram, new ProgramRowMapper(), id);
    }

    private static class ProgramRowMapper implements RowMapper<Program> {
        public Program mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Program(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("acronym"));

        }
    }
}
