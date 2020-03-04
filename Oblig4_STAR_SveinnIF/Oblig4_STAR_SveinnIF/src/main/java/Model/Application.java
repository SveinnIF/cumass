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
        app.get("/planet-systems", new VueComponent("planet-system-overview"));

        UniverseRepository PlanetSystemRepository = new UniverseRepository();
        PlanetSystemController planetController = new PlanetSystemController(PlanetSystemRepository);

        app.get("api/planet-systems/:planet-system-id", planetController::getAllPlanets);
        app.get("/api/planet-systems/", planetController::getAllPlanetSystems);

        app.get("/", ctx -> ctx.result("Hello, world"));

    }
}
