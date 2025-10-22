package racingcar;

public class RacingCar {
    public String[] createCars(String input) {
        String[] cars = input.split(",");
        for (String car : cars) {
            validateFiveMoreCharacters(car);
        }
        return cars;
    }

    private void validateFiveMoreCharacters(String car) {
        if(car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public int moveCar(int position, int randomNumber) {
        if (randomNumber >= 4) {
            return position + 1;
        }
        return position;
    }
}
