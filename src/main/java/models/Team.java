package models;
import java.util.ArrayList;
import java.util.List;


public class Team {
    private String hackTeamName;
    private String hackTeamDescription;
    private static List<Team> allTeams = new ArrayList<Team>();
    private int hackTeamId;
    private String hackTeamMate1;

    public Team(String teamName, String teamDescription, String teamMate1) {
        hackTeamName = teamName;
        hackTeamDescription = teamDescription;
        allTeams.add(this);
        hackTeamId = allTeams.size();
        hackTeamMate1 = teamMate1;
    }

    public String getTeamName() {
        return hackTeamName;
    }

    public String getTeamDescription() {
        return hackTeamDescription;
    }

    public static List<Team> getAllTeams() {
        return allTeams;
    }

    public int getTeamId() {
        return hackTeamId;
    }

    public static void clearAllTeams() {
       allTeams.clear();
}
    public String getTeamMate1() {
        return hackTeamMate1;
    }
}