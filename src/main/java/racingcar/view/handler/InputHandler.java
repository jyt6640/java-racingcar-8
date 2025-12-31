package racingcar.view.handler;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class InputHandler {
    private static final String INPUT_REGEX = "^[ㄱ-ㅎ가-힣A-Za-z]+(,[ㄱ-ㅎ가-힣A-Za-z]+)*$";

    private InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public Cars getCars() {
        String carNames = inputView.readCarNames().strip();
        validateEmpty(carNames);
        validateInput(carNames);
        List<String> cars = Arrays.asList(carNames.split(",", -1));
        return new Cars(cars);
    }

    public int getCount() {
        String count = inputView.readTryCount().strip();
        validateEmpty(count);
        return Integer.parseInt(count);
    }

    private void validateEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 공백입니다.");
        }
    }

    private void validateInput(String input) {
        if (!input.matches(INPUT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 올바르지 않습니다.");
        }
    }
}
