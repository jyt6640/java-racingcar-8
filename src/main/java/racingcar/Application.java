package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.handler.InputHandler;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new InputHandler(new InputView()));
        racingController.run();
    }
}
