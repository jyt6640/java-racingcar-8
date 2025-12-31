package racingcar.view.handler;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class InputHandler {

    private InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public List<String> getCars() {
        String carNames = inputView.readCarNames();
        return Arrays.asList(carNames.split(","));
    }

    public int getCount() {
        String count = inputView.readTryCount();
        return Integer.parseInt(count);
    }
}
