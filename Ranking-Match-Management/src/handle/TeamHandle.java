package handle;

import entity.Champion;
import entity.Team;

import java.util.ArrayList;

public class TeamHandle {
    private final ChampionHandle championHandle = new ChampionHandle();

    public Team createTeam() {
        ArrayList<Champion> readyTeam = new ArrayList<>();
        int numberChampInTeam = 5;
        for (int i = 0; i < numberChampInTeam; i++) {
            Champion pickedChamp = championHandle.createChampion();
            readyTeam.add(pickedChamp);
        }
        return new Team(readyTeam);
    }
}
