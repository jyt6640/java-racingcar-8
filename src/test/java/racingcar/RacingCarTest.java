package racingcar;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        String[] cars = racingCar.createCars(input);

        //then
        assertArrayEquals(new String[]{"pobi", "woni", "jun"}, cars);
    }

    @DisplayName("자동차 이름 5자 이상 작성 시 예외 발생")
    @Test
    void 자동차_이름_5자_이상_작성_시_예외_발생() {
        //given
        String input = "pobijjang,woni,jun";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> racingCar.createCars(input));
    }
}
