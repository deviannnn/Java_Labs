package vn.edu.tdtu.lab7_2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.edu.tdtu.lab7_2.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
