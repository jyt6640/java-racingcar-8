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
}
