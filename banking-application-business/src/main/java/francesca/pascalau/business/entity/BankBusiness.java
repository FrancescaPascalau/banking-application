package francesca.pascalau.business.entity;

import java.util.List;

public class BankBusiness {

    private String name;
    private List<CustomerBusiness> customers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomerBusiness> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerBusiness> customers) {
        this.customers = customers;
    }
}
