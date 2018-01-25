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


        get("/newMember", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Team> allTeams = teamDao.getAll();
            model.put("teams", allTeams);

            return new ModelAndView(model, "newMember.hbs");
        }, new HandlebarsTemplateEngine());


        post("/newMember", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String memberName = request.queryParams("memberName");
            Member newMember = new Member(memberName, 1 ); //ignore the hardcoded categoryId
            memberDao.add(newMember);
            model.put("member", newMember);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());




            //            List<Team> allTeams = teamDao.getAll();
//            model.put("teams", allTeams);
//            String memberName = request.queryParams("memberName");
//            int newMemberId = Integer.parseInt(request.queryParams("hackMemberId"));
//            Member newMember = new Member(memberName, newMemberId);
//            memberDao.add(newMember);
//            model.put("name", newMember);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());








//        get("/newMember", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            Team team = teamDao.findById(Integer.parseInt(request.params("id")));
//            model.put("team", team);
//            return new ModelAndView(model, "newMember.hbs");
//        }, new HandlebarsTemplateEngine());

//        post("/newMember", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            String memberName = request.queryParams("hackMemberName");
//            int teamId = Integer.parseInt(request.params("hackTeamId"));
//            Team team = teamDao.findById(teamId);
//            Member member = new Member(memberName, teamId);
//            memberDao.add(member);
//            model.put("team", team);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());

    }
}
