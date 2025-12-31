package racingcar.domain;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    public void movingForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validate(String name) {
        empty(name);
        length(name);
    }

    private void length(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름 길이가 5자 초과입니다.");
        }
    }

    private void empty(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 공백입니다.");
        }
    }
}
