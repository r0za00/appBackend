package com.aplication_project1.aplication_project1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserModel, Integer>{
    @Query(value = "SELECT * FROM user_model WHERE login = :login", nativeQuery = true)
    public UserModel findUserByLogin(@Param("login") String login);
   // public UserModel findUserByID(@Param("id")int id);
}
