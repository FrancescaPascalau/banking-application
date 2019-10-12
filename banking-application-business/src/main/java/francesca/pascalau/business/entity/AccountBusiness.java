package francesca.pascalau.business.entity;

import java.util.List;

public class AccountBusiness {

    private String name;
    private List<TransferBusiness> transfers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TransferBusiness> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<TransferBusiness> transfers) {
        this.transfers = transfers;
    }
}
