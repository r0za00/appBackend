package com.aplication_project1.aplication_project1.Repository;

import com.aplication_project1.aplication_project1.Model.LessonModel;
import com.aplication_project1.aplication_project1.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<LessonModel, Long> {
    @Query(value = "SELECT * FROM lesson_model WHERE user_id = :userId", nativeQuery = true)
    List<LessonModel> findLessonsByUserId(@Param("userId") long userId);

    @Query(value = "SELECT * FROM lesson_model WHERE teacher_id = :teacherId", nativeQuery = true)
    List<LessonModel> findLessonsByTeacherId(@Param("teacherId") long teacherId);
}
