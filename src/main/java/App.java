import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Squad> foundSquad = Squad.getAll();
            model.put("squads",foundSquad);

            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());

        // Squads form
        post("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String squad = request.queryParams("squad");
            String cause = request.queryParams("cause");
            Squad newSquad = new Squad(squad, cause);
            model.put("squad",squad);
            model.put("cause", cause);

            request.session().attribute("squad", squad);
            request.session().attribute("cause", cause);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        // Heroes
        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> foundHero = Hero.getAll();
            model.put("heroes",foundHero);

            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        // Heroes form
        post("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String specialPower = request.queryParams("special-power");
            String weakness = request.queryParams("weakness");

            request.session().attribute("name", name);
            request.session().attribute("age", age);
            request.session().attribute("specialPower", specialPower);
            request.session().attribute("weakness", weakness);

            Hero newHero = new Hero(name, age, specialPower, weakness);

            model.put("name", name);
            model.put("age", age);
            model.put("specialPower", specialPower);
            model.put("weakness", weakness);


            return new ModelAndView(model, "hero-success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/list", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Squad> squads = Squad.getAll();

            model.put("squads", squads);
            return new ModelAndView(model, "allsquads.hbs");
        }, new HandlebarsTemplateEngine());



        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int idOfSquadToFind = Integer.parseInt(request.queryParams("id"));
            System.out.println(idOfSquadToFind);
            Squad foundSquad = Squad.findById(idOfSquadToFind);
            System.out.println(foundSquad.getId());
            model.put("squads",foundSquad);

            return new ModelAndView(model, "squad-detail.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
