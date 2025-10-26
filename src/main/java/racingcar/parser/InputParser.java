package racingcar.parser;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parseCars(String input) {
        return Arrays.stream(input.split(","))
                .map(String::strip)
                .toList();
    }

    public int parseAttemptCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 int 범위를 넘어갈 수 없습니다.");
        }
    }
}
