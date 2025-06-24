package org.example.jpaexample.infra.persistence;


import org.example.jpaexample.infra.persistence.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserPO, Long> {

}
