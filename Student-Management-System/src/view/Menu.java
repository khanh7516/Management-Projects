package view;

import handle.ClassroomHandle;
import handle.InputHandle;

public class Menu {
    private InputHandle inputHandle = new InputHandle();
    private ClassroomHandle classroomHandle;

    public Menu() {
        classroomHandle = new ClassroomHandle();
    }

    public void displayMenu() {
        do {
            System.out.println("""
                    Hãy chọn các option sau:
                    1. Hiển thị thông tin chi tiết trung tâm 
                    2. Thêm 1 học sinh vào lớp
                    3. Chỉnh sửa thông tin 1 sinh viên bằng id
                    0. Thoát chương trình""");

            int option = inputHandle.inputPositiveInt();
            switch (option) {
                case 1 -> classroomHandle.displayDetail();
                case 2 -> classroomHandle.appendStudent();
                case 3 -> menuEditStudenById();
                case 0 -> System.exit(0);
                default -> System.out.println("Không có option " + option);
            }
            backToMenu();
        }while (true);
    }

    public void menuEditStudenById() {
        System.out.println("Nhập id học sinh cần tìm!");
        int id = inputHandle.inputPositiveInt();
        if(classroomHandle.findStudentById(id) == null) {
            System.out.println("Học sinh không tồn tại!");
        }else{
                System.out.println(classroomHandle.findStudentById(id));
                System.out.println("""
                                Chọn các option:
                                1. Sửa xếp loại của sinh viên
                                2. Xóa sinh viên khỏi lớp học
                                3. Tìm 1 sinh viên với id khác
                                0. Quay về menu chính            
                                """);
                int option = inputHandle.inputPositiveInt();
                switch (option) {
                    case 1 -> classroomHandle.editGradeOfStudent(id);
                    case 2 -> classroomHandle.removeStudent(id);
                    case 3 -> menuEditStudenById();
                    case 0 -> displayMenu();
                    default -> System.out.println("Không có option " + option);
                }
        }
    }
    public void backToMenu() {
        System.out.println("Nhập 0 để quay về menu");
        int back = inputHandle.inputPositiveInt();
        if (back == 0) displayMenu();
        else System.out.println("Bạn nhập sai! Nhập lại đi");
    }
}
