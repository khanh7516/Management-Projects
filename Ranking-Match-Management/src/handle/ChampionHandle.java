package handle;

import entity.Champion;

import java.util.Scanner;

public class ChampionHandle {
    private final Scanner scanner = new Scanner(System.in);

    public Champion createChampion() {
        System.out.println("Nhập tên champion");
        String name = scanner.nextLine();
        System.out.println("Nhập vị trí champion");
        String position = scanner.nextLine();
        return new Champion(name, position);
    }
}
