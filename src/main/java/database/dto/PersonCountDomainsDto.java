package database.dto;

import java.util.Objects;

public class PersonCountDomainsDto {

    public Integer id;
    public String jobTitle;
    public String firstNameLastName;
    public String phone;
    public String email;
    public String numDomains;

    public PersonCountDomainsDto(Integer id, String jobTitle, String firstNameLastName, String phone, String email, String numDomains) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.firstNameLastName = firstNameLastName;
        this.phone = phone;
        this.email = email;
        this.numDomains = numDomains;
    }

    public Integer getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getFirstNameLastName() {
        return firstNameLastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getNumDomains() {
        return numDomains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonCountDomainsDto person = (PersonCountDomainsDto) o;
        return id.equals(person.id) && firstNameLastName.equals(person.firstNameLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstNameLastName);
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", firstNameLastName='" + firstNameLastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", numDomains='" + numDomains + '\'' +
                '}';
    }
}
