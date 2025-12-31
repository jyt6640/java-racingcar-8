package racingcar.domain;

import java.util.List;
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
}
