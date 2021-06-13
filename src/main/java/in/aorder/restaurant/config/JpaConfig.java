package in.aorder.restaurant.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("in.aorder.restaurant.entity")
@EnableJpaRepositories("in.aorder.restaurant.repository")
public class JpaConfig {
}
