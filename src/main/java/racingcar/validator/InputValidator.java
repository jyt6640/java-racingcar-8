package racingcar.validator;

public class InputValidator {
    public int validateAttemptCount(String input) {
        try {
            int attemptCount = Integer.parseInt(input);
            validateAttemptCountRange(attemptCount);
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateAttemptCountRange(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이여야 합니다.");
        }
    }
}
