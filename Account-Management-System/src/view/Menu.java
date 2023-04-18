package view;

import entity.Account;
import handle.AccountHandle;
import handle.InputHandle;

public class Menu {
    private Account account;
    private AccountHandle accountHandle = new AccountHandle();
    private InputHandle inputHandle = new InputHandle();

    public Menu() {
        this.account = accountHandle.createAccount() ;
    }

    //method hiển thị menu chính
    public void displayMenu() {
        while(true) {
            System.out.println("""
                    1. Gửi tiền
                    2. Thay đổi email
                    3. Hiển thị thông tin tài khoản
                    """);

            int option  = inputHandle.inputPositiveInt();
            switch (option) {
                case 1 -> rechargeMenu();
                case 2 -> changeEmailMenu();
                case 3 -> account.displayInfo();
                case 0 -> System.exit(0);
                default -> System.out.println("Không có option " + option);
            }
            backToMenu();
        }
    }


    public void rechargeMenu() {
        System.out.println("Nhập số lượng tiền muốn gửi vào: ");
        double amount = inputHandle.inputPositiveDouble();
        account.recharge(amount);
        System.out.printf("%.2f đã được thêm vào tài khoản!", amount);
    }

    public void changeEmailMenu() {
        System.out.println("Nhập email mới: ");
        String newEmail = inputHandle.isEmailFormatted();
        account.changeEmail(newEmail);
        System.out.println("Thay đổi email thành công!");
    }

    //method quay về menu chính
    public void backToMenu() {
        System.out.println("Nhập 0 để quay về menu");
        int back = inputHandle.inputPositiveInt();
        if (back == 0) displayMenu();
        else System.out.println("Bạn nhập sai! Nhập lại đi");
    }
}





