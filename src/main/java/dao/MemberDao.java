package dao;

import models.Member;

import java.util.List;

public interface MemberDao {

    //create
    void add(Member team);
//read
    Member findById(int id);

    List<Member> getAll();

    List<Member> getAllMembersByTeam(int teamId);
//update
    void update(int id, String name, String dateOfBirth);
//delete
    void deleteById(int id);
}