package handle;

import java.util.Scanner;

public class InputHandle {
    private Scanner scanner = new Scanner(System.in);

    public double inputPositiveDouble() {
        double result;
        do {
            try {
                result = Double.parseDouble(scanner.nextLine());

                if(result < 0) throw new IllegalArgumentException("Nhập giá trị không âm");
                return result;
            }catch (NumberFormatException e) {
                System.out.println("Phải nhập một số!\nVui lòng nhập lại!");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\nVui lòng nhập lại!");
            }
        }while (true);
    }

    public int inputPositiveInt() {
        int result;
        do {
            try {
                result = Integer.parseInt(scanner.nextLine());

                if(result < 0) throw new IllegalArgumentException("Nhập giá trị không âm");
                return result;
            }catch (NumberFormatException e) {
                System.out.println("Phải nhập một số!\nVui lòng nhập lại!");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\nVui lòng nhập lại!");
            }
        }while (true);
    }

}
