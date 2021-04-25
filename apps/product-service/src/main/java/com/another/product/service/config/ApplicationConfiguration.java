package com.another.product.service.config;

import com.another.product.core.item.gateway.ItemCommandGateway;
import com.another.product.core.item.create.CreateItem;
import com.another.product.core.item.create.CreateItemUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public CreateItem createItem(ItemCommandGateway itemCommandGateway) {
        return new CreateItemUseCase(itemCommandGateway);
    }
}
