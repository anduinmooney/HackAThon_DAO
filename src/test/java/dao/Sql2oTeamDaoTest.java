package dao;

import models.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oTeamDaoTest {

    private Sql2oTeamDao teamDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        teamDao = new Sql2oTeamDao(sql2o);


        conn = sql2o.open();
    }

    @Test
    public void addingCourseSetsId() throws Exception {
        Team team = new Team ("Team 1", "");
        int originalTeamId = team.getId();
        teamDao.add(team);
        assertNotEquals(originalTeamId, team.getId());
    }

    @Test
    public void existingTeamsCanBeFoundById() throws Exception {
        Team team = new Team ("Team 1", "");
        teamDao.add(team);
        Team foundTeam = teamDao.findById(team.getId());
        assertEquals(team, foundTeam);
    }

    @Test
    public void addedTeamsAreReturnedFromgetAll() throws Exception {
        Team team = new Team ("Team 1", "");
        teamDao.add(team);
        assertEquals(1, teamDao.getAll().size());
    }

    @Test
    public void noTeamsReturnsEmptyList() throws Exception {
        assertEquals(0, teamDao.getAll().size());
    }

    @Test
    public void updateByIdUpdatesTeam() {
        Team team = new Team("The Mavericks", "we're cool");
        teamDao.add(team);
        teamDao.update(1, "The Richards", "we're cooler");
        assertEquals("The Richards", teamDao.findById(1).getTeamName());
    }

    @Test
    public void deleteByIdDeletesTeam() throws Exception {
        Team team = new Team ("The Mavericks", "we're cool");
        teamDao.add(team);
        teamDao.deleteById(team.getId());
        assertEquals(0, teamDao.getAll().size());
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

}