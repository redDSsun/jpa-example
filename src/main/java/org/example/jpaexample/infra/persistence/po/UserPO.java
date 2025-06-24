package org.example.jpaexample.infra.persistence.po;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user", schema = "demo")
public class UserPO extends BasePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @Override
    protected void preCreateHook() {
        super.preCreateHook();
    }

    @Override
    protected void preUpdateHook() {
        super.preUpdateHook();
    }

    @Override
    protected void preRemoveHook() {
        super.preRemoveHook();
    }

    @Override
    protected void postCreateHook() {
        super.postCreateHook();
    }

    @Override
    protected void postUpdateHook() {
        super.postUpdateHook();
    }

    @Override
    protected void postRemoveHook() {
        super.postRemoveHook();
    }
}
