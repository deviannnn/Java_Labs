package ex3;

import java.util.List;

public class Ex3 {
    public static void main(String[] args) {

        // 1. khởi tạo danh sách sinh viên
        List<Student> list = StudentUtils.generate();
        System.out.println("- LIST STUDENT IN THE BEGIN:");
        StudentUtils.print(list);

        // 2. sắp xếp theo tên và in ra kết quả
        StudentUtils.sortByName(list);
        System.out.println("- LIST AFTER SORTED BY NAME:");
        StudentUtils.print(list);

        // 3. sắp xếp tăng dần theo điểm trung bình và in ra kết quả
        StudentUtils.sortByAvg(list);
        System.out.println("- LIST AFTER SORTED BY AVG SCORE:");
        StudentUtils.print(list);

        // @TODO: sắp xếp giảm dần theo tuổi rồi in kết quả
        StudentUtils.sortByAgeDescending(list);
        System.out.println("- LIST AFTER SORTED BY AGE:");
        StudentUtils.print(list);

        // @TODO: tính điểm trung bình của toàn bộ danh sách rồi in kết quả
        double averageScore = StudentUtils.avg(list);
        System.out.println("- AVG SCORE ALL OF STUDENTS = " + averageScore);

        // @TODO: lấy danh sách TÊN học sinh giỏi rồi in kết quả
        List<String> goodStudentName = StudentUtils.goodStudentName(list);
        System.out.print("\n- NAME OF GOOD STUDENTS: ");
        goodStudentName.forEach(name -> System.out.print(name + ", "));


    }
}
