package racingcar.domain;

import static racingcar.constants.Constants.CAR_NAME_MAX_LENGTH;
import static racingcar.constants.Constants.INITIAL_POSITION;
import static racingcar.constants.Constants.MOVING_FORWARD;
import static racingcar.constants.ErrorMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.constants.ErrorMessage.INVALID_CAR_NAME_NOT_BLANK;

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
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    private void validateNameNotBlank(String carName) {
        if(carName.isBlank()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_NOT_BLANK.getMessage());
        }
    }

    public String getName() {
        return carName;
    }

    int getPosition() {
        return position;
    }
}
