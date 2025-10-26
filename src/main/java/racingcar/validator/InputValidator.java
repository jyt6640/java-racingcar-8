package racingcar.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern CAR_NAME_INPUT_PATTERN = Pattern.compile("^[^,]+(,[^,]*)*$");
    private static final Pattern ONLY_NUMBER_INPUT_PATTERN = Pattern.compile("^\\d+$");

    public void validateCarsName(String input) {
        validateCarsNameNotBlank(input);
        validateCarsNameFormat(input);
        validateMinimumCarCount(input);
    }

    private void validateCarsNameNotBlank(String cars) {
        if (cars == null || cars.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private void validateMinimumCarCount(String cars) {
        if (cars.contains(",")) {
            return;
        }
        throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
    }

    private void validateCarsNameFormat(String cars) {
        Matcher matcher = CAR_NAME_INPUT_PATTERN.matcher(cars);
        if(matcher.matches()) {
            return;
        }
        throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
    }

    public void validateAttemptCountFormat(String input) {
        validateAttemptNotBlank(input);
        validateIsNumeric(input);
    }

    public void validateIsNumeric(String input) {
        Matcher matcher = ONLY_NUMBER_INPUT_PATTERN.matcher(input);
        if(matcher.matches()) {
            return;
        }
        throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
    }

    private void validateAttemptNotBlank(String attemptCounts) {
        if (attemptCounts == null || attemptCounts.isBlank()) {
            throw new IllegalArgumentException("주어진 횟수가 공백일 수 없습니다.");
        }
    }

    public void validateAttemptCountRange(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이여야 합니다.");
        }
    }
}
