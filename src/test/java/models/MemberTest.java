package models;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {
//    @Before


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

//    @After
}