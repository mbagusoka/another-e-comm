package com.another.product.persistence.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class AuditTrail {

    @CreatedDate
    @Column
    private Instant createDate;

    @CreatedBy
    @Column
    private String createdBy;

    @LastModifiedDate
    @Column
    private Instant lastModifiedDate;

    @LastModifiedBy
    @Column
    private String lastModifiedBy;
}
