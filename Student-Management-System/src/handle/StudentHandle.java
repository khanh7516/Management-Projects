package handle;
import entity.Student;
import java.util.Scanner;

public class StudentHandle {
    private Scanner scanner = new Scanner(System.in);
    private InputHandle inputHandle = new InputHandle();

    public Student createStudent() {
        System.out.println("Nhập thông tin cho học sinh: ");
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhâp tuổi: ");
        int age = inputHandle.inputPositiveInt();
        System.out.println("Nhập xếp loại: ");
        String grade = inputHandle.inputGrade();

        return new Student(name, age, grade);
    }
}
