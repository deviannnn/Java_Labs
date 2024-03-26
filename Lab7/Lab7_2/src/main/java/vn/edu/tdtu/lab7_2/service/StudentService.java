package vn.edu.tdtu.lab7_2.service;

import vn.edu.tdtu.lab7_2.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudentById(Long id);

    void deleteStudent(Long id);
}
