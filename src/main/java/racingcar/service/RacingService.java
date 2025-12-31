package racingcar.service;

import racingcar.domain.Cars;
import racingcar.util.Random;

public class RacingService {

    private final Cars cars;
    private final Random random;

    public RacingService(Cars cars, Random random) {
        this.cars = cars;
        this.random = random;
    }

    public void playRound() {
        cars.moveAll(random);
    }
}
