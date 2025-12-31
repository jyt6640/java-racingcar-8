package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.view.OutputView;
import racingcar.view.handler.InputHandler;

public class RacingController {

    private InputHandler inputHandler;
    private OutputView outputView;

    public RacingController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = inputHandler.getCars();
        int tryCount = inputHandler.getCount();
        outputView.printRunResult();
        String winner = playGame(cars, tryCount);
        outputView.printWinner(winner);
    }

    private String playGame(Cars cars, int tryCount) {
        RacingService racingService = new RacingService(cars);
        for (int i = 0; i < tryCount; i++) {
            outputView.printRaceResult(racingService.playRound());
        }
        return cars.findWinner();
    }
}
