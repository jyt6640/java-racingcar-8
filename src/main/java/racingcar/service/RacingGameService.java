package racingcar.service;

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
        return cars.roundResult();
    }

    public String findWinners() {
        return cars.findWinner();
    }
}
