package dao;

import models.Member;

import java.util.List;

public interface MemberDao {

    //create
    void add(Member member);

    //read
    List<Member> getAll();

    Member findById(int id);

    List<Member> getAllByTeam(int teamId);

    void update(int id, String newHackMemberName, int newHackMemberId);

    //update

    //delete
    void deleteById(int id);

    void clearAllMembers();
}