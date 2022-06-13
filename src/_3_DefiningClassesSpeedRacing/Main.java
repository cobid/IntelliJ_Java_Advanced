package _3_DefiningClassesSpeedRacing;
import java.util.*;
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Car> carInfo = new ArrayList<>();
        Car car = null;
        while (n-- > 0) {
            String[] info = scanner.nextLine().split("\\s+");
            String carModel = info[0];
            int fuelVolume = Integer.parseInt(info[1]);
            double fuelCostPerKm = Double.parseDouble(info[2]);
            car = new Car(carModel, fuelVolume, fuelCostPerKm);
            carInfo.add(car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");
            String drivingCar = commands[1];
            int amountOfKm = Integer.parseInt(commands[2]);

            carInfo.stream().filter(currentCar -> currentCar.getCarModel().equals(drivingCar))
                    .forEach(currentCar -> currentCar.carConsume(amountOfKm));

            input = scanner.nextLine();
        }

        carInfo.stream().forEach(System.out::println);

    }
}
