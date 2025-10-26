package racingcar.domain;

import static racingcar.constants.Constants.CAR_NAME_MAX_LENGTH;
import static racingcar.constants.Constants.INITIAL_POSITION;
import static racingcar.constants.Constants.MOVING_FORWARD;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        validateCarNameLength(carName);
        validateNameNotBlank(carName);
        this.carName = carName;
        this.position = INITIAL_POSITION;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD) {
            position++;
        }
    }

    private void validateCarNameLength(String carName) {
        if(carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private void validateNameNotBlank(String carName) {
        if(carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    public String getName() {
        return carName;
    }

    int getPosition() {
        return position;
    }
}
