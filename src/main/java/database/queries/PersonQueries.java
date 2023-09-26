package database.queries;

import database.connection.DataBaseConnection;
import database.dto.PersonCountDomainsDto;
import database.models.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class PersonQueries {

    private static ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    public static Person getAllPersonWithWithResultSet(ResultSet resultSet) throws SQLException {
        Person person = null;
        int id = resultSet.getInt(1);
        String jobTitle = resultSet.getString(2);
        String firstNameLastName = resultSet.getString(3);
        String phone = resultSet.getString(4);
        String email = resultSet.getString(5);
        person = new Person(id, jobTitle, firstNameLastName, phone, email);
        return person;
    }

    static PersonCountDomainsDto getAllPersonWithCountDomainWithResultSet(ResultSet resultSet) throws SQLException {
        PersonCountDomainsDto person = null;
        int id = resultSet.getInt(1);
        String jobTitle = resultSet.getString(2);
        String firstNameLastName = resultSet.getString(3);
        String phone = resultSet.getString(4);
        String email = resultSet.getString(5);
        String num_domains = resultSet.getString(6);
        person = new PersonCountDomainsDto(id, jobTitle, firstNameLastName, phone, email, num_domains);
        return person;
    }

    public static List<PersonCountDomainsDto> getPersons() {

        List<PersonCountDomainsDto> persons = new LinkedList<>();

        String query = "SELECT\n" +
                "    p.id AS person_id,\n" +
                "    p.jobtitle,\n" +
                "    p.firstnamelastname,\n" +
                "    p.phone,\n" +
                "    p.email,\n" +
                "    COUNT(d.id) AS num_domains\n" +
                "FROM\n" +
                "    person p\n" +
                "LEFT JOIN\n" +
                "    domains d ON p.id = d.personid\n" +
                "GROUP BY\n" +
                "    p.id, p.jobtitle, p.firstnamelastname, p.phone, p.email";

        try (ResultSet rs = executeQuery(query)) {
            while (rs.next()) {
                PersonCountDomainsDto person = getAllPersonWithCountDomainWithResultSet(rs);
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return persons;
    }
}

