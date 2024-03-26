package vn.edu.tdtu.lab7_6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.tdtu.lab7_6.model.Student;
import vn.edu.tdtu.lab7_6.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllByOrderByAgeDescIeltsScoreAsc() {
        return studentRepository.findAllByOrderByAgeDescIeltsScoreAsc();
    }

    @Override
    public void printStudents456() {
        Pageable pageable = PageRequest.of(1, 3, Sort.by(Sort.Direction.DESC, "age").and(Sort.by("ieltsScore")));
        Page<Student> page = studentRepository.findAll(pageable);
        List<Student> students = page.getContent();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

}
