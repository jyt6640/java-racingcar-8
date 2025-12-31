package racingcar.service;

import racingcar.domain.Cars;
import racingcar.util.Random;
import racingcar.util.RandomNumberGenerator;

public class RacingService {

    private final Cars cars;
    private final Random random;

    public RacingService(Cars cars) {
        this.cars = cars;
        this.random = new RandomNumberGenerator();
    }

    public String playRound() {
        cars.moveAll(random);
        return cars.roundResult();
    }
}
