package models;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String hackMemberName;
    private int hackMemberId;
    private int id;
    private static List<Member> allMembers = new ArrayList<Member>();



    public Member(String name) {
        hackMemberId = allMembers.size();
        hackMemberName = name;
        allMembers.add(this);
    }

    public String getMemberName() {
        return hackMemberName;
    }

    public static List<Member> getAllMembers() {
        return allMembers;
    }

    public int getMemberId() {
        return hackMemberId;
    }

    public static void clearAllMembers() {
        allMembers.clear();
    }
}
