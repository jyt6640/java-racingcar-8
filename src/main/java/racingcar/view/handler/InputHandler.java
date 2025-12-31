package racingcar.view.handler;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class InputHandler {

    private InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public Cars getCars() {
        String carNames = inputView.readCarNames();
        List<String> cars = Arrays.asList(carNames.split(","));
        return new Cars(cars);
    }

    public int getCount() {
        String count = inputView.readTryCount();
        return Integer.parseInt(count);
    }
}
