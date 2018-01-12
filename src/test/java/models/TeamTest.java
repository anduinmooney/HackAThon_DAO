package models;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {
    @Before
    public void tearDown() {
        Team.clearAllTeams();
    }

    @Test
    public void team_instantiatesCorrectly_true() {
        Team testTeam = new Team("Anduin's Team", "Anduin's Team Description");
        assertEquals(true, testTeam instanceof Team);
    }

    @Test
    public void team_getTeamName_true() {
        Team testTeam = new Team("Anduin's Team", "Anduin's Team Description");
        assertEquals("Anduin's Team", testTeam.getTeamName());
    }

    @Test
    public void team_getTeamDescription_true() {
        Team testTeam = new Team("Anduin's Team", "Anduin's Team Description");
        assertEquals("Anduin's Team Description", testTeam.getTeamDescription());
    }

    @Test
    public void team_getAllTeams_true() {
        Team testTeam = new Team("Anduin's Team", "Anduin's Team Description");
        Team testTeam2 = new Team("Jimmy's Team", "Jimmy's Team Description");
        assertEquals(true, Team.getAllTeams().contains(testTeam));
        assertEquals(true, Team.getAllTeams().contains(testTeam2));
    }

    @Test
    public void team_getTeamId_1() {
        Team testTeam = new Team("Anduin's Team", "Anduin's Team Description");
        assertEquals(1, testTeam.getTeamId());
    }

    @Test
    public void team_getTeamId_3 () {
        Team testTeam = new Team("Anduin's Team", "Anduin's Team Description");
        Team testTeam2 = new Team("Jimmy's Team", "Jimmy's Team Description");
        Team testTeam3 = new Team("Gabe's Team", "Gabe's Team Description");
        assertEquals(3, testTeam3.getTeamId());
    }



//    @After
}