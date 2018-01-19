package models;
import java.util.ArrayList;
import java.util.List;


public class Team {
    private String hackTeamName;
    private String hackTeamDescription;
    private static List<Team> allTeams = new ArrayList<Team>();
    private String hackTeamMate1;
    private String hackTeamMate2;
    private String hackTeamMate3;
    private String hackTeamMate4;
    private String hackTeamMate5;
    public int id;


    public Team(String teamName, String teamDescription, String teamMate1, String teamMate2, String teamMate3, String teamMate4, String teamMate5) {
        hackTeamName = teamName;
        hackTeamDescription = teamDescription;
        allTeams.add(this);
        hackTeamMate1 = teamMate1;
        hackTeamMate2 = teamMate2;
        hackTeamMate3 = teamMate3;
        hackTeamMate4 = teamMate4;
        hackTeamMate5 = teamMate5;
        this.id = allTeams.size();
    }


    public String getTeamName() {
        return hackTeamName;
    }

    public void setTeamName(String hackTeamName) {
        this.hackTeamName = hackTeamName;
    }

    public String getTeamDescription() {
        return hackTeamDescription;
    }

    public void setTeamDescription(String hackTeamDescription) {
        this.hackTeamDescription = hackTeamDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (id != team.id) return false;
        if (hackTeamName != null ? !hackTeamName.equals(team.hackTeamName) : team.hackTeamName != null) return false;
        return hackTeamDescription != null ? hackTeamDescription.equals(team.hackTeamDescription) : team.hackTeamDescription == null;
    }

    @Override
    public int hashCode() {
        int result = hackTeamName != null ? hackTeamName.hashCode() : 0;
        result = 31 * result + (hackTeamDescription != null ? hackTeamDescription.hashCode() : 0);
        result = 31 * result + id;
        return result;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void update(String hackTeamName) {
        this.hackTeamName = hackTeamName;
    }
}