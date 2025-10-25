package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @DisplayName("자동차를 쉼표 기준으로 분리")
    @Test
    void 자동차를_쉼표를_기준으로_분리() {
        //given
        String input = "pobi,woni,jun";

        //when
        String[] result = racingCar.createCars(input);

        //then
        assertArrayEquals(new String[]{"pobi", "woni", "jun"}, result);
    }

    @DisplayName("우승자가 한 명일 때 우승자 찾기")
    @Test
    void 우승자가_한_명일_때_우승자_찾기() {
        //given
        String[] cars = racingCar.createCars("pobi,woni,jun");
        racingCar.initializeCars(cars);
        racingCar.moveCar("pobi", 5);
        racingCar.moveCar("pobi", 5);
        racingCar.moveCar("woni", 5);
        racingCar.moveCar("jun", 2);

        //when
        String result = racingCar.findWinners();

        //then
        assertEquals("pobi", result);
    }

    @DisplayName("우승자가 여러 명일 때 우승자 찾기")
    @Test
    void 우승자가_여러_명일_때_우승자_찾기() {
        //given
        String[] cars = racingCar.createCars("pobi,woni,jun");
        racingCar.initializeCars(cars);
        racingCar.moveCar("pobi", 5);
        racingCar.moveCar("pobi", 5);
        racingCar.moveCar("woni", 5);
        racingCar.moveCar("woni", 5);
        racingCar.moveCar("jun", 2);

        //when
        String result = racingCar.findWinners();

        //then
        assertEquals("pobi,woni", result);
    }

    @DisplayName("라운드마다 자동차가 이동할 때마다 전진 결과 출력")
    @Test
    void 라운드마다_자동차가_이동할_때마다_전진_결과_출력() {
        //given
        String[] cars = racingCar.createCars("pobi,woni,jun");
        racingCar.initializeCars(cars);

        //when
        racingCar.moveCar("pobi", 5);
        racingCar.moveCar("woni", 3);
        racingCar.moveCar("jun", 6);
        String result1 = racingCar.RoundResult();

        racingCar.moveCar("pobi", 3);
        racingCar.moveCar("woni", 5);
        racingCar.moveCar("jun", 4);
        String result2 = racingCar.RoundResult();

        //then
        assertEquals("pobi : -\nwoni : \njun : -", result1);
        assertEquals("pobi : -\nwoni : -\njun : --", result2);
    }

    @DisplayName("자동차 이름 5자 이상 작성 시 예외 발생")
    @Test
    void 자동차_이름_5자_이상_작성_시_예외_발생() {
        //given
        String input = "pobijjang,woni,jun";

        //when&then
        assertThatThrownBy(() -> racingCar.createCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("자동차 이름 공백 입력 시 예외 발생")
    @Test
    void 자동차_이름_공백_입력_시_예외_발생 () {
        //given
        String input = "pobi,,jun";

        //when&then
        assertThatThrownBy(() -> racingCar.createCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @DisplayName("주어진 횟수가 숫자가 아닐 경우 예외 발생")
    @Test
    void 주어진_횟수가_숫자가_아닐_경우_예외_발생() {
        //given
        String input = "five";

        //when&then
        assertThatThrownBy(() -> racingCar.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자여야 합니다.");
    }

    @DisplayName("주어진 횟수가 0 이하일 경우 예외 발생")
    @Test
    void 주어진_횟수가_0_이하일_경우_예외_발생() {
        //given
        String input = "0";

        //when&then
        assertThatThrownBy(() -> racingCar.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1회 이상이여야 합니다.");
    }
}
