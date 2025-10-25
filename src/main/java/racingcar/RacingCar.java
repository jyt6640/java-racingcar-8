package racingcar;

import static racingcar.View.OutputView.printRaceResult;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCar {
    private Map<String, Integer> carStates = new LinkedHashMap<>();

    public String[] createCars(String input) {
        String[] cars = input.split(",");
        return cars;
    }

    public void moveCar(String car, int randomNumber) {
        if (randomNumber >= 4) {
            carStates.put(car, carStates.get(car) + 1);
        }
    }

    public void startRace(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            for(String car : carStates.keySet()) {
                int randomNumber = Randoms.pickNumberInRange(0,9);
                moveCar(car, randomNumber);
            }
            String result = RoundResult();
            printRaceResult(result);
        }
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
                .collect(Collectors.joining(","));
    }

    public String RoundResult() {
        StringBuilder result = new StringBuilder();

        for (String car : carStates.keySet()) {
            String line = car + " : " + "-".repeat(carStates.get(car));
            result.append(line).append("\n");
        }

        return result.toString();
    }

    public int getPosition(String car) {
        return carStates.get(car);
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
