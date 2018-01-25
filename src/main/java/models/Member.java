package models;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String hackMemberName;
    private int hackMemberId;
    private int id;
    private static List<Member> allMembers = new ArrayList<Member>();



    public Member(String name, int hackMemberId) {
        //hackMemberId = allMembers.size();
        this.hackMemberName = name;
        this.hackMemberId = hackMemberId;
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

        if (hackMemberId != member.hackMemberId) return false;
        if (id != member.id) return false;
        return hackMemberName.equals(member.hackMemberName);
    }

    @Override
    public int hashCode() {
        int result = hackMemberName.hashCode();
        result = 31 * result + hackMemberId;
        result = 31 * result + id;
        return result;
    }

    public String getHackMemberName() {
        return hackMemberName;
    }

    public void setHackMemberName(String hackMemberName) {
        this.hackMemberName = hackMemberName;
    }

    public int getHackMemberId() {
        return hackMemberId;
    }

    public void setHackMemberId(int hackMemberId) {
        this.hackMemberId = hackMemberId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<Member> getAllMembers() {
        return allMembers;
    }

    public static void setAllMembers(List<Member> allMembers) {
        Member.allMembers = allMembers;
    }

    public int getMemberId() {
        return id;
    }

//    public static void clearAllMembers() {
//        allMembers.clear();
//    }
}
