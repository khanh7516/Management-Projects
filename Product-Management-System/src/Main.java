import handle.ProductHandle;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        ProductHandle productHandle = new ProductHandle();
        Menu menu = new Menu(productHandle);

        productHandle.createListOfProduct();
        menu.displayMenu();
    }
}
