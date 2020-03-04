package Model;


public class Star extends CelestialBody {


    public Star(String name, double mass, double radius, double effectiveTemp) {
        super(name,mass,radius,effectiveTemp);
    }


    @Override
    public String toString() {
        return super.getName() + " har massen " + super.getMass() + " x10^30 kg, en radius på " + super.getRadius() + " km og en temperatur på " + super.getEffectiveTemp() + " millioner grader celcius.";
    }
}
