package vn.edu.tdtu.lab7_5.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;
import vn.edu.tdtu.lab7_5.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    List<Student> studentAgeG_M(@Param("age") int age);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.ieltsScore = :ieltsScore")
    int countStudentIelts(@Param("ieltsScore") int ieltsScore);

    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE CONCAT('%', LOWER(:keyword), '%')")
    List<Student> keywordInName(@Param("keyword") String keyword);


}
