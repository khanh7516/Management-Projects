package view;

import entity.Employee;
import handle.EmployeeHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private EmployeeHandle employeeHandle;
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        employeeHandle = new EmployeeHandle(employees);
    }
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Nhap lua chon cua ban");
            System.out.println("1 - Xuất danh sách nhân viên");
            System.out.println("2 - Xóa nhân viên theo id");
            System.out.println("3 - Cập nhật thông tin nhân viên theo id");
            System.out.println("4 - Tìm kiếm nhân viên theo lương");
            System.out.println("0 - Thoát chuong trinh");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> displayEmployeeList();
                case 2 -> deleteEmployeeById();
                case 3 -> updateEmployeeById();
                case 4 -> findEmployeeBySalary();
                case 0 -> System.exit(0);
                default -> System.out.println("Option không hợp lệ!");

            }
        } while (true);
    }

    private void displayEmployeeList() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private void deleteEmployeeById() {
        System.out.println("Nhap id nhan vien muon xoa");
        int id = Integer.parseInt(scanner.nextLine());

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("Da xoa nhan vien co id la " + id);
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien co id la " + id);
    }

    private void updateEmployeeById() {
        System.out.println("Cap nhap thong tin nhan vien theo id: ");
        System.out.println("Nhap id nhan vien muon cap nhap");

        int id = Integer.parseInt(scanner.nextLine());

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                Employee updatedEmployee = employeeHandle.createEmployee();
                updatedEmployee.setId(id);
                employees.set(id - 1, updatedEmployee);

                System.out.println("Da cap nhat thong tin nhan vien co id la " + id);
                return;
            }
        }

        System.out.println("Khong tim thay nhan vien co id la " + id);
    }

    private void findEmployeeBySalary() {
        System.out.println("Nhap luong cua nhan vien muon tim");
        double salary = Double.parseDouble(scanner.nextLine());
        boolean foundEmployee = false;

        for (Employee employee : employees) {
            if (employee.getSalary() == salary) {
                System.out.println(employee);
                foundEmployee = true;
            }
        }

        if (!foundEmployee) {
            System.out.println("Khong tim thay nhan vien nao co luong la " + salary);
        }
    }
}
