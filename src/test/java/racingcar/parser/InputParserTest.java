package racingcar.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
