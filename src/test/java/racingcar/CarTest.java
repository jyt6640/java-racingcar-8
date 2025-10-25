package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {`
    @DisplayName("자동차 객체 생성");
    @Test
    void 자동차_객체_생성() {
        //given
        String input = "pobi";

        //when
        Car car = new Car();

        //then
        assertEquals("pobi", car.getName());
        assertEquals("0", car.getPosition());
    }
}
