import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xpath.internal.operations.Mod;
import models.Team;
import models.Member;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import javax.print.DocFlavor;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("teams/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newTeam.hbs");
        }, new HandlebarsTemplateEngine());

        post("teams/new/newMember",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String teamName = request.queryParams("name");
            String description = request.queryParams("description");
            Team newTeam = new Team(teamName, description);
            model.put("newTeam", newTeam);
            return new ModelAndView(model, "newMember.hbs");
        }, new HandlebarsTemplateEngine());

        post("teams/new/newMember/next",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String memberName = request.queryParams("name");
            Member newMember = new Member(memberName);
            model.put("newMember", newMember);
            return new ModelAndView(model, "newMember.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/allteams", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List allTeams = Team.getAllTeams();
            model.put("teams", allTeams);
            return new ModelAndView(model, "details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/details/finish", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List teams = Team.getAllTeams();
            model.put("teams", teams);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
