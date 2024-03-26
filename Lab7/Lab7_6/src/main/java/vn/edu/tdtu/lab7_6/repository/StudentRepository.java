package vn.edu.tdtu.lab7_6.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.edu.tdtu.lab7_6.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    List<Student> findAllByOrderByAgeDescIeltsScoreAsc();

    Page<Student> findAll(Pageable pageable);

    void save(Student student);
}
