package vn.edu.tdtu.lab7_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.tdtu.lab7_6.model.Student;
import vn.edu.tdtu.lab7_6.service.StudentService;

import java.util.List;

@SpringBootApplication
public class Lab76Application implements CommandLineRunner {
    @Autowired
    private StudentService studentService;

    private void showStudents(List<Student> listStudent) {
        for (Student student : listStudent) {
            System.out.println(student.toString());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab76Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student stu1 = new Student(1L, "Ly Tuan An", 20, "tuanan123@gmail.com", 8.5);
        Student stu2 = new Student(2L, "Ly Anh Thuyen", 18, "anhthuyen321@gmail.com", 8.0);
        Student stu3 = new Student(3L, "Ly Anh Thu", 16, "anhthu132@gmail.com", 9.0);
        Student stu4 = new Student(4L, "Tran Tuan Anh", 16, "tynhanh@gmail.com", 7.0);
        Student stu5 = new Student(5L, "Nguyen Quynh Anh ", 16, "qynhanh@gmail.com", 8.0);
        this.studentService.saveStudent(stu1);
        this.studentService.saveStudent(stu2);
        this.studentService.saveStudent(stu3);
        this.studentService.saveStudent(stu4);
        this.studentService.saveStudent(stu5);

        System.out.println("All students sorted by age descending and IELTS score ascending:");
        List<Student> all = studentService.findAllByOrderByAgeDescIeltsScoreAsc();
        showStudents(all);


        if (all.size() > 10)
        {
            System.out.println("Students on page 2:");
            studentService.printStudents456();
        }
    }
}
