package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
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

    public void moveCar(String car, int randomNumber) {
        if (randomNumber >= 4) {
            carStates.put(car, carStates.get(car) + 1);
        }
    }

    public int startRace(int attemptCount) {
        int round = 0;
        for (int i = 0; i < attemptCount; i++) {
            for(String car : carStates.keySet()) {
                int randomNumber = Randoms.pickNumberInRange(0,9);
                moveCar(car, randomNumber);
            }
            round++;
        }
        return round;
    }

    public void initializeCars(String[] cars) {
        for (String car : cars) {
            carStates.put(car, 0);
        }
    }

    public String findWinners() {
        int maxPosition = carStates.values()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);

        return carStates.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
    }

    public int getPosition(String car) {
        return carStates.get(car);
    }

    private void validateCarName(String car) {
        if(car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }

        if(car.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    public int validateAttemptCount(String input) {
        try {
            int attemptCount = Integer.parseInt(input);
            if (attemptCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이여야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

    }
}
