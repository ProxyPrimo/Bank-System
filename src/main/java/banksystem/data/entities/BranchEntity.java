package banksystem.data.entities;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "branches")
public class BranchEntity extends BaseEntity {
    private AddressEntity address;
    private Integer level;
    private Boolean isCentral;
    private TownEntity town;

    public BranchEntity() {
    }

    @OneToOne
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    @Min(1)
    @Max(3)
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Column(name = "is_central", nullable = false)
    public Boolean getCentral() {
        return isCentral;
    }

    public void setCentral(Boolean central) {
        isCentral = central;
    }

    @ManyToOne
    public TownEntity getTown() {
        return town;
    }

    public void setTown(TownEntity town) {
        this.town = town;
    }
}
