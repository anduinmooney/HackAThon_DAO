package models;
import java.util.ArrayList;
import java.util.List;


public class Team {
    private String hackTeamName;
    private String hackTeamDescription;

    public Team(String teamName, String teamDescription) {
        hackTeamName = teamName;
        hackTeamDescription = teamDescription;
    }

    public String getTeamName() {
        return hackTeamName;
    }

    public String getTeamDescription() {
        return null;
    }
}