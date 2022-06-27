package DefiningClasses._3_DefiningClassesSpeedRacing;

public class Car {
    private String carModel;
    private double fuelVolume;
    private double fuelCostPerKm;
    private int amountOfKm;

    public Car(String carModel, double fuelVolume, double fuelCostPerKm) {
        this.carModel = carModel;
        this.fuelVolume = fuelVolume;
        this.fuelCostPerKm = fuelCostPerKm;
        this.amountOfKm = 0;
    }

    public int getAmountOfKm() {
        return amountOfKm;
    }

    public void setAmountOfKm(int amountOfKm) {
        this.amountOfKm = amountOfKm;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public void setFuelCostPerKm(double fuelCostPerKm) {
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public String getCarModel() {
        return carModel;
    }

    public void carConsume(int amountOfKm) {
        if(this.fuelCostPerKm * amountOfKm <=  this.fuelVolume) {
            this.setFuelVolume(this.fuelVolume - (this.fuelCostPerKm * amountOfKm));
            this.setAmountOfKm(this.amountOfKm + amountOfKm);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.carModel, this.fuelVolume, this.amountOfKm);
    }

}
