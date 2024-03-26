package vn.edu.tdtu.lab7_4.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.edu.tdtu.lab7_4.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByAgeGreaterThanEqual(int age);
    int countByIeltsScore(int ieltsScore);
    List<Student> findByNameContainingIgnoreCase(String keyword);

}
