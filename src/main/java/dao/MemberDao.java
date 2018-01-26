package dao;

import models.Member;

import java.util.List;

public interface MemberDao {

    //create
    void add(Member member);

    //read
    List<Member> getAll();

    Member findById(int id);



    void update(int id, String newHackMemberName, int newHackMemberId);

    //update

    //delete
    void deleteById(int id);

    void clearAllMembers();
}