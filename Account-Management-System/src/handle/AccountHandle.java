package handle;

import entity.Account;

import java.util.Scanner;

public class AccountHandle {
    private Scanner scanner = new Scanner(System.in);
    private InputHandle inputHandle = new InputHandle();

    //khởi tạo 1 tài khoản bằng cách yêu cầu người dùng nhập vào các thông tin cho thuộc tính của đối tượng có lớp Account
    public Account createAccount() {
        System.out.println("Nhập tên tài khoản: ");
        String name = scanner.nextLine();
        System.out.println("Nhập số tài khoản: ");
        String accountNumber = inputHandle.isAccountNumberFormatted();
        System.out.println("Nhập email: ");
        String email = inputHandle.isEmailFormatted();
        System.out.println("Nhập số dư tài khoản: ");
        double accountBalance = inputHandle.inputPositiveDouble();
        return new Account(name, accountNumber, email, accountBalance);
    }
}
