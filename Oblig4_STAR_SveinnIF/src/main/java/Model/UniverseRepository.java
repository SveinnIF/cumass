package Model;



import java.util.ArrayList;


public class UniverseRepository implements IUniverseRepository {




    ArrayList<Planet> planetList = new ArrayList<>();

    public UniverseRepository() {
        Star sun = new Star("The Sun",1.9885E30,695342,5777);

        PlanetSystem solarSystem = new PlanetSystem("Solar System", sun, planetList);


        planetList.add(new Planet("Mercury", 3.283E23, 2439.7, 0.387, 0.206, 88, sun));
        planetList.add(new Planet("Venus", 4.867E24, 6051.8, 0.723, 0.007, 225, sun));
        planetList.add(new Planet("Earth", 5.972E24, 6371, 1, 0.017, 365, sun));
        planetList.add(new Planet("Mars", 6.39E23, 3389.5, 1.524, 0.093, 687, sun));
        planetList.add(new Planet("Jupiter", 1.898E27, 69911, 5.20440, 0.049, 4380, sun));
        planetList.add(new Planet("Saturn", 5.683E26, 58232, 9.5826, 0.057, 10585, sun));
        planetList.add(new Planet("Uranus", 8.681E25, 25362, 19.2184, 0.046, 30660, sun));
        planetList.add(new Planet("Neptune", 1.024E26, 24622, 30.11, 0.010, 60225, sun));


    }


    @Override
    public ArrayList<Planet> getAllPlanets(String solarSystemName) {
        return null;
    }

    @Override
    public Planet getPlanet(String solarSystemName, String planetName) {
        return null;
    }

    @Override
    public PlanetSystem getPlanetSystem(String solarSystemName) {
        return null;
    }


}
