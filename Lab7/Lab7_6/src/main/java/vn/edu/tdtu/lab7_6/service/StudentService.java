package vn.edu.tdtu.lab7_6.service;

import org.springframework.data.domain.Page;
import vn.edu.tdtu.lab7_6.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllByOrderByAgeDescIeltsScoreAsc();

    public void printStudents456();

    void saveStudent(Student student);
}
