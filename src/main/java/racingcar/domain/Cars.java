package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.Random;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public void moveAll(Random random) {
        for (Car car : cars) {
            int randomValue = random.random();
            if (randomValue >= 5) {
                car.movingForward();
            }
        }
    }

    public String roundResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        return result.toString();
    }

    public String findWinner() {
        for (Car car : cars) {

        }

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition())
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
