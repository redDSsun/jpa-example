package org.example.jpaexample.domain.user;

import org.example.jpaexample.infra.persistence.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    UserEntity toUserEntity(UserPO user);
}
