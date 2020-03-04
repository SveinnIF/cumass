package Model;

import java.util.ArrayList;

public interface IUniverseRepository {
    ArrayList<Planet> getAllPlanets(String solarSystemName);
    Planet getPlanet(String solarSystemName, String planetName);
    PlanetSystem getPlanetSystem(String solarSystemName);
    ArrayList<PlanetSystem> getAllPlanetSystems();
}
