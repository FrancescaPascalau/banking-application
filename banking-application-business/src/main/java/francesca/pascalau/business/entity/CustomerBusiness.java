package francesca.pascalau.business.entity;

import java.util.List;

public class CustomerBusiness {

    private String name;
    private List<AccountBusiness> accounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AccountBusiness> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountBusiness> accounts) {
        this.accounts = accounts;
    }
}
