package banksystem.data.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Entity
@Table(name = "safes")
public class SafeEntity extends BaseEntity {
    private BigDecimal capacity;
    private BigDecimal size;
    private BranchEntity branch;

    public SafeEntity() {
    }

    @DecimalMin("0")
    @Column(name = "capacity", nullable = false)
    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    @DecimalMin("0")
    @Column(name = "size", nullable = false)
    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    @OneToOne(targetEntity = BranchEntity.class)
    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }
}
