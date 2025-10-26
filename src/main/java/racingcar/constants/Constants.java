package racingcar.constants;

public class Constants {
    private Constants() {
    }
    public static final int ZERO = 0;
    public static final int INITIAL_POSITION = 0;
    public static final int MOVING_FORWARD = 4;
    public static final int MIN_RANDOM_RANGE = 0;
    public static final int RANDOM_MAX_RANGE = 9;
    public static final int CAR_NAME_MAX_LENGTH = 5;

    public static final String CAR_NAME_INPUT_REGEX = "^[^,]+(,[^,]*)*$";
    public static final String ONLY_NUMBER_REGEX = "^\\d+$";
    public static final String COMMA = ",";
    public static final String COMMA_WITH_SPACE = ", ";
    public static final String HYPHEN = "-";
    public static final String LINE_SEPARATOR = "\n";
    public static final String RESULT_SEPARATOR = " : ";
}
