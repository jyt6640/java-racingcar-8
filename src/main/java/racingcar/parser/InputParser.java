package racingcar.parser;

import java.util.List;

public class InputParser {
    public List<String> parseCars(String input) {
        List<String> cars = List.of(input.split(","));
        return cars;
    }

}
