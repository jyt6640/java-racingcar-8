package racingcar.parser;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parseCars(String input) {
        return Arrays.stream(input.split(","))
                .map(String::strip)
                .toList();
    }
}
