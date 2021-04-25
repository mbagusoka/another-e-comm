package com.another.product.persistence.item;

import com.another.product.persistence.config.JpaTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = JpaTestConfiguration.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void givenEntity_whenSave_shouldSaveToRepository() {
        saveEntity();

        assertThat(itemRepository.count()).isEqualTo(1);
    }

    @Test
    void givenEntity_whenSave_shouldAddAuditEntity() {
        ItemEntity actual = saveEntity();

        assertThat(actual.getCreateDate()).isNotNull();
        assertThat(actual.getCreatedBy()).isEqualTo("SYSTEM");
        assertThat(actual.getLastModifiedDate()).isNotNull();
        assertThat(actual.getLastModifiedBy()).isEqualTo("SYSTEM");
    }

    private ItemEntity saveEntity() {
        ItemEntity itemEntity = getItemEntity();

        return itemRepository.save(itemEntity);
    }

    private ItemEntity getItemEntity() {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setName("dummy");
        itemEntity.setPrice(BigDecimal.ONE);
        return itemEntity;
    }
}
