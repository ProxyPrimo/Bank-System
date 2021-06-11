package banksystem.data.entities;

import banksystem.data.entities.enumerations.CardPaymentNetwork;
import banksystem.data.entities.enumerations.CardType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
public class CardEntity extends BaseEntity {
    private Integer number;
    private LocalDateTime expirationDate;
    private CardType type;
    private CardPaymentNetwork paymentNetwork;
    private BankAccountEntity bankAccount;


    public CardEntity() {
    }

    @Column(name = "number", nullable = false)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column(name = "expiration_date", nullable = false)
    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Enumerated(EnumType.STRING)
    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    @Enumerated(EnumType.STRING)
    public CardPaymentNetwork getPaymentNetwork() {
        return paymentNetwork;
    }

    public void setPaymentNetwork(CardPaymentNetwork paymentNetwork) {
        this.paymentNetwork = paymentNetwork;
    }

    @ManyToOne
    public BankAccountEntity getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccountEntity bankAccount) {
        this.bankAccount = bankAccount;
    }
}
