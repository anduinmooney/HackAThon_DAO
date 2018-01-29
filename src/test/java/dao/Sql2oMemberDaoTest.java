package dao;
import dao.*;
import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;


public class Sql2oMemberDaoTest {
    private Sql2oMemberDao memberDao;
    private Sql2oMemberDao teamDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        memberDao = new Sql2oMemberDao(sql2o);


        conn = sql2o.open();
    }

    @Test
    public void addingMemberSetsId() throws Exception {
        Member member = new Member ("Anduin", 1);
        int originalMemberId = member.getId();
        memberDao.add(member);
        assertNotEquals(originalMemberId, member.getId());
    }

    @Test
    public void existingMembersCanBeFoundById() throws Exception {
        Member member = new Member ("Anduin", 1);
        memberDao.add(member);
        Member foundMember = memberDao.findById(member.getId());
        assertEquals(member, foundMember);
    }

    @Test
    public void addedMembersAreReturnedFromGetAll() throws Exception {
        Member member = setupNewMember();
        memberDao.add(member);
        assertEquals(1, memberDao.getAll().size());
    }

    @Test
    public void updateByIdUpdatesMember() {
        Member member = new Member("Anduin",1);
        memberDao.add(member);
        memberDao.update(1,"Steven", "");
        assertEquals("Steven", memberDao.findById(1).getName());
    }

    @Test
    public void deleteByIdDeletesMember() throws Exception {
        Member member = new Member ("Anduin", 1);
        memberDao.add(member);
        memberDao.deleteById(member.getId());
        assertEquals(0, memberDao.getAll().size());
    }

    public Team setupNewTeam(){
        return new Team("The Mavericks", "We cool");
    }


    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public Member setupNewMember(){
        return new Member("Anduin", 1);
    }
    public Member setupNewMember2(){
        return new Member("Anduin", 2);
    }
}