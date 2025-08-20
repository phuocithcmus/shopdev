package com.phuocnd.shopdev.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phuocnd.shopdev.entities.user.UserEntity;

// @RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Additional query methods can be defined here if needed

    Page<UserEntity> findByUsername(String username, Pageable pageable);

    // RAW
    @Query("SELECT u FROM UserEntity u WHERE u.id  = ( SELECT Max(u.id) FROM UserEntity u )")
    UserEntity findLatestUser();

    @Query("SELECT u FROM UserEntity u WHERE u.id = :id")
    List<UserEntity> getUserEntityById(@Param("id") Long id);
}
