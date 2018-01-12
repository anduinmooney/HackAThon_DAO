package models;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String hackMemberName;
    private static List<Member> allMembers = new ArrayList<Member>();


    public Member(String name) {
        hackMemberName = name;
        allMembers.add(null);
    }

    public String getMemberName() {
        return hackMemberName;
    }

    public static List<Member> getAllMembers() {
        return allMembers;
    }
}
