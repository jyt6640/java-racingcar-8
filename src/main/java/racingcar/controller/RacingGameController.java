package racingcar.controller;

import racingcar.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingCar racingCar;

    public RacingGameController() {
        this.racingCar = new RacingCar();
    }

    public void run() {
        try {
            String carInput = InputView.readCar();
            String[] cars = racingCar.createCars(carInput);
            racingCar.initializeCars(cars);

            String attemptInput = InputView.readAttemptCount();
            int attemptCount = Integer.parseInt(attemptInput);

            OutputView.printRunResult();
            racingCar.startRace(attemptCount);

            OutputView.printWinners(racingCar.findWinners());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            throw e;
        }

    }
}
