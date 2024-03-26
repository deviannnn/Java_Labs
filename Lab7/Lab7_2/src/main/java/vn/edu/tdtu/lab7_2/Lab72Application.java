package vn.edu.tdtu.lab7_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.tdtu.lab7_2.model.Student;
import vn.edu.tdtu.lab7_2.service.StudentService;

import java.util.List;

@SpringBootApplication
public class Lab72Application implements CommandLineRunner {
    @Autowired
    private StudentService studentService;

    private void showAllStudents() {
        List<Student> listStudent = studentService.getAllStudents();
        for (Student student : listStudent) {
            System.out.println(student.toString());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab72Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student stu1 = new Student(1L,"Tuan An",20,"tuanan@gmail.com",7.0);
        Student stu2 = new Student(2L,"Anh Thuyen",18,"anhthuyen@gmail.com",8.5);
        Student stu3 = new Student(3L,"Anh Thu",16,"anhthu@gmail.com",7.5);
        this.studentService.saveStudent(stu1);
        this.studentService.saveStudent(stu2);
        this.studentService.saveStudent(stu3);
        showAllStudents();

        System.out.println("\nAfter updating student:");
        stu1.setIeltsScore(8.0);
        this.studentService.saveStudent(stu1);
        showAllStudents();

        System.out.println("\nAfter deleting student:");
        this.studentService.deleteStudent(1L);
        showAllStudents();
    }
}
