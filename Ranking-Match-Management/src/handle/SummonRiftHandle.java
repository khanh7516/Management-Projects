package handle;

import entity.SummonRift;
import entity.Team;
import java.time.LocalDateTime;

public class SummonRiftHandle {
    private final TeamHandle teamHandle = new TeamHandle();
    private final InputHandle inputHandle = new InputHandle();

    public SummonRift startMatch() {
        System.out.println("Nhập thời gian bắt đầu (yyyy-MM-dd HH:mm:ss): ");
        LocalDateTime startTime = inputHandle.dateTimeInput();
        System.out.println("Nhập đội hình team 1: ");
        Team team1 = teamHandle.createTeam();
        System.out.println("Nhập đội hình team 2: ");
        Team team2 = teamHandle.createTeam();

        return new SummonRift(team1, team2, startTime);
    }
}
