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
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * The Account entity has a one-to-many relation with the transfer entity,
 * because every account has a list with all the transactions that was made.
 */

@Entity
@Table(schema = "public", name = "`ACCOUNTS`")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ACCOUNT")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "VALUE")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "ID_CUSTOMER", referencedColumnName = "ID_CUSTOMER")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender")
    private List<Transfer> transferListSent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiver")
    private List<Transfer> transferListReceived;

    public Account() {
    }

    public Account(String name, Double value, Customer customer) {
        this.name = name;
        this.value = value;
        this.customer = customer;
    }

    public Account(String name, Double value, Customer customer, List<Transfer> transferListSent,
                   List<Transfer> transferListReceived) {
        this.name = name;
        this.value = value;
        this.customer = customer;
        this.transferListSent = transferListSent;
        this.transferListReceived = transferListReceived;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Transfer> getTransferListSent() {
        return transferListSent;
    }

    public void setTransferListSent(List<Transfer> transferListSent) {
        this.transferListSent = transferListSent;
    }

    public void addTransferSent(Transfer transferSent) {
        this.transferListSent.add(transferSent);
    }

    public List<Transfer> getTransferListReceived() {
        return transferListReceived;
    }

    public void setTransferListReceived(List<Transfer> transferListReceived) {
        this.transferListReceived = transferListReceived;
    }

    public void addTransferReceived(Transfer transferReceived) {
        this.transferListSent.add(transferReceived);
    }
}
