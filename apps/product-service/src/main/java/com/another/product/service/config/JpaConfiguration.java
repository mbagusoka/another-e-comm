package com.another.product.service.config;

import com.another.product.core.item.gateway.ItemCommandGateway;
import com.another.product.persistence.item.DefaultItemCommandGateway;
import com.another.product.persistence.item.ItemRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@Configuration
@EntityScan(basePackages = "com.another.product.persistence")
@EnableJpaRepositories(basePackages = "com.another.product.persistence")
@EnableJpaAuditing
public class JpaConfiguration {

    @Bean
    public ItemCommandGateway itemGateway(ItemRepository itemRepository) {
        return new DefaultItemCommandGateway(itemRepository);
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("SYSTEM");
    }
}
