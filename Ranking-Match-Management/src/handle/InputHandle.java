package handle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputHandle {
    private final Scanner scanner = new Scanner(System.in);

    public LocalDateTime dateTimeInput() {
        LocalDateTime result = null;
        do {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                result = LocalDateTime.parse(scanner.nextLine(), formatter);
                return result;
            }catch (DateTimeParseException e) {
                System.out.println("Nhập sai định dạng ngày tháng, vui lòng nhập lại!");
            }
        }while (true);
    }
}
