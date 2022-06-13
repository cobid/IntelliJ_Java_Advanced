package _4_DefiningClassesRawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> carInfo = new ArrayList<>();

        int num = Integer.parseInt(scanner.nextLine());

        while (num-- > 0) {
            String[] inputInfo = scanner.nextLine().split("\\s+");

            //{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType}
            // {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}

            String carModel = inputInfo[0];

            int speed = Integer.parseInt(inputInfo[1]);
            int power = Integer.parseInt(inputInfo[2]);
            Engine engine = new Engine(speed, power);

            int weight = Integer.parseInt(inputInfo[3]);
            String cargoType = inputInfo[4];
            Cargo cargo = new Cargo(weight, cargoType);

            ArrayList<Tyre> tyres = new ArrayList<>();

            double tyrePressure1 = Double.parseDouble(inputInfo[5]);
            int tyre1Age = Integer.parseInt(inputInfo[6]);
            Tyre tyre1 = new Tyre(tyrePressure1, tyre1Age);
            tyres.add(tyre1);

            double tyrePressure2 = Double.parseDouble(inputInfo[7]);
            int tyre2Age = Integer.parseInt(inputInfo[8]);
            Tyre tyre2 = new Tyre(tyrePressure2, tyre2Age);
            tyres.add(tyre2);

            double tyrePressure3 = Double.parseDouble(inputInfo[9]);
            int tyre3Age = Integer.parseInt(inputInfo[10]);
            Tyre tyre3 = new Tyre(tyrePressure3, tyre3Age);
            tyres.add(tyre3);

            double tyrePressure4 = Double.parseDouble(inputInfo[11]);
            int tyre4Age = Integer.parseInt(inputInfo[12]);
            Tyre tyre4 = new Tyre(tyrePressure4, tyre4Age);
            tyres.add(tyre4);

            Car car = new Car(carModel, engine, cargo, tyres);


            carInfo.add(car);
        }
        String input = scanner.nextLine();
        if (input.equals("fragile")) {
            carInfo.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("fragile"))
                    .filter(car -> car.getTyres().stream().anyMatch(tyre -> tyre.getPressure() < 1))
                    .forEach(car -> System.out.println(car.getModel()));
        } else if (input.equals("flamable")) {
            carInfo.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }

    }
}
