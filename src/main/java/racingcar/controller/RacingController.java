package racingcar.controller;

import java.util.List;
import racingcar.view.handler.InputHandler;

public class RacingController {

    private InputHandler inputHandler;

    public RacingController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        List<String> cars = inputHandler.getCars();
        int tryCount = inputHandler.getCount();
    }
}
