package models;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {
//    @Before

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




//    @After
}