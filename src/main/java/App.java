
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

        String connectionString = "jdbc:h2:~/standup3.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        Sql2oTeamDao teamDao = new Sql2oTeamDao(sql2o);
        Sql2oMemberDao memberDao = new Sql2oMemberDao(sql2o);


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/teams", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("teams", teamDao.getAll());
            return new ModelAndView(model, "teams.hbs");
        }, new HandlebarsTemplateEngine());



        get("/newTeam", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "newTeam.hbs");
        }, new HandlebarsTemplateEngine());


        post("/newTeam", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Team team = new Team(req.queryParams("name"), req.queryParams("description"));
            teamDao.add(team);
            model.put("team", team);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Team team = teamDao.findById(Integer.parseInt(req.params("id")));
            model.put("team", team);
            return new ModelAndView(model, "updateTeam.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Team team = teamDao.findById(Integer.parseInt(req.params("id")));
            teamDao.update(Integer.parseInt(req.params("id")), req.queryParams("newName"), req.queryParams("newDescription"));
            model.put("team", team);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/newMember", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Team team = teamDao.findById(Integer.parseInt(req.params("id")));
            model.put("team", team);
            return new ModelAndView(model, "newMember.hbs");
        }, new HandlebarsTemplateEngine());

        post("teams/:id/newMember", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int teamId = Integer.parseInt(req.params("id"));
            Team team = teamDao.findById(teamId);
            Member member = new Member(req.queryParams("memberName"), req.queryParams("null"), teamId);
            memberDao.add(member);
            model.put("team", team);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int teamId = Integer.parseInt(req.params("id"));
            model.put("members", memberDao.getAllMembersByTeam(teamId));
            model.put("team", teamDao.findById(teamId));
            return new ModelAndView(model, "members.hbs");
        }, new HandlebarsTemplateEngine());

        get("/member/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Member member = memberDao.findById(Integer.parseInt(req.params("id")));
            model.put("member", member);
            return new ModelAndView(model, "updateMember.hbs");
        }, new HandlebarsTemplateEngine());

        post("/member/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Member member = memberDao.findById(Integer.parseInt(req.params("id")));
            memberDao.update(Integer.parseInt(req.params("id")), req.queryParams("name"), req.queryParams("null"));
            model.put("member", member);
            Team team = teamDao.findById(member.getTeamId());
            model.put("team", team);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/member/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Member member = memberDao.findById(Integer.parseInt(req.params("id")));
            memberDao.deleteById(Integer.parseInt(req.params("id")));
            model.put("member", member);
            Team team = teamDao.findById(member.getTeamId());
            model.put("team", team);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int teamId = Integer.parseInt(req.params("id"));
            List<Member> members = memberDao.getAllMembersByTeam(teamId);
            for (int i = 0; i<members.size(); i++){
                int j = members.get(i).getId();
                memberDao.deleteById(j);
            }
            teamDao.deleteById(teamId);
            Team team = teamDao.findById(teamId);
            model.put("team", team);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}