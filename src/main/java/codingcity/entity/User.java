package codingcity.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "amount_of_money")
    private Integer amountOfMoney;

    @ManyToMany
    @JoinTable
    private Set<Role> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_course",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserProgress> progresses = new HashSet<>();

    public User(Long id, String firstName, String lastName, String email, String password, Integer amountOfMoney, Set<Course> courses, Set<UserProgress> progresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.amountOfMoney = amountOfMoney;
        this.courses = courses;
        this.progresses = progresses;
    }

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String password, Integer amountOfMoney) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.amountOfMoney = amountOfMoney;
    }

    public User(String firstName, String lastName, String email, String password, Integer amountOfMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.amountOfMoney = amountOfMoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Integer amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<UserProgress> getProgresses() {
        return progresses;
    }

    public void setProgresses(Set<UserProgress> progresses) {
        this.progresses = progresses;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
