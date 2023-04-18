package handle;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHandle {
    private final Scanner scanner = new Scanner(System.in);

    //method kiểm tra tính hợp lệ của email
    public String isEmailFormatted() {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        String email = "";
        while (!pattern.matcher(email).matches()) {
            System.out.println("Nhập đúng định dạng email");
            email = scanner.nextLine();
        }
        return email;
    }
    //method kiểm tra tính hợp lệ của số tài khoản (1 chuỗi gồm 13 số nguyên dương)
    public String isAccountNumberFormatted() {
        String accountNumberRegex = "^[0-9]{13}$";
        Pattern pattern = Pattern.compile(accountNumberRegex);
        String  accountNumber = "";
        while (!pattern.matcher(accountNumber).matches()) {
            System.out.println("Số tài khoản là 1 chuỗi 13 số nguyên dương");
            accountNumber = scanner.nextLine();
        }
        return  accountNumber;
    }
    //method kiểm tra giá trị nhập vào phải là số dương kiểu dữ liệu double
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

    //method kiểm tra giá trị nhập vào phải là số dương kiểu dữ liệu int
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
