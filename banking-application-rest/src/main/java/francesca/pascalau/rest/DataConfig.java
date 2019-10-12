package francesca.pascalau.rest;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan("francesca.pascalau")
@EnableJpaRepositories(basePackages = {"francesca.pascalau.data.api"})
public class DataConfig {
}
