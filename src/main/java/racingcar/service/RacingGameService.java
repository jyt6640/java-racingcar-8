package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingGameService {
    private Cars cars;

    public void initializeCars(Cars cars){
        this.cars = cars;
    }

    public void playRound() {
        for (Car car : cars.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public String getRoundResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars.getCars()) {
            result.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        return result.toString();
    }

    public String findWinners() {
        // TODO: Cars에 findWinners 메서드 추가 필요
        return "";
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
