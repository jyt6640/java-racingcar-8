package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.constants.ErrorMessage.DUPLICATE_CAR_NAME;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarsTest {
    @DisplayName("이름 리스트로 Cars 생성")
    @Test
    void 이름_리스트로_Cars_생성() {
        //given
        List<String> input = List.of("pobi", "woni", "jun");

        //when&then
        new Cars(input);
    }

    @DisplayName("라운드 결과 문자열 형식 확인")
    @Test
    void 라운드_결과_문자열_형식_확인() {
        //given
        Cars cars = new Cars(List.of("pobi", "woni"));

        //when
        String result = cars.roundResult();

        //then
        assertThat(result).contains("pobi : ");
        assertThat(result).contains("woni : ");
        assertThat(result).contains("\n");
    }

    @DisplayName("최종 우승자가 존재하는지 확인")
    @Test
    void 최종_우승자_결과_문자열_형식_확인() {
        //given
        Cars cars = new Cars(List.of("pobi", "woni"));

        //when
        cars.moveAll();
        String result = cars.findWinner();

        //then
        assertThat(result).isNotBlank();
    }

    @DisplayName("동일한 자동차 이름일 때 예외 발생")
    @Test
    void 동일한_자동차_이름일_때_예외_발생() {
        //given
        List<String> input = List.of("pobi", "woni", "pobi");

        //when&then
        assertThatThrownBy(() ->  new Cars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR_NAME.getMessage());
    }
}
