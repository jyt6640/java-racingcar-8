package racingcar.domain;

import static racingcar.constants.Constants.COMMA_WITH_SPACE;
import static racingcar.constants.Constants.HYPHEN;
import static racingcar.constants.Constants.LINE_SEPARATOR;
import static racingcar.constants.Constants.MAX_RANDOM_RANGE;
import static racingcar.constants.Constants.MIN_RANDOM_RANGE;
import static racingcar.constants.Constants.RESULT_SEPARATOR;
import static racingcar.constants.Constants.ZERO;
import static racingcar.constants.ErrorMessage.DUPLICATE_CAR_NAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicateName(names);
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public void moveAll() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
            car.move(randomNumber);
        }
    }

    public String roundResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
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
        throw new IllegalArgumentException(DUPLICATE_CAR_NAME.toString());
    }

    public String findWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(ZERO);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(COMMA_WITH_SPACE));
    }
}
