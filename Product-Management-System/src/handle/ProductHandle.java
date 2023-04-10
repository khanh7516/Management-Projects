package handle;

import entity.Product;
import java.util.Scanner;

public class ProductHandle {
    private Product[]  productList;
    private final Scanner scanner = new Scanner(System.in);
    private final InputHandle inputHandle = new InputHandle();

    public Product[] getProductList() {
        return productList;
    }

    public Product createProduct(int i) {
        System.out.println("Nhập tên sản phẩm thứ: " + (i));
        String name = scanner.nextLine();
        System.out.println("Nhập mô tả sản phẩm thứ: " + (i));
        String description = scanner.nextLine();
        System.out.println("Nhập số lượng sản phẩm thứ: " + (i));
        int quantity = inputHandle.inputPositiveInt();
        System.out.println("Nhập giá bán của sản phẩm thứ: " + (i));
        double price = inputHandle.inputPositiveDouble();
        System.out.println("Nhập đơn vị tính của sản phẩm thứ: " + (i));
        String unit = scanner.nextLine();

        return new Product(name, description, quantity, price, unit);
    }

    public void createListOfProduct() {
        System.out.println("Hãy tạo 1 danh sách sản phẩm!\nNhập số lượng sản phẩm: ");
        int number = inputHandle.inputPositiveInt();
        productList = new Product[number];
        for (int i = 0; i < number; i++ ) {
            productList[i] = createProduct(i + 1);
        }
    }
    public void displayProducts() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public Product findProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) return product;
        }
        return null; // Không tìm thấy sản phẩm có id trùng với id đầu vào
    }

    public void updateQuantityById(int id) {
        Product updateProduct = findProductById(id);
        System.out.println(updateProduct);
        System.out.println("Nhập số lượng mới bạn muốn cập nhật!");
        updateProduct.setQuantity(inputHandle.inputPositiveInt());
        System.out.println("Cập nhật số lượng thành công!\n" + updateProduct);
    }
    public String findProductByName() {
        boolean check = false;
        System.out.println("Tên sản phẩm: ");
        String name = scanner.nextLine();
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product);
                check = true;
            }
        }return (!check)?"Không tìm thấy sản phảm có tên: " + name : "Đây là những sản phầm đã được tìm thấy ";
    }

    public void findProductByLowQuantity() {
        System.out.println("Nhập số lượng sản phẩm: ");
        int quantity = inputHandle.inputPositiveInt();
        boolean found = false;
        for (Product product : productList) {
            if (product.getQuantity() < quantity) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có sản phẩm nào có số lượng dưới " + quantity);
        }
    }

    public void filterByPrice(int option){
        for (Product product: productList) {
            if(product.getPrice()<50000 && option==1) System.out.println(product);
            else if(product.getPrice() < 100000 && option == 2) System.out.println(product);
            else if(product.getPrice() > 100000 && option == 3) System.out.println(product);
        }
    }

    public void sortByPriceAsce() {
        int n = productList.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (productList[j].getPrice() > productList[j + 1].getPrice()) {
                    // Hoán đổi hai phần tử
                    Product temp = productList[j];
                    productList[j] = productList[j + 1];
                    productList[j + 1] = temp;
                }
            }
        }
        // In ra mảng đã sắp xếp tăng dần
        System.out.println("Danh sách sản phẩm theo thứ tự giá tăng dần:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void sortByPriceDesc() {
        int n = productList.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (productList[j].getPrice() < productList[j + 1].getPrice()) {
                    // Hoán đổi hai phần tử
                    Product temp = productList[j];
                    productList[j] = productList[j + 1];
                    productList[j + 1] = temp;
                }
            }
        }
        // In ra mảng đã sắp xếp giảm dần
        System.out.println("Danh sách sản phẩm theo thứ tự giá giảm dần:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
