package racingcar.constants;

public enum ErrorMessage {
    INVALID_INPUT_NOT_BLANK("입력값은 공백일 수 없습니다."),
    INVALID_CAR_INPUT_FORMAT("입력 형식이 잘못되었습니다."),
    INVALID_CAR_COUNT("자동차는 2대 이상이어야 합니다."),
    INVALID_ATTEMPT_NOT_NUMBER("시도 횟수는 숫자이어야 합니다."),
    INVALID_ATTEMPT_INT_RANGE("시도 횟수는 int 범위를 넘어갈 수 없습니다."),
    INVALID_ATTEMPT_RANGE("시도 횟수는 1회 이상이어야 합니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 5글자를 초과할 수 없습니다."),
    INVALID_CAR_NAME_NOT_BLANK("자동차 이름은 공백일 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
