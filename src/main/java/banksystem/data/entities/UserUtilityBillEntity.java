package banksystem.data.entities;

import banksystem.data.entities.enumerations.UtilityBillPaymentType;

import javax.persistence.*;

@Entity
@Table(name = "user_utility_bill")
public class UserUtilityBillEntity extends BaseEntity {
    private String name;
    private UtilityBillPaymentType payment;
    private String subscriptionNumber;
    private UserEntity user;
    private UtilityBillEntity utilityBill;

    public UserUtilityBillEntity() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public UtilityBillPaymentType getPayment() {
        return payment;
    }

    public void setPayment(UtilityBillPaymentType paymentType) {
        this.payment = paymentType;
    }

    @Column(name = "sucscription_number", nullable = false, unique = true)
    public String getSubscriptionNumber() {
        return subscriptionNumber;
    }

    public void setSubscriptionNumber(String subscriptionNumber) {
        this.subscriptionNumber = subscriptionNumber;
    }

    @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userEntity) {
        this.user = userEntity;
    }

    @ManyToOne
    public UtilityBillEntity getUtilityBill() {
        return utilityBill;
    }

    public void setUtilityBill(UtilityBillEntity utilityBillEntity) {
        this.utilityBill = utilityBillEntity;
    }
}
