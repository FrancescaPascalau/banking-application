package francesca.pascalau.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * The Transfer entity maintain the relation with the Account entity as a many-to-one relation.
 */

@Entity
@Table(schema = "public", name = "`TRANSFERS`")
public class Transfer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TRANSFER")
    private UUID id;

    @Column(name = "TYPE")
    @Enumerated(EnumType.ORDINAL)
    private TransferType transferType;

    @Column(name = "VALUE")
    private double valueToTransfer;

    @ManyToOne
    @JoinColumn(name = "ID_ACCOUNT_SENDER", referencedColumnName = "ID_ACCOUNT")
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "ID_ACCOUNT_RECEIVER", referencedColumnName = "ID_ACCOUNT")
    private Account receiver;

    public Transfer() {
    }

    public Transfer(TransferType transferType, Double valueToTransfer, Account sender, Account receiver) {
        this.transferType = transferType;
        this.valueToTransfer = valueToTransfer;
        this.sender = sender;
        this.receiver = receiver;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public Double getValueToTransfer() {
        return valueToTransfer;
    }

    public void setValueToTransfer(Double valueToTransfer) {
        this.valueToTransfer = valueToTransfer;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }
}
