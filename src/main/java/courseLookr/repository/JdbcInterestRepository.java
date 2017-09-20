package courseLookr.repository;

import courseLookr.pojo.Interest;
import courseLookr.sqlQuery.QueryForInterest;
import courseLookr.sqlQuery.QueryForProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcInterestRepository implements InterestRepository{

    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcInterestRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Interest getInterest(int id) {
        return jdbcOperations.queryForObject(QueryForInterest.getInterest, new InterestRowMapper(), id);
    }

    public List<Interest> getInterestsForProgram(int programId) {
        return jdbcOperations.query(QueryForInterest.getInterestsForProgram, new InterestRowMapper(), programId);
    }

    private static class InterestRowMapper implements RowMapper<Interest> {
        public Interest mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Interest(
                    rs.getInt("id"),
                    rs.getString("name"));
        }
    }
}
