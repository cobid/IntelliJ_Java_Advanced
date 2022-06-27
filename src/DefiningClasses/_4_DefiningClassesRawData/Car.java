package DefiningClasses._4_DefiningClassesRawData;

import java.util.ArrayList;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private ArrayList<Tyre> tyres = new ArrayList<>();

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public Car(String model, Engine engine, Cargo cargo, ArrayList<Tyre> tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public ArrayList<Tyre> getTyres() {
        return tyres;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setTyres(ArrayList<Tyre> tyres) {
        this.tyres = tyres;
    }
    @Override
    public String toString() {
        return String.format("%s", this.model);
    }
}
