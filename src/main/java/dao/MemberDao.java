package dao;

import models.Member;

import java.util.List;

public interface MemberDao {

    //create
    void add (Member member);

    //read
    List<Member> getAll();
    List<Member> getAllMembersByTeam(int teamId);

    Member findById(int id);

    //update
//    void update(int id, String name);

    //delete
//    void deleteById(int id);
//    void clearAllCategories();

}