package handle;

import entity.SummonRift;
import entity.Team;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SummonRiftHandle {
    private final Scanner scanner = new Scanner(System.in);
    private final TeamHandle teamHandle = new TeamHandle();

    public SummonRift startMatch() {
        System.out.println("Nhập thời gian bắt đầu (yyyy-MM-dd HH:mm:ss): ");
        LocalDateTime startTime = dateTimeInput();
        System.out.println("Nhập đội hình team 1: ");
        Team team1 = teamHandle.createTeam();
        System.out.println("Nhập đội hình team 2: ");
        Team team2 = teamHandle.createTeam();

        return new SummonRift(team1, team2, startTime);
    }

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
