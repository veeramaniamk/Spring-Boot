package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Users;

import jakarta.transaction.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Users WHERE id = :userId")
    int deleteUserById(@Param("userId") long userId);

    @Modifying
    @Transactional
    @Query("UPDATE Users SET name = :name, email = :email WHERE id = :userId")
    int updateUserById(@Param("userId") long userId, @Param("name") String name, @Param("email") String email);

    @Query("SELECT name FROM Users WHERE id = :id")
    Optional<Users> findById(@Param("id") long id);

}
