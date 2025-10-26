package racingcar.parser;

import static racingcar.constants.Constants.COMMA;
import static racingcar.constants.ErrorMessage.INVALID_ATTEMPT_INT_RANGE;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parseCars(String input) {
        return Arrays.stream(input.split(COMMA, -1))
                .map(String::strip)
                .toList();
    }

    public int parseAttemptCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_INT_RANGE.getMessage());
        }
    }
}
