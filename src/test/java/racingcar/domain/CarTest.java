package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.constants.ErrorMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.constants.ErrorMessage.INVALID_CAR_NAME_NOT_BLANK;

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
        car.move(randomNumber);

        //then
        assertEquals(1, car.getPosition());
    }

    @DisplayName("랜덤 값을 받아 3 이하가 나올 시 정지")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void 랜덤_값을_받아_3_이하가_나올_시_정지(int randomNumber) {
        //given
        Car car = new Car("pobi");

        //when
        car.move(randomNumber);

        //then
        assertEquals(0, car.getPosition());
    }

    @DisplayName("자동차 이름 5자 이상 작성 시 예외 발생")
    @Test
    void 자동차_이름_5자_이상_작성_시_예외_발생() {
        //given
        String input = "pobijjang";

        //when&then
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME_LENGTH.toString());
    }

    @DisplayName("자동차 이름 공백 입력 시 예외 발생")
    @Test
    void 자동차_이름_공백_입력_시_예외_발생 () {
        //given
        String input = "";

        //when&then
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME_NOT_BLANK.toString());
    }
}
