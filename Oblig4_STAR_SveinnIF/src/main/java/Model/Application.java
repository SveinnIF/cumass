package Model;

import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import org.jetbrains.annotations.NotNull;

import javax.naming.Context;
import java.util.logging.Handler;


public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        app.get("/planet-systems/:planet-system-id", new VueComponent("Planet-detail"));


        UniverseRepository PlanetSystemRepository = new UniverseRepository();
        PlanetSystemController planetController = new PlanetSystemController(PlanetSystemRepository);

        // API
        app.get("api/planet-systems/:planet-system-id", planetController::getAllPlanets);

        app.get("/", ctx -> ctx.result("Hello, world"));

    }
}
