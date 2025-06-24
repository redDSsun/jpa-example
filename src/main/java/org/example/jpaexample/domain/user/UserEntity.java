package org.example.jpaexample.domain.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserEntity {

    private Long id;
    private String name;
    private int age;
}
