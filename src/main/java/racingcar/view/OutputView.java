package racingcar.view;

public class OutputView {
    private OutputView() {
    }

    public static void printRunResult() {
        System.out.println("실행 결과");
    }

    public static void printRaceResult(String result) {
        System.out.println(result);
    }

    public static void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println("[ERROR] : " + e.getMessage());
    }
}
