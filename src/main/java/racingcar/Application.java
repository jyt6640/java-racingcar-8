package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();

        try {
            String carInput = InputView.readCar();
            String[] cars = racingCar.createCars(carInput);
            racingCar.initializeCars(cars);

            String attemptInput = InputView.readAttemptCount();
            int attemptCount = Integer.parseInt(attemptInput);

            System.out.println("\n실행 결과");
            racingCar.startRace(attemptCount);

            System.out.println("최종 우승자 : " + racingCar.findWinners());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            throw e;
        } finally {
            Console.close();
        }
    }
}
