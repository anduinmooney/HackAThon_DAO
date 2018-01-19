//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.sun.org.apache.xpath.internal.operations.Mod;
//import models.Team;
//import models.Member;
//import spark.ModelAndView;
//import spark.template.handlebars.HandlebarsTemplateEngine;
//
//
//import javax.print.DocFlavor;
//
//import static spark.Spark.*;
//
//
//public class App {
//    public static void main(String[] args) {
//        staticFileLocation("/public");
//
//        get("teams/new", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "newTeam.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("teams/new/success",(request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            String teamName = request.queryParams("teamName");
//            String description = request.queryParams("teamDescription");
//            String teamMate1 = request.queryParams("teamMate1");
//            String teamMate2 = request.queryParams("teamMate2");
//            String teamMate3 = request.queryParams("teamMate3");
//            String teamMate4 = request.queryParams("teamMate4");
//            String teamMate5 = request.queryParams("teamMate5");
//            Team newTeam = new Team(teamName, description, teamMate1, teamMate2, teamMate3, teamMate4, teamMate5);
//            model.put("newTeam", newTeam);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
//        get("/", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
//        get("/teams/allteams", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            List allTeams = Team.getAllTeams();
//            model.put("allTeams", allTeams);
//            return new ModelAndView(model, "details.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
//        get("/teams/:id/update", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeamToEdit = Integer.parseInt(request.params("id"));
//            Team editTeam = Team.findById(idOfTeamToEdit);
//            model.put("editTeam", editTeam);
//            return new ModelAndView(model, "update.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/teams/:id/update", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            String newTeamName = request.queryParams("teamName");
//            int idOfTeamToEdit = Integer.parseInt(request.params("id"));
//            Team editTeam = Team.findById(idOfTeamToEdit);
//            editTeam.update(newTeamName);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
//
//
//
//    }
//}
