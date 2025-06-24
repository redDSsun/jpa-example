package org.example.jpaexample.domain.user;

import lombok.RequiredArgsConstructor;
import org.example.jpaexample.common.exceptions.UserInvalidException;
import org.example.jpaexample.infra.persistence.UserRepository;
import org.example.jpaexample.infra.persistence.po.UserPO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity getUser(Long id) {
        UserPO userPO = userRepository.findById(id).orElseThrow(() -> new UserInvalidException(id));
        return UserEntityMapper.INSTANCE.toUserEntity(userPO);
    }

    public void updateUser(Long id, String name) {
        UserPO userPO = userRepository.findById(id).orElseThrow(() -> new UserInvalidException(id));
        userPO.setName(name);
        userRepository.save(userPO);
    }

    public void softDelete(Long id) {
        UserPO userPO = userRepository.findById(id).orElseThrow(() -> new UserInvalidException(id));
        userPO.softDelete();
        userRepository.save(userPO);
    }

    public void remove(Long id) {
        UserPO userPO = userRepository.findById(id).orElseThrow(() -> new UserInvalidException(id));
        userRepository.delete(userPO);
    }
}
