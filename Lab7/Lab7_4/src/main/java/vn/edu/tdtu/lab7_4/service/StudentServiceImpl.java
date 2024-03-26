package vn.edu.tdtu.lab7_4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.tdtu.lab7_4.model.Student;
import vn.edu.tdtu.lab7_4.repository.StudentRepository;

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
    public List<Student> findByAgeGreaterThanEqual(int age) {
        return studentRepository.findByAgeGreaterThanEqual(age);
    }

    @Override
    public int countByIeltsScore(int ieltsScore) {
        return studentRepository.countByIeltsScore(ieltsScore);
    }

    @Override
    public List<Student> findByNameContainingIgnoreCase(String keyword) {
        return studentRepository.findByNameContainingIgnoreCase(keyword);
    }
}
