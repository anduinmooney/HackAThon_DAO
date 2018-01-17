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

        post("teams/new/success",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String teamName = request.queryParams("teamName");
            String description = request.queryParams("teamDescription");
            String teamMate1 = request.queryParams("teamMate1");
            Team newTeam = new Team(teamName, description, teamMate1);
            model.put("newTeam", newTeam);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/teams/allteams", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List allTeams = Team.getAllTeams();
            model.put("allTeams", allTeams);
            return new ModelAndView(model, "details.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
