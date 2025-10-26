package racingcar.view;

import static racingcar.constants.MessageConstants.ERROR_PREFIX;
import static racingcar.constants.MessageConstants.RUN_RESULT_MESSAGE;
import static racingcar.constants.MessageConstants.WINNER_PREFIX;

public class OutputView {
    private OutputView() {
    }

    public static void printRunResult() {
        System.out.println(RUN_RESULT_MESSAGE);
    }

    public static void printRaceResult(String result) {
        System.out.println(result);
    }

    public static void printWinners(String winners) {
        System.out.println(WINNER_PREFIX + winners);
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
