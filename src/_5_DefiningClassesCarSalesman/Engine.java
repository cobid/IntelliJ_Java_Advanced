package _5_DefiningClassesCarSalesman;

public class Engine {
    //model, power, displacement, and efficiency
    private String modelEngine;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine() {
    }

    public Engine(String modelEngine, String power) {
        this.modelEngine = modelEngine;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String modelEngine, String power, String displacement) {
        this(modelEngine, power);
        this.displacement = displacement;
    }



    public Engine(String modelEngine, String power, String displacement, String efficiency) {
        this(modelEngine, power, displacement);
        this.efficiency = efficiency;
    }

    public String getModelEngine() {
        return modelEngine;
    }

    public void setModelEngine(String modelEngine) {
        this.modelEngine = modelEngine;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
    @Override
    public String toString() {
        return String.format("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%n"
                , this.modelEngine, this.power, this.displacement, this.efficiency);
    }

}
