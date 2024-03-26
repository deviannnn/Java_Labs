package vn.edu.tdtu.lab7_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.tdtu.lab7_4.model.Student;
import vn.edu.tdtu.lab7_4.service.StudentService;

import java.util.List;

@SpringBootApplication
public class Lab74Application implements CommandLineRunner {
    @Autowired
    private StudentService studentService;

    private void showStudents(List<Student> listStudent) {
        for (Student student : listStudent) {
            System.out.println(student.toString());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab74Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student stu1 = new Student(1L,"Ly Tuan An",20,"tuanan123@gmail.com",8.5);
        Student stu2 = new Student(2L,"Ly Anh Thuyen",18,"anhthuyen321@gmail.com",8.0);
        Student stu3 = new Student(3L,"Ly Anh Thu",16,"anhthu132@gmail.com",9.0);
        Student stu4 = new Student(4L,"Tran Tuan Anh",16,"tynhanh@gmail.com",7.0);
        Student stu5 = new Student(5L,"Nguyen Quynh Anh ",16,"qynhanh@gmail.com",8.0);
        this.studentService.saveStudent(stu1);
        this.studentService.saveStudent(stu2);
        this.studentService.saveStudent(stu3);
        this.studentService.saveStudent(stu4);
        this.studentService.saveStudent(stu5);

        List<Student> all = studentService.getAllStudents();
        showStudents(all);

        System.out.println("\nAfter updating student:");
        stu1.setIeltsScore(8.0);
        this.studentService.saveStudent(stu1);
        showStudents(all);

        System.out.println("\nAfter deleting student:");
        this.studentService.deleteStudent(1L);
        showStudents(all);

        System.out.println("\nList of students whose age is greater than or equal 18:");
        List<Student> age18 = this.studentService.findByAgeGreaterThanEqual(18);
        showStudents(age18);

        int ielts8 = this.studentService.countByIeltsScore(8);
        System.out.println("\nThe number of students whose ielts score is equal 8: " + ielts8 + " student");

        System.out.println("\nlist of students whose name contains the word 'tuan':");
        List<Student> containTuanInName = this.studentService.findByNameContainingIgnoreCase("tuan");
        showStudents(containTuanInName);
    }
}
