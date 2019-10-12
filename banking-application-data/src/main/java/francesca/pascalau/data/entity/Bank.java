package francesca.pascalau.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The Bank entity has a one-to-many relation with the Customer, because there can be more customers to a bank.
 */

@Entity
@Table(schema = "public", name = "`BANKS`")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_BANK")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bank")
    private List<Customer> customerList;

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
        this.customerList = Collections.emptyList();
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

    public List<Customer> getCustomers() {
        return customerList;
    }

    public void setCustomers(List<Customer> customers) {
        this.customerList = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id) &&
                Objects.equals(name, bank.name) &&
                Objects.equals(customerList, bank.customerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, customerList);
    }
}
