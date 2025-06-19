package org.example.jpaexample.audit.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditablePO {

    protected String createdBy;

    @CreatedDate
    @Column(updatable = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdOn;

    protected String modifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date modifiedOn;

    @PrePersist
    public void preCreate() {

        preCreateHook();
    }

    @PreUpdate
    public void preUpdate() {

        preUpdateHook();
    }

    @PreRemove
    public void preRemove() {
        preRemoveHook();
    }

    @PostPersist
    public void postCreate() {

        postCreateHook();
    }

    @PostUpdate
    public void postUpdate() {
        postUpdateHook();
    }

    @PostRemove
    public void postRemove() {
        postRemoveHook();
    }

    /*
     * overwrite below hook functions in subclass to do some extra work
     * */
    protected void preCreateHook() {
    }

    ;

    protected void preUpdateHook() {
    }

    ;

    protected void preRemoveHook() {
    }

    ;

    protected void postCreateHook() {
    }

    ;

    protected void postUpdateHook() {
    }

    ;

    protected void postRemoveHook() {
    }

    ;

}
