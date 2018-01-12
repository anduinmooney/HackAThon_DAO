package models;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {
    @Before
    public void tearDown() {
        Member.clearAllMembers();
    }


    @Test
    public void member_instantiatesCorrectly_true() {
        Member testMember = new Member("Anduin");
        assertEquals(true, testMember instanceof Member);
    }

    @Test
    public void member_getMemberName_true() {
        Member testMember = new Member("Anduin");
        assertEquals("Anduin", testMember.getMemberName());
    }

    @Test
    public void member_getAllMembers_true() {
        Member testMember = new Member("Anduin");
        Member testMember2 = new Member("Jimmy");
        assertEquals(true, Member.getAllMembers().contains(testMember));
        assertEquals(true, Member.getAllMembers().contains(testMember2));
    }

    @Test
    public void member_getMemberId_true() {  //For some reason, expected starts here at 0, whilst the team array starts at 1.
        Member testMember = new Member("Anduin");
        Member testMember2 = new Member("Jimmy");
        Member testMember3 = new Member("Timmy");
        assertEquals(2, testMember3.getMemberId());
    }

//    @After
}