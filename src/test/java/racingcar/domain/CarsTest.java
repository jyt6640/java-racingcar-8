package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @DisplayName("이름 리스트로 Cars 생성")
    @Test
    void 이름_리스트로_Cars_생성() {
        //given
        List<String> input = List.of("pobi", "woni", "jun");

        //when
        Cars cars = new Cars(input);

        //then
        assertEquals(3, cars.getCars().size());
        assertEquals("pobi", cars.getCars().get(0).getName());
        assertEquals("woni", cars.getCars().get(1).getName());
        assertEquals("jun", cars.getCars().get(2).getName());
    }

    @DisplayName("동일한 자동차 이름일 때 예외 발생")
    @Test
    void 동일한_자동차_이름일_때_예외_발생() {
        //given
        List<String> input = List.of("pobi", "woni", "pobi");

        //when&then
        assertThatThrownBy(() ->  new Cars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }
}
