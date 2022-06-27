package DefiningClasses._5_DefiningClassesCarSalesman;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engineArr = new ArrayList<>();

        List<Car> carArr = new ArrayList<>();
        int num = Integer.parseInt(scanner.nextLine());
        while (num-- > 0) {
            String[] engineInput = scanner.nextLine().split("\\s+");
            String model = engineInput[0];
            String power = engineInput[1];
            String displacement;
            String efficiency;
            Engine engine = new Engine();
            switch (engineInput.length) {
                case 2:
                    engine = new Engine(model,power);
                    break;
                case 3:
                    displacement = engineInput[2];
                    engine = new Engine(model,power);
                    if(displacement.chars().allMatch(Character::isDigit)){
                        engine.setDisplacement(displacement);
                    }else {
                        engine.setEfficiency(displacement);
                    }
                    break;
                case 4:
                    displacement = engineInput[2];
                    efficiency = engineInput[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    break;
            }
            if(!engineArr.contains(engine)){
                engineArr.add(engine);
            }
        }
        int numCar = Integer.parseInt(scanner.nextLine());
        while (numCar-- > 0) {
            String[] carInput = scanner.nextLine().split("\\s+");

            String model = carInput[0];
            String engineModel = carInput[1];
            String weight = "n/a";
            String color = "n/a";
            Car car = new Car();
            Engine currentEngine = new Engine();
            for (Engine engine : engineArr) {
                if(engine.getModelEngine().equals(engineModel)){
                    currentEngine = engine;
                    break;
                }
            }

            switch (carInput.length) {
                case 2:
                    car = new Car(model,currentEngine);
                    break;
                case 3:
                    color = carInput[2];
                    car = new Car(model,currentEngine);
                    if(color.chars().allMatch(Character::isDigit)){
                        car.setWeight(color);
                    } else {
                        car.setColor(color);
                    }
                    break;
                case 4:
                    weight = carInput[2];
                    color = carInput[3];
                    car = new Car(model, currentEngine, weight, color);
                    break;
            }
            carArr.add(car);
        }

        for (Car car : carArr) {
            System.out.println(car.toString());
        }
    }
}
