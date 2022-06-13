package _4_DefiningClassesRawData;

public class Tyre {
    private double pressure;
    private int age;

    public Tyre(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }

    public int getAge() {
        return age;
    }
}
