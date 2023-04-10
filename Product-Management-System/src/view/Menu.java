package view;

import handle.InputHandle;
import handle.ProductHandle;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    InputHandle inputHandle = new InputHandle();
    ProductHandle productHandle;
    //hàm khởi tạo Menu truyền vào tham số productHandle đã được khởi tạo tử trước
    public Menu(ProductHandle productHandle) {
        this.productHandle = productHandle;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("-".repeat(50));
            System.out.println("""
                    Mời chọn các option dưới đây:
                    1. Xem danh sách sản phẩm
                    2. Tìm sản phẩm theo tên
                    3. Tìm sản phẩm theo ID
                    4. Tìm sản phẩm theo số lượng ... trở xuống
                    5. Tìm sản phẩm theo mức giá
                    6. Sắp xếp sản phẩm theo mức giá giảm dần/ tăng dần
                    0. Thoát khỏi chương trình
                                                
                    """);
            int option = inputHandle.inputPositiveInt();
            switch (option) {
                case 1 -> productHandle.displayProducts();
                case 2 -> System.out.println(productHandle.findProductByName());
                case 3 -> menuSetQuantityById();
                case 4 -> productHandle.findProductByLowQuantity();
                case 5 -> menuSelectByPrice();
                case 6 -> menuSortByPrice();
                case 0-> {
                    System.out.println("Thoát chương trình...");
                    System.exit(0);
                }
                default -> System.out.println("Không có option " +option);
            }
            backToMenu();//nếu không có method này,
                        // menu sẽ hiện thị ngay khi 1 trong các option được thực hiện
                       //buộc người xem phải kéo lên trên để xem kết quả
        }
    }
    //các method hiển thị các menu con đối với 1 vài option
    public void menuSetQuantityById() {
        System.out.println("Nhập id sản phẩm cần tìm!");
        int id = inputHandle.inputPositiveInt();
        if (productHandle.findProductById(id) == null) {
            System.out.println("Sản phẩm không tồn tại");
        }else {
            System.out.println(productHandle.findProductById(id));
            System.out.println("Bạn có muốn thay đổi số lượng sản phẩm có id: "+ id);
            System.out.println("""
                            1. Tôi muốn thay đổi số lượng sản phẩm
                            2. Tìm 1 sản phẩm với id khác
                            0. Quay về menu""");
            int option = inputHandle.inputPositiveInt();
            switch (option) {
                case 1 -> productHandle.updateQuantityById(id);
                case 2 -> menuSetQuantityById();
                case 0 -> displayMenu();
                default -> System.out.println("Không có option " + option);
            }
        }
    }

    public void menuSelectByPrice(){
        System.out.println("Bạn muốn tìm sản phẩm theo mức giá nào?\nChọn 3 option dưới đây:");
        System.out.println("""
                            1. Dưới 50.000
                            2. Từ 50.000 đến dưới 100.000
                            3. Từ 100.000 trở lên
                            0. Quay về menu""");
        int option = inputHandle.inputPositiveInt();
        switch (option) {
            case 1, 2, 3 -> productHandle.filterByPrice(option);
            case 0 -> displayMenu();
            default -> System.out.println("Không có option " + option);
        }
    }

    public void menuSortByPrice(){
        System.out.println("Bạn muốn sắp xếp sản phẩm theo mức giá: ");
        System.out.println("""
                            1. Tăng dần
                            2. Giảm dần
                            0. Quay về menu""");
        int option = inputHandle.inputPositiveInt();
        switch (option) {
            case 1 -> productHandle.sortByPriceAsce();
            case 2 -> productHandle.sortByPriceDesc();
            case 0 -> displayMenu();
            default -> System.out.println("Không có option " + option);
        }
    }
    //method quay về menu chính
    public void backToMenu() {
        System.out.println("Nhập 0 để quay về menu");
        int back = inputHandle.inputPositiveInt();
        if (back == 0) displayMenu();
        else System.out.println("Bạn nhập sai! Nhập lại đi");
    }
}
