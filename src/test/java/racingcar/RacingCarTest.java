package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    private static final int MOVE_FORWARD = 4;

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

    @DisplayName("자동차 전진")
    @Test
    void 자동차_전진() {
        //given
        int position = 0;
        int moveForward = MOVE_FORWARD;

        //when
        int result = racingCar.moveCar(position, moveForward);

        //then
        assertEquals(1, result);
    }

    @DisplayName("주어진 횟수만큼 자동차 이동 반복")
    @Test
    void 주어진_횟수만큼_자동차_이동_반복() {
        //given
        String input = "pobi,woni,jun";
        String[] cars = racingCar.createCars(input);
        int attemptCount = 5;

        //when
        int result = racingCar.startRace(cars, attemptCount);

        //then
        assertEquals(attemptCount, result);
    }

    @DisplayName("자동차 이름을 기반으로 위치 저장")
    @Test
    void 자동차_이름을_기반으로_위치_저장() {
        //given
        String[] cars = racingCar.createCars("pobi,woni,jun");

        //when
        racingCar.initializeCars(cars);

        //then
        assertEquals(0, racingCar.getPosition("pobi"));
        assertEquals(0, racingCar.getPosition("woni"));
        assertEquals(0, racingCar.getPosition("jun"));
    }
}
