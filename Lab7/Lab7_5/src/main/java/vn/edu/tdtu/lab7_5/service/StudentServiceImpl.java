package vn.edu.tdtu.lab7_5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.tdtu.lab7_5.model.Student;
import vn.edu.tdtu.lab7_5.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> studentAgeG_M(int age) {
        return studentRepository.studentAgeG_M(age);
    }

    @Override
    public int countStudentIelts(int ieltsScore) {
        return studentRepository.countStudentIelts(ieltsScore);
    }

    @Override
    public List<Student> keywordInName(String keyword) {
        return studentRepository.keywordInName(keyword);
    }
}
