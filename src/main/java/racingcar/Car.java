package racingcar;

public class Car {
    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void moveCar(String carName, int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
