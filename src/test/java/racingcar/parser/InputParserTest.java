package racingcar.parser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.constants.ErrorMessage.INVALID_ATTEMPT_INT_RANGE;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    private InputParser inputParser;

    @BeforeEach
    public void setup() {
        inputParser = new InputParser();
    }

    @DisplayName("자동차 이름을 쉼표를 기준으로 분리")
    @Test
    void 자동차_이름을_쉼표를_기준으로_분리() {
        //given
        String input = "pobi,woni,jun";

        //when
        List<String> result = inputParser.parseCars(input);

        //then
        assertEquals(List.of("pobi","woni","jun"), result);
    }

    @DisplayName("자동차 이름 앞뒤 공백 제거")
    @Test
    void 자동차_이름_앞뒤_공백_제거() {
        //given
        String input = " pobi , woni, jun ";

        //when
        List<String> result = inputParser.parseCars(input);

        //then
        assertEquals(List.of("pobi","woni","jun"), result);
    }

    @DisplayName("시도 횟수 문자열에서 int로 변환")
    @Test
    void 시도_횟수_문자열에서_int로_변환() {
        //given
        String input = "5";

        //when
        int result = inputParser.parseAttemptCount(input);

        //then
        assertEquals(5, result);
    }

    @DisplayName("시도 횟수가 int 범위 밖일 경우 예외 발생")
    @Test
    void 시도_횟수가_int_범위_밖일_경우_예외_발생() {
        //given
        String input = "99999999999999";

        //when&then
        assertThatThrownBy(() -> inputParser.parseAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ATTEMPT_INT_RANGE.getMessage());
    }
}
