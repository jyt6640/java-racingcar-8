package racingcar.domain;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        validateCarNameLength(carName);
        validateNameNotBlank(carName);
        this.carName = carName;
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    private void validateCarNameLength(String carName) {
        if(carName.length() > 5) {
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

    public int getPosition() {
        return position;
    }
}
