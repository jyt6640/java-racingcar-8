package racingcar.view;

import static racingcar.constants.MessageConstants.ATTEMPT_COUNT_INPUT_MESSAGE;
import static racingcar.constants.MessageConstants.CAR_NAME_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView(){
    }

    public static String readCar() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String readAttemptCount() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
        return Console.readLine();
    }
}
