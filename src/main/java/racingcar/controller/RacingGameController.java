package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.parser.InputParser;
import racingcar.service.RacingGameService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputParser inputParser;
    private final RacingGameService gameService;
    private final InputValidator inputValidator;

    public RacingGameController() {
        this.inputParser = new InputParser();
        this.gameService = new RacingGameService();
        this.inputValidator = new InputValidator();
    }

    public void run() {
        try {
            String carInput = InputView.readCar();
            List<String> carNames = inputParser.parseCars(carInput);
            Cars cars = new Cars(carNames);
            gameService.initializeCars(cars);
            
            String attemptInput = InputView.readAttemptCount();
            int attemptCount = inputValidator.validateAttemptCount(attemptInput);
            
            OutputView.printRunResult();
            playGame(attemptCount);
            
            OutputView.printWinners(gameService.findWinners());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            throw e;
        }
    }

    private void playGame(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            gameService.playRound();
            OutputView.printRaceResult(gameService.getRoundResult());
        }
    }
}
