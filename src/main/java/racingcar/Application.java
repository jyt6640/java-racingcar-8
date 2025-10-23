package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();

        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carInput = Console.readLine();
            String[] cars = racingCar.createCars(carInput);
            racingCar.initializeCars(cars);

            System.out.println("시도할 횟수는 몇 회인가요?");
            String attemptInput = Console.readLine();
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
