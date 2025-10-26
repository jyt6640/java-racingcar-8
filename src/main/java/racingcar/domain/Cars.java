package racingcar.domain;

import static racingcar.constants.Constants.COMMA_WITH_SPACE;
import static racingcar.constants.Constants.HYPHEN;
import static racingcar.constants.Constants.LINE_SEPARATOR;
import static racingcar.constants.Constants.MIN_RANDOM_RANGE;
import static racingcar.constants.Constants.RANDOM_MAX_RANGE;
import static racingcar.constants.Constants.RESULT_SEPARATOR;
import static racingcar.constants.Constants.ZERO;
import static racingcar.constants.ErrorMessage.DUPLICATE_CAR_NAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> car;

    public Cars(List<String> names) {
        validateDuplicateName(names);
        this.car = names.stream()
                .map(Car::new)
                .toList();
    }

    public void moveAll() {
        for (Car car : car) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_RANGE, RANDOM_MAX_RANGE);
            car.move(randomNumber);
        }
    }

    public String roundResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : car) {
            result.append(car.getName())
                    .append(RESULT_SEPARATOR)
                    .append(HYPHEN.repeat(car.getPosition()))
                    .append(LINE_SEPARATOR);
        }
        return result.toString();
    }

    private void validateDuplicateName(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        if(uniqueNames.size() == names.size()) {
            return;
        }
        throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
    }

    public String findWinner() {
        int maxPosition = car.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(ZERO);

        return car.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(COMMA_WITH_SPACE));
    }
}
