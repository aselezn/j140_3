package database.models;

import java.util.Objects;


public class Person {

    public Integer id;
    public String jobTitle;
    public String firstNameLastName;
    public String phone;
    public String email;

    public Person(Integer id, String jobTitle, String firstNameLastName, String phone, String email) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.firstNameLastName = firstNameLastName;
        this.phone = phone;
        this.email = email;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) && firstNameLastName.equals(person.firstNameLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstNameLastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", firstNameLastName='" + firstNameLastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
