package Model;

public class Planet extends NaturalSatellite {

    public Planet(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, String pictureUrl) {
        super(name, mass, radius, semiMajorAxis, eccentricity, orbitalPeriod, pictureUrl);
    }


    @Override
    public String toString() {
        return "\n" + super.getName() + ": has a mass of: " + super.getMass() + " kg, and a radius of: " + super.getRadius() + "km";
    }
}
