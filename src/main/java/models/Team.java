package models;
import java.util.ArrayList;
import java.util.List;


public class Team {
    private String hackTeamName;
    private String hackTeamDescription;
    private static List<Team> allTeams = new ArrayList<Team>();

    public Team(String teamName, String teamDescription) {
        hackTeamName = teamName;
        hackTeamDescription = teamDescription;
        allTeams.add(this);
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
}