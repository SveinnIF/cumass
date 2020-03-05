package Model;

public abstract class NaturalSatellite extends CelestialBody {
    private double semiMajorAxis, orbitalPeriod, eccentricity;
    Star centralCelestialBody;


    public NaturalSatellite(String name, double mass, double radius, double semiMajorAxis, double eccentricity, double orbitalPeriod,Star centralCelestialBody, String pictureUrl) {
        super(name, mass, radius, pictureUrl);
        this.semiMajorAxis = semiMajorAxis;
        this.orbitalPeriod = orbitalPeriod;
        this.eccentricity = eccentricity;
        this.centralCelestialBody = centralCelestialBody;
    }


    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public void setEccentricity(double eccentricity) {
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

    public CelestialBody getCentralCelestialBody() {
        return centralCelestialBody;
    }

    public double distanceToCentralBody(double degrees, String unit) {
        double phi = degrees;
        if (unit.equals("deg")) {
            phi = Math.toRadians(degrees);
        }
        return ((semiMajorAxis * (1 - Math.pow(eccentricity, 2))) / (1 + (eccentricity * Math.cos(phi)))) * super.getOneAU();
    }


    public double orbitingVelocity(double degrees, String unit) {
        int multiplier = 1;
        if (unit.equals("km")) {
            multiplier = 1000;
        }
        return (Math.sqrt((super.getGraviConst() * centralCelestialBody.getMass()) / (super.getRadius() + distanceToCentralBody(degrees, "deg") * 1000)) / multiplier);
    }//can do Math.round() or one of the other rounding features in java but i could not find one that gave the result i wanted

    @Override
    public String toString() {
        return super.getName() + " orbits around " + centralCelestialBody + " and has a mass of" + super.getMass() +
                " and a radius of " + super.getRadius() + " a Semi Major Axis of " + semiMajorAxis + " a eccentricity of " + eccentricity + " and a orbital period of" + orbitalPeriod;
    }
}


