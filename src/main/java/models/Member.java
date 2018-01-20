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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (id != member.id) return false;
        if (hackMemberName != null ? !hackMemberName.equals(member.hackMemberName) : member.hackMemberName != null) return false;
        return allMembers != null ? allMembers.equals(member.allMembers) : member.allMembers == null;
    }

    @Override
    public int hashCode() {
        int result = hackMemberName != null ? hackMemberName.hashCode() : 0;
        result = 31 * result + (allMembers != null ? allMembers.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }



    public int getMemberId() {
        return id;
    }

    public static void clearAllMembers() {
        allMembers.clear();
    }
}
