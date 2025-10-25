package racingcar.validator;

public class InputValidator {
    public void validateCarsNameNotBlank(String cars) {
        if (cars == null || cars.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    public void validateMinimumCarCount(String cars) {
        if (cars.contains(",")) {
            return;
        }
        throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
    }

    public int validateAttemptCount(String attemptCounts) {
        try {
            int attemptCount = Integer.parseInt(attemptCounts);
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
