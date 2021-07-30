package banksystem.data.bindings;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class UserRegisterBindingModel {
    private String firstName;
    private String middleName;
    private String lastName;
    private Long identificationNumber;
    private String email;
    private String password;
    private BigDecimal salary;

    public UserRegisterBindingModel() {
    }

    @NotNull
    @Length(min = 2, message = "The name must be at least 2 symbols")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Length(min = 2, message = "The name must be at least 2 symbols")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @NotNull
    @Length(min = 2, message = "The name needs to be at least 2 symbols")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Min(1000000000L)
    @Max(9999999999L)
    @NotNull
    public Long getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$"
            , message = "The password must contain an upper case letter" +
            ", a lower case letter, a number and must be at least 5 characters long")
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DecimalMin("1")
    @NotNull
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
