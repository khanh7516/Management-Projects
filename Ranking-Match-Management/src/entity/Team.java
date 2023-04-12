package entity;

import java.util.ArrayList;

public class Team {
    private ArrayList<Champion> champions;

    public Team(ArrayList<Champion> champions) {
        this.champions = champions;
    }

    public void addChampion(Champion champion) {
        champions.add(champion);
    }

    public ArrayList<Champion> getChampions() {
        return champions;
    }

    @Override
    public String toString() {
        return "{" +
                "champions=" + champions +
                '}';
    }
}