package models;
import java.util.ArrayList;
import java.util.List;


public class Team {
    private String hackTeamName;
    private String hackTeamDescription;
    private static List<Team> allTeams = new ArrayList<Team>();
    private int hackTeamId;
    private String hackTeamMate1;
    private String hackTeamMate2;
    private String hackTeamMate3;
    private String hackTeamMate4;
    private String hackTeamMate5;


    public Team(String teamName, String teamDescription, String teamMate1, String teamMate2, String teamMate3, String teamMate4, String teamMate5) {
        hackTeamName = teamName;
        hackTeamDescription = teamDescription;
        allTeams.add(this);
        hackTeamId = allTeams.size();
        hackTeamMate1 = teamMate1;
        hackTeamMate2 = teamMate2;
        hackTeamMate3 = teamMate3;
        hackTeamMate4 = teamMate4;
        hackTeamMate5 = teamMate5;
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

    public String getTeamMate2() {
        return hackTeamMate2;
    }

    public String getTeamMate3() {
        return hackTeamMate3;
    }

    public String getTeamMate4() {
        return hackTeamMate4;
    }

    public String getTeamMate5() {
        return hackTeamMate5;
    }
}