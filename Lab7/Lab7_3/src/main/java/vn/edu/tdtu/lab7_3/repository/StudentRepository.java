package vn.edu.tdtu.lab7_3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.edu.tdtu.lab7_3.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
