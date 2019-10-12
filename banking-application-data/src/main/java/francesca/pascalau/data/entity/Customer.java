package francesca.pascalau.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * The Customer entity maintains the relation with the Bank entity and has a one-to-many relation with the
 * Account entity, because a customer can have more accounts at the same bank or at different banks.
 */

@Entity
@Table(schema = "public", name = "`CUSTOMERS`")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CUSTOMER")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ID_BANK", referencedColumnName = "ID_BANK")
    private Bank bank;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Account> accounts;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
        this.accounts = Collections.emptyList();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
