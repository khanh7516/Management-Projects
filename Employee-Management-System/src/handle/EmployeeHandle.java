package handle;

import entity.Employee;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeHandle {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Employee> employees;

    public EmployeeHandle(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    /*nhap danh sach nhan vien*/
    public Employee createEmployee(){
        System.out.println("Nhap ten nhan vien");
        String name = scanner.nextLine();
        System.out.println("Nhap vi tri");
        String potition = scanner.nextLine();
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPotition(potition);
        return employee;
    }

    public void createEmployeeList() {
        System.out.println("Nhap so nhan vien");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            Employee employee = createEmployee();
            checkSalary(employee);
            employees.add(employee);
        }
    }
    /*   kiem tra luong theo tung vi tri*/
    public void checkSalary(Employee employee){
        double tax=0;
        if(Objects.equals(employee.getPotition(), "administrative staff")){
            double salary = 5000;
            employee.setSalary(salary);
            employee.setTax(tax);
        }
        if(Objects.equals(employee.getPotition(), "manager")){
            System.out.println("Nhap so nhan vien duoi quyen");
            int n = Integer.parseInt(scanner.nextLine());
            double salary = 5000 + 1000*n;
            employee.setSalary(salary);
            if(salary>=11000){
                tax = (salary-11000)*10/100;
                employee.setTax(tax);
            }
            else{
                employee.setTax(tax);
            }
        }
        if(Objects.equals(employee.getPotition(), "marketing staff")){
            System.out.println("Nhap doanh so ban hang");
            int n = Integer.parseInt(scanner.nextLine());
            double salary = 2000 + 200*n;
            employee.setSalary(salary);
            if(salary>=11000){
                tax = (salary-11000)*10/100;
                employee.setTax(tax);
            }
            else{
                employee.setTax(tax);
            }
        }
    }
}
