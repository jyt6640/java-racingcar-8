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
}
