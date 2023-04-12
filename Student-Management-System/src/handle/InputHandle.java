package handle;

import java.util.Scanner;

public class InputHandle {
    private final Scanner scanner = new Scanner(System.in);

    public int inputPositiveInt() {
        int result;
        do {
            try {
                result = Integer.parseInt(scanner.nextLine());

                if(result < 0 || result > 90) throw new IllegalArgumentException("Nhập đúng tuổi của bạn!");
                return result;
            }catch (NumberFormatException e) {
                System.out.println("Phải nhập một số!\nVui lòng nhập lại!");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\nVui lòng nhập lại!");
            }
        }while (true);
    }

    public String inputGrade() {
        do {
            System.out.println("""
                                1. Xuất sắc
                                2. Giỏi
                                3. Trung bình
                                4. Yếu""");
            int choice = inputPositiveInt();
            switch (choice) {
                case 1 -> { return "EXCELLENT"; }
                case 2 -> { return "GOOD"; }
                case 3 -> { return "AVERAGE"; }
                case 4 -> { return "POOR"; }
                default -> System.out.println("Không có option " + choice +"\nNhập lại:");
            }
        }while (true);
    }
}
