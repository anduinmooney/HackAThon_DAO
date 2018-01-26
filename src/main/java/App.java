import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xpath.internal.operations.Mod;
import dao.MemberDao;
import dao.Sql2oMemberDao;
import dao.Sql2oTeamDao;
import models.Team;
import models.Member;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import javax.print.DocFlavor;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/todolist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oTeamDao teamDao = new Sql2oTeamDao(sql2o);
        Sql2oMemberDao memberDao = new Sql2oMemberDao(sql2o);


        //TEAM CRUD
        get("/teams/deleteAll", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            teamDao.clearAllTeams();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("teams/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newTeam.hbs");
        }, new HandlebarsTemplateEngine());

        post("teams/new/success",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String teamName = request.queryParams("teamName");
            String description = request.queryParams("teamDescription");
            Team newTeam = new Team(teamName, description);
            teamDao.add(newTeam);
            model.put("newTeam", newTeam);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/allteams", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List allTeams = teamDao.getAll();
            model.put("allTeams", allTeams);
            List allMembers = memberDao.getAll();
            model.put("allMembers", allMembers);
            return new ModelAndView(model, "details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToEdit = Integer.parseInt(request.params("id"));
            Team editTeam = teamDao.findById(idOfTeamToEdit);
            model.put("editTeam", editTeam);
            return new ModelAndView(model, "update.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String newTeamName = request.queryParams("teamName");
            String newTeamDescription = request.queryParams("teamDescription");
            int idOfTeamToEdit = Integer.parseInt(request.params("id"));
            Team editTeam = teamDao.findById(idOfTeamToEdit);
            teamDao.update(idOfTeamToEdit, newTeamName, newTeamDescription);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int teamId = Integer.parseInt(req.params("id"));
            teamDao.deleteById(teamId);
            Team team = teamDao.findById(teamId);
            model.put("team", team);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //MEMBERS CRUD



        get("/teams/:id/members", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToAddMember = Integer.parseInt(request.params("id"));
            Team addMember = teamDao.findById(idOfTeamToAddMember);
            model.put("addMember", addMember);
            return new ModelAndView(model, "newMember.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/members", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int teamId = Integer.parseInt(req.params("id"));
            Team team = teamDao.findById(teamId);
            String hackMemberName = req.queryParams("hackMemberName");
            Member member = new Member(hackMemberName, teamId);
            memberDao.add(member);
            model.put("team", team);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/members/deleteall", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Team> allTeams = teamDao.getAll();
            model.put("team", allTeams);

            memberDao.clearAllMembers();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
