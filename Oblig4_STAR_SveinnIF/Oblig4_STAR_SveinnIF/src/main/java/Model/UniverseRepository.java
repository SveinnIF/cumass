package Model;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class UniverseRepository implements IUniverseRepository {
    private ArrayList<PlanetSystem> planetSystems = new ArrayList<>();

    public UniverseRepository() {
//        Star kepler11 = new Star("Kepler-11",1.889E30,710310,5680,"https://upload.wikimedia.org/wikipedia/commons/6/64/Kepler11.png");
//        ArrayList<Planet> keplerList = new ArrayList<>();
//        keplerList.add(new Planet("Kepler-11b",2.56796E25,12550,1.36134E7,0.045,10,kepler11,"https://asd.gsfc.nasa.gov/blueshift/wp-content/uploads/2015/07/PIA19562-Ceres-DwarfPlanet-Dawn-RC3-image19-20150506.jpg"));
//        keplerList.add(new Planet("Kepler-11c",8.0622E25,20068,1.5857E7,0.026,13,kepler11,"https://asd.gsfc.nasa.gov/blueshift/wp-content/uploads/2015/07/PIA19562-Ceres-DwarfPlanet-Dawn-RC3-image19-20150506.jpg"));
//        keplerList.add(new Planet("Kepler-11d",3.64292E25,21852,2.3786E7,0.004,22,kepler11,"https://asd.gsfc.nasa.gov/blueshift/wp-content/uploads/2015/07/PIA19562-Ceres-DwarfPlanet-Dawn-RC3-image19-20150506.jpg"));
//        keplerList.add(new Planet("Kepler-11e",5.01648E25,28796,2.9021E7,0.012,31,kepler11,"https://asd.gsfc.nasa.gov/blueshift/wp-content/uploads/2015/07/PIA19562-Ceres-DwarfPlanet-Dawn-RC3-image19-20150506.jpg"));
//        keplerList.add(new Planet("Kepler-11f",1.37356E25,16628,3.7399E7,0.013,36,kepler11,"https://asd.gsfc.nasa.gov/blueshift/wp-content/uploads/2015/07/PIA19562-Ceres-DwarfPlanet-Dawn-RC3-image19-20150506.jpg"));
//        keplerList.add(new Planet("Kepler-11g",1.7916E27,23317,6.9114E7,0.015,118,kepler11,"https://asd.gsfc.nasa.gov/blueshift/wp-content/uploads/2015/07/PIA19562-Ceres-DwarfPlanet-Dawn-RC3-image19-20150506.jpg"));




        Star sun = new Star("The Sun",1.9885E30,695342,5777,"https://upload.wikimedia.org/wikipedia/commons/c/c3/Solar_sys8.jpg");
        ArrayList<Planet> planetList = new ArrayList<>();
        planetList.add(new Planet("Mercury", 3.283E23,2439.7, 0.387, 0.206, 88,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Transit_Of_Mercury%2C_May_9th%2C_2016.png/480px-Transit_Of_Mercury%2C_May_9th%2C_2016.png"));
        planetList.add(new Planet("Venus",4.867E24,6051.8, 0.723, 0.007, 225,sun,"https://upload.wikimedia.org/wikipedia/commons/e/e5/Venus-real_color.jpg"));
        planetList.add(new Planet("Earth",5.972E24,6371, 1, 0.017, 365,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/NASA_Earth_America_2002.jpg/480px-NASA_Earth_America_2002.jpg"));
        planetList.add(new Planet("Mars", 6.39E23,3389.5, 1.524, 0.093, 687,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Mars_23_aug_2003_hubble.jpg/480px-Mars_23_aug_2003_hubble.jpg"));
        planetList.add(new Planet("Jupiter",1.898E27,69911, 5.20440, 0.049, 4380,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Jupiter_and_its_shrunken_Great_Red_Spot.jpg/480px-Jupiter_and_its_shrunken_Great_Red_Spot.jpg"));
        planetList.add(new Planet("Saturn", 5.683E26,58232, 9.5826, 0.057, 10585,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Saturn_from_Cassini_Orbiter_-_Square_%282004-10-06%29.jpg/480px-Saturn_from_Cassini_Orbiter_-_Square_%282004-10-06%29.jpg"));
        planetList.add(new Planet("Uranus", 8.681E25,25362, 19.2184, 0.046, 30660,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Uranus2.jpg/480px-Uranus2.jpg"));
        planetList.add(new Planet("Neptune",1.024E26,24622, 30.11, 0.010, 60225,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Neptune_Full_%28cropped%29.jpg/480px-Neptune_Full_%28cropped%29.jpg"));

        PlanetSystem solarSystem = new PlanetSystem("Solar System", sun, planetList,"https://upload.wikimedia.org/wikipedia/commons/c/c3/Solar_sys8.jpg");
        planetSystems.add(solarSystem);
        //planetSystems.put("Solar System", new PlanetSystem("Solar System", sun, planetList));
    }



    @Override
    public ArrayList<Planet> getAllPlanets(String solarSystemName) {
        return getPlanetSystem(solarSystemName).getPlanets();
        //return planetSystems.get(solarSystemName).getPlanets();
    }

    @Override
    public Planet getPlanet(String solarSystemName, String planetName) {
        return getPlanetSystem(solarSystemName).getPlanet(planetName);
        //return planetSystems.get(solarSystemName).getPlanet(planetName);
    }

    @Override
    public PlanetSystem getPlanetSystem(String solarSystemName) {
        for (PlanetSystem planetSystem : planetSystems) {
            if (planetSystem.getName().equals(solarSystemName)) {
                return planetSystem;
            }
        }

        return null;
    }

    @Override
    public ArrayList<PlanetSystem> getAllPlanetSystems() {
        return planetSystems;
    }

    public ArrayList<PlanetSystem> getPlanetSystems() {
        return planetSystems;
    }

    public void setPlanetSystems(ArrayList<PlanetSystem> planetSystems) {
        this.planetSystems = planetSystems;
    }
}
