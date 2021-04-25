package com.another.product.persistence.item;

import com.another.product.core.item.create.CreateItemRequest;
import com.another.product.core.item.entity.Item;
import com.another.product.persistence.common.AuditTrail;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEntity extends AuditTrail implements Item, Serializable {

    private static final long serialVersionUID = 4275595619863897948L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private String imageUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ItemEntity that = (ItemEntity) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 1958895947;
    }

    public static ItemEntity valueOf(CreateItemRequest request) {
        return builder()
            .name(request.getName())
            .price(request.getPrice())
            .imageUrl(request.getImageUrl())
            .build();
    }
}
