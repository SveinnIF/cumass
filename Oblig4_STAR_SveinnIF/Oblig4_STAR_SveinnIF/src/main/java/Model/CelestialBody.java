package Model;

public abstract class CelestialBody {
    private String name;
    private double radius,mass,effectiveTemp;
    private static final double Mjup = 1.898E27;
    private static final double Rjup = 71492;
    private static final double Rearth = 6371;
    private static final double Mearth = 5.972E24;
    private static final double Msun = 1.9885E30;
    private static final double Rsun = 695342;
    private static final double oneAU = 149597871;
    private static final double graviConst = 6.674E-11;



    public CelestialBody(String name, double mass, double radius, double effectiveTemp) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
        this.effectiveTemp = effectiveTemp;
    }
    public CelestialBody(String name, double mass, double radius) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }


    public double getRadius() {
        return radius;
    }

    public double getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public double getEffectiveTemp() {
        return effectiveTemp;
    }

    public double getOneAU() {
        return oneAU;
    }

    public double getGraviConst() {
        return graviConst;
    }


    public String getMjup(){
        return mass / Mjup + " Mjup";
    }
    public String getRjup(){
        return radius / Rjup + " Rjup";
    }
    public String getRearth(){
        return radius / Rearth + " Rearth";
    }
    public String getMearth(){
        return mass / Mearth + " Mearth";
    }
    public double getGravity(){
        return  (graviConst * mass)/Math.pow((radius * 1000),2);
    }
    public String getMsun(){
        return mass / Msun + " Msun";
    }
    public String getRsun(){
        return radius / Rsun + " Rsun";
    }

    @Override
    public String toString() {
        return name+" has a mass of "+mass+" and a radius of "+radius+" and a temparature of "+effectiveTemp;
    }
}

