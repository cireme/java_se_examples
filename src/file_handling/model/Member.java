package file_handling.model;

import file_handling.manager.ConsoleManager;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Member implements Comparable<Member>, Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Member() {
    }

    public Member(Long id) {
        this.id = id;
    }

    public Member(Long id, String firstName, String lastName, Date birthDate) {
        this(firstName, lastName, birthDate);
        this.id = id;
    }

    public Member(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "'}";
    }

    @Override
    public boolean equals(Object o) {
        ConsoleManager.getInstance().printToConsole("equals de Member - " + o, true);

        // test object reference
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        // cast to object type
        Member member = (Member) o;

        // test id
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Member m) {
        return id.compareTo(m.id);
    }
}
