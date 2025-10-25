package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();

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
        } finally {
            Console.close();
        }
    }
}
