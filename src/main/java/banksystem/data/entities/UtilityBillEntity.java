package banksystem.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "utility_bills")
public class UtilityBillEntity extends BaseEntity {

    private String category;
    private String company;

    public UtilityBillEntity() {
    }


    @Column(name = "category", nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "company", nullable = false)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
