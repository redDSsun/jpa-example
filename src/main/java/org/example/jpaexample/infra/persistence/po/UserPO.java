package org.example.jpaexample.infra.persistence.po;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user", schema = "demo")
@Slf4j
public class UserPO extends BasePO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @Override
    protected void preCreateHook() {
        log.info("sub class preCreateHook");
    }

    @Override
    protected void preUpdateHook() {
        log.info("sub class preUpdateHook");
    }

    @Override
    protected void preRemoveHook() {
        log.info("sub class preRemoveHook");
    }

    @Override
    protected void postCreateHook() {
        log.info("sub class postCreateHook");
    }

    @Override
    protected void postUpdateHook() {
        log.info("sub class postUpdateHook");
    }

    @Override
    protected void postRemoveHook() {
        log.info("sub class postRemoveHook");
    }
}
