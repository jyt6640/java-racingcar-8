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
        cars.moveAll();
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
        return cars.findWinner();
    }
}
