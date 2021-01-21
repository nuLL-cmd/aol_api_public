package com.automatodev.loa.domain.repository;

import java.util.List;

import com.automatodev.loa.domain.model.entityModel.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAll();
    UserEntity findByIdUser(long id);
    UserEntity findByEmail(String email);   
    List<UserEntity> findByFirstName(String name);
    List<UserEntity> findByFirstNameContaining(String charset);
    UserEntity findByUid(String uid);
}