package vn.edu.tdtu.lab7_4.service;

import vn.edu.tdtu.lab7_4.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudentById(Long id);

    void deleteStudent(Long id);

    List<Student> findByAgeGreaterThanEqual(int age);

    int countByIeltsScore(int ieltsScore);

    List<Student> findByNameContainingIgnoreCase(String keyword);
}
