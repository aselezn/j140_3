package database.queries;

import database.connection.DataBaseConnection;
import database.models.Domain;
import database.models.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class DomainQueries {

    private final PersonQueries personData = new PersonQueries();

    private static ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    static Domain getAllDomainWithResultSet(ResultSet resultSet) throws SQLException {

        Domain domain = null;
        Person person = null;
        int id = resultSet.getInt(1);
        String webName = resultSet.getString(2);
        String domainName = resultSet.getString(3);
        String ip = resultSet.getString(4);
        java.sql.Date sqlDate = resultSet.getDate(5);
        LocalDate localDate = sqlDate.toLocalDate();
        LocalDateTime dateReg = localDate.atStartOfDay();
        String countryReg = resultSet.getString(6);
        int personId = resultSet.getInt(7);
        domain = new Domain(id, webName, domainName, ip, dateReg, countryReg, personId);
        return domain;

    }

    public static List<Domain> getDomains(Integer personId) {

        List<Domain> domains = new LinkedList<>();

        String query = "SELECT * FROM domains WHERE personid = " + personId;

        try (ResultSet rs = executeQuery(query)) {
            while (rs.next()) {
                Domain domain = getAllDomainWithResultSet(rs);
                domains.add(domain);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return domains;
    }

}
