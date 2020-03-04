package Model;

import io.javalin.http.Context;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlanetSystemController {
    private IUniverseRepository universeRepository;

    public PlanetSystemController(IUniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
    }

    public void getAllPlanets(Context context) {
        String systemId = context.pathParam(":planet-id");
        String sortBy = context.queryParam("sort_by");

        ArrayList<Planet> allPlanets = universeRepository.getAllPlanets(systemId);

        if (sortBy != null) {
            switch (sortBy) {
//                case "planet-system-id":
//                    Collections.sort(allPlanets);
//                    break;
                case "navn":
                    allPlanets.sort(Comparator.comparing(CelestialBody::getName));
                    break;
            }
        }

        context.json(allPlanets);
    }

}
