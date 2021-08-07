import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String squad = request.queryParams("squad");
            String cause = request.queryParams("cause");
            request.session().attribute("squad", squad);
            request.session().attribute("cause", cause);
            model.put("squad", squad);
            model.put("cause", cause);
            return new ModelAndView(model, "success.hbs");
        });
    }
}
