package racingcar.validator;

import static racingcar.constants.Constants.CAR_NAME_INPUT_REGEX;
import static racingcar.constants.Constants.COMMA;
import static racingcar.constants.Constants.ONLY_NUMBER_REGEX;
import static racingcar.constants.Constants.ZERO;
import static racingcar.constants.ErrorMessage.INVALID_ATTEMPT_NOT_NUMBER;
import static racingcar.constants.ErrorMessage.INVALID_ATTEMPT_RANGE;
import static racingcar.constants.ErrorMessage.INVALID_CAR_COUNT;
import static racingcar.constants.ErrorMessage.INVALID_CAR_INPUT_FORMAT;
import static racingcar.constants.ErrorMessage.INVALID_INPUT_NOT_BLANK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern CAR_NAME_INPUT_PATTERN = Pattern.compile(CAR_NAME_INPUT_REGEX);
    private static final Pattern ONLY_NUMBER_INPUT_PATTERN = Pattern.compile(ONLY_NUMBER_REGEX);

    public void validateCarsName(String input) {
        validateNotBlank(input);
        validateCarsNameFormat(input);
        validateMinimumCarCount(input);
    }

    public void validateAttemptCountFormat(String input) {
        validateNotBlank(input);
        validateIsNumeric(input);
    }

    private void validateNotBlank(String cars) {
        if (cars == null || cars.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_BLANK.getMessage());
        }
    }

    private void validateMinimumCarCount(String cars) {
        if (cars.contains(COMMA)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_CAR_COUNT.getMessage());
    }

    private void validateCarsNameFormat(String cars) {
        Matcher matcher = CAR_NAME_INPUT_PATTERN.matcher(cars);
        if(matcher.matches()) {
            return;
        }
        throw new IllegalArgumentException(INVALID_CAR_INPUT_FORMAT.getMessage());
    }

    private void validateIsNumeric(String input) {
        Matcher matcher = ONLY_NUMBER_INPUT_PATTERN.matcher(input);
        if(matcher.matches()) {
            return;
        }
        throw new IllegalArgumentException(INVALID_ATTEMPT_NOT_NUMBER.getMessage());
    }

    public void validateAttemptCountRange(int attemptCount) {
        if (attemptCount <= ZERO) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_RANGE.getMessage());
        }
    }
}
