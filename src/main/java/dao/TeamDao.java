package dao;

import models.Team;

import java.util.List;

public interface TeamDao {

    //create
    void add (Team team);
    //read
    List<Team> getAll();

    Team findById(int id);
    //update

    //delete
      void clearAllTeams();

    void update(int id, String newTeamName, String newTeamDescription, int memberId);

    void deleteById(int id);

}