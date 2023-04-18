package entity;

import service.IAccount;

public class Account implements IAccount {
    private String name;
    private String accountNumber;
    private String email;
    private double accountBalance;

    public Account(String name, String accountNumber, String email, double accountBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.email = email;
        this.accountBalance = accountBalance;
    }

    //method nạp tiền vào tài khoản (nhận số tiền cần nạp và cập nhật số tài khoản)
    @Override
    public void recharge(double amount) {
        this.accountBalance+= amount;
    }
    //method thay đổi địa chỉ email bằng 1 địa chỉ email mới và cập nhật vào thuộc tính email
    @Override
    public void changeEmail(String email) {
        this.email = email;
    }
    //method hiển thị thông tin tài khoản
    @Override
    public void displayInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Tên tài khoản: " + name + "\n" +
                "Số tài khoản: " + accountNumber + "\n" +
                "Email: " + email + "\n" +
                "Số dư tài khoản: " + accountBalance;
    }
}
