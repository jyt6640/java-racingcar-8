package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicateName(names);
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public void moveAll() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public String roundResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        return result.toString();
    }

    private void validateDuplicateName(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        if(uniqueNames.size() == names.size()) {
            return;
        }
        throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
    }

    public String findWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
