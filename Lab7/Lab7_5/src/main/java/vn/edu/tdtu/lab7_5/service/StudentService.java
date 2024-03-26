package vn.edu.tdtu.lab7_5.service;

import vn.edu.tdtu.lab7_5.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudentById(Long id);

    void deleteStudent(Long id);

    List<Student> studentAgeG_M(int age);

    int countStudentIelts(int ieltsScore);

    List<Student> keywordInName(String keyword);
}
