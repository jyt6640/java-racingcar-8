package racingcar;

import java.util.HashMap;
import java.util.Map;

public class RacingCar {
    private Map<String, Integer> carStates = new HashMap<>();

    public String[] createCars(String input) {
        String[] cars = input.split(",");
        for (String car : cars) {
            validateCarName(car);
        }
        return cars;
    }

    private void validateCarName(String car) {
        if(car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }

        if(car.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    public void moveCar(int randomNumber) {
        for(String car : carStates.keySet()) {
            int position = carStates.get(car);
            if (randomNumber >= 4) {
                carStates.put(car, position + 1);
            }
        }
    }

    public int startRace(String[] cars, int attemptCount) {
        int round = 0;
        for (int i = 0; i < attemptCount; i++) {
            round++;
        }
        return round;
    }

    public void initializeCars(String[] cars) {
        for (String car : cars) {
            carStates.put(car, 0);
        }
    }

    public int getPosition(String car) {
        return carStates.get(car);
    }
}
