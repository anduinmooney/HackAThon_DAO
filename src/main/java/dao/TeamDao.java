package dao;

import models.Team;

import java.util.List;

public interface TeamDao {
    //create
    void add(Team team);
//read
    Team findById(int id);

    List<Team> getAll();
//update
    void update(int id, String name, String description);
//delete
    void deleteById(int id);
}