package francesca.pascalau.data;

import francesca.pascalau.data.api.AccountRepository;
import francesca.pascalau.data.api.BankRepository;
import francesca.pascalau.data.api.CustomerRepository;
import francesca.pascalau.data.api.TransferRepository;
import francesca.pascalau.data.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SystemIntegrationTests {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransferRepository transferRepository;

    @Test
    public void whenFindByName_thenReturnAccount() {

        Customer customer = new Customer("Francesca Pascalau");
        Account account = new Account("University", 2300d, customer);

        customerRepository.save(customer);
        accountRepository.save(account);

        Account found = accountRepository.findByName(account.getName());

        assertThat(found.getName())
                .isEqualTo(account.getName());
    }

    @Test
    public void whenFindByName_thenReturnBank() {

        Bank bank = new Bank("Test Bank");

        bankRepository.save(bank);

        Bank found = bankRepository.findByName("Test Bank");

        assertThat(found.getName())
                .isEqualTo(bank.getName());
    }

    @Test
    public void whenFindByName_thenReturnCustomer() {

        Customer customer = new Customer("Ian Mark");

        customerRepository.save(customer);

        Customer found = customerRepository.findByName("Ian Mark");

        assertThat(found.getName())
                .isEqualTo(customer.getName());
    }

    @Test
    public void whenFindByType_thenReturnAllTransfersByThatType() {

        Customer sender = new Customer("Francesca Pascalau");
        Customer receiver = new Customer("John Newman");

        customerRepository.save(sender);
        customerRepository.save(receiver);

        Account accountSender = new Account("Economy", 2300d, sender);
        Account accountReceiver = new Account("Savings", 1000d, receiver);

        accountRepository.save(accountSender);
        accountRepository.save(accountReceiver);

        Transfer transfer = new Transfer(TransferType.INTRABANK, 300d, accountSender, accountReceiver);
        Transfer transfer2 = new Transfer(TransferType.INTRABANK, 200d, accountSender, accountReceiver);
        Transfer transfer3 = new Transfer(TransferType.INTERBANK, 400d, accountSender, accountReceiver);

        transferRepository.save(transfer);
        transferRepository.save(transfer2);
        transferRepository.save(transfer3);

        List<Transfer> expected = new ArrayList<>();
        expected.add(transfer);
        expected.add(transfer2);

        List<Transfer> actual = transferRepository.findByTransferType(TransferType.INTRABANK);

        assertThat(actual).isEqualTo(expected);
    }
}
