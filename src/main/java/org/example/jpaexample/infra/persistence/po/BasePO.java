package org.example.jpaexample.infra.persistence.po;

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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Slf4j
public class BasePO {

    protected String createdBy;

    @CreatedDate
    @Column(updatable = false, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdOn;

    protected String modifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date modifiedOn;

    /**
     * the following fields are used for soft delete <br>
     * <code>
     * org.example.jpaexample.infra.persistence.po.BasePO.deleted <br>
     * org.example.jpaexample.infra.persistence.po.BasePO.deleteOn
     * </code>
     * <br>
     * for delete: <br>
     * call: <code>org.example.jpaexample.infra.persistence.po.BasePO#softDelete</code>
     * <br>
     * for query:<br>
     * use <code>@Where(clause = "is_deleted = 0")</code> on the children class:
     * for unique index:
     * add these 2 fields at the last of the index, since one record can be soft deleted
     */
    private boolean deleted;

    private long deleteOn;

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

    protected void softDelete() {
        preSoftDelete();
        softDeleteInternal();
        postSoftDelete();
    }

    private void softDeleteInternal() {
        this.deleted = true;
        this.deleteOn = System.currentTimeMillis();
    }

    protected void preSoftDelete() {
    }

    protected void postSoftDelete() {
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
