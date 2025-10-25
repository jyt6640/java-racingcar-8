package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @DisplayName("자동차 객체 생성")
    @Test
    void 자동차_객체_생성() {
        //given
        String input = "pobi";

        //when
        Car car = new Car(input);

        //then
        assertEquals("pobi", car.getName());
        assertEquals(0, car.getPosition());
    }

    @DisplayName("랜덤 값을 받아 4 이상이 나올 시 앞으로 전진")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void 랜덤_값을_받아_4_이상이_나올_시_앞으로_전진(int randomNumber) {
        //given
        Car car = new Car("pobi");

        //when
        car.moveCar("pobi", randomNumber);

        //then
        assertEquals(1, car.getPosition());
    }
}
