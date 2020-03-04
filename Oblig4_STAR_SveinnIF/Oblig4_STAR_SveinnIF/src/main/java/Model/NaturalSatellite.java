package Model;

public abstract class NaturalSatellite extends CelestialBody {
    private double semiMajorAxis, orbitalPeriod, eccentricity;


    public NaturalSatellite(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod, String pictureUrl) {
        super(name, mass, radius);
        this.semiMajorAxis = semiMajorAxis;
        this.orbitalPeriod = orbitalPeriod;
        this.eccentricity = eccentricity;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public double getEccentricity() {
        return eccentricity;
    }

//    public CelestialBody getCentralCelestialBody() {
//        return centralCelestialBody;
//    }

    public double distanceToCentralBody(double degrees, String unit) {
        double phi = degrees;
        if (unit.equals("deg")) {
            phi = Math.toRadians(degrees);
        }
        return ((semiMajorAxis * (1 - Math.pow(eccentricity, 2))) / (1 + (eccentricity * Math.cos(phi)))) * super.getOneAU();
    }
//                                                                              since we are not supposed to have centralCelestialBody anymore none of this code works, im not fixing it because that is useless
//
//    public double orbitingVelocity(double degrees, String unit) {
//        int multiplier = 1;
//        if (unit.equals("km")) {
//            multiplier = 1000;
//        }
//        return (Math.sqrt((super.getGraviConst() * centralCelestialBody.getMass()) / (super.getRadius() + distanceToCentralBody(degrees, "deg") * 1000)) / multiplier);
//    }//can do Math.round() or one of the other rounding features in java but i could not find one that gave the result i wanted
//
//    @Override
//    public String toString() {
//        return super.getName() + " orbits around " + centralCelestialBody + " and has a mass of" + super.getMass() +
//                " and a radius of " + super.getRadius() + " a Semi Major Axis of " + semiMajorAxis + " a eccentricity of " + eccentricity + " and a orbital period of" + orbitalPeriod;
//    }
}


