package racingcar;

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
}
