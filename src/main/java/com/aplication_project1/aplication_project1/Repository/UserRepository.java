package com.aplication_project1.aplication_project1.Repository;

import com.aplication_project1.aplication_project1.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <UserModel, Long>{
    @Query(value = "SELECT * FROM user_model WHERE login = :login", nativeQuery = true)
    public UserModel findUserByLogin(@Param("login") String login);
    //public UserModel findUserByID(@Param("id")int id);
    @Query(value = "SELECT * FROM user_model WHERE teacher = :teacher", nativeQuery = true)
    List<UserModel> findUserOrTeachers(@Param("teacher") boolean teacher);
}
