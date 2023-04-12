package entity;

import java.time.LocalDateTime;

public class SummonRift {
    private Team team1;
    private Team team2;
    private LocalDateTime startTime;

    public SummonRift(Team team1, Team team2, LocalDateTime timeStart) {
        this.team1 = team1;
        this.team2 = team2;
        this.startTime = timeStart;
    }

    @Override
    public String toString() {
        return "SummonRift{" +
                "team1=" + team1 +
                ", team2=" + team2 +
                ", timeStart='" + startTime + '\'' +
                '}';
    }
}
