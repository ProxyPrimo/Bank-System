package banksystem.data.entities;

import banksystem.data.entities.enumerations.EmployeePosition;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeEntity extends BaseEntity {
    private String employeeNumber;
    private EmployeePosition position;
    private BranchEntity branch;
    private UserEntity user;

    public EmployeeEntity() {
    }

    @Column(name = "employee_number", nullable = false)
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Enumerated(EnumType.STRING)
    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    @ManyToOne
    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }

    @OneToOne(targetEntity=UserEntity.class)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
