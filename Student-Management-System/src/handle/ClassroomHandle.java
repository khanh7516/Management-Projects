package handle;

import entity.Classroom;
import entity.Student;
import entity.TechMaster;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassroomHandle {
    private final Scanner scanner = new Scanner(System.in);
    private final InputHandle inputHandle = new InputHandle();
    private final StudentHandle studentHandle = new StudentHandle();
    private TechMaster techMaster;
    private ArrayList<Student> students;

    public ClassroomHandle() {
        this.techMaster = createClass();
    }

    public Classroom createClassroom() {
        System.out.println("Bạn đang tạo lớp học ");
        System.out.println("Nhập môn học: ");
        String subject = scanner.nextLine();
        System.out.println("Nhập số lượng học sinh của lớp học: ");
        int numberOfStudent = inputHandle.inputPositiveInt();
        students = new ArrayList<>();
        for (int i = 0; i < numberOfStudent; i++) {
            appendStudent();
        }
        return new Classroom(subject, students);
    }

    public TechMaster createClass(){
        System.out.println("Nhập tên người quản lý khóa học: ");
        String managerName = scanner.nextLine();
        System.out.println("Nhập tên giáo viên khóa học này: ");
        String teacherName = scanner.nextLine();
        System.out.println("Giờ hãy tạo lớp học: ");
        Classroom newClassroom = createClassroom();
        return new TechMaster(managerName, teacherName, newClassroom);
    }

    public void displayDetail() {
        System.out.println(techMaster);
    }

    public void appendStudent() {
        students.add(studentHandle.createStudent());
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) return student;
        }return null; // Không tìm thấy sinh viên có id trùng với id đầu vào
    }

    public void removeStudent(int id) {
        students.remove(id - 1);
        System.out.println("Xóa thành công");
    }

    public void editGradeOfStudent(int id) {
        Student editStudent = findStudentById(id);
        System.out.println(editStudent);
        System.out.println("Nhập xếp loại mới cho học sinh này: ");
        editStudent.setGrade(inputHandle.inputGrade());
        System.out.println("Cập nhật thành công!\n" + editStudent);
    }
}
