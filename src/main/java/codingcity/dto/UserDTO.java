package codingcity.dto;


public class UserDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Integer amountOfMoney;

    public UserDTO(String firstName, String lastName, String email, String password, Integer amountOfMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.amountOfMoney = amountOfMoney;
    }

    public UserDTO(Long id, String firstName, String lastName, String email, String password,Integer amountOfMoney) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.amountOfMoney = amountOfMoney;
    }

    public UserDTO() {
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
}
