package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.constants.ErrorMessage.INVALID_ATTEMPT_NOT_NUMBER;
import static racingcar.constants.ErrorMessage.INVALID_ATTEMPT_RANGE;
import static racingcar.constants.ErrorMessage.INVALID_CAR_COUNT;
import static racingcar.constants.ErrorMessage.INVALID_CAR_INPUT_FORMAT;
import static racingcar.constants.ErrorMessage.INVALID_INPUT_NOT_BLANK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("자동차 이름이 공백일 경우 예외 발생")
    @ValueSource(strings = {""," ","  "})
    @ParameterizedTest
    void 자동차_이름이_공백일_경우_예외_발생(String input) {
        //when&then
        assertThatThrownBy(() -> inputValidator.validateCarsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT_NOT_BLANK.toString());
    }

    @DisplayName("자동차가 2대 이상 없을 시 예외 발생")
    @Test
    void 자동차가_2대_이상_없을_시_예외_발생() {
        //given
        String input = "pobijjang";

        //when&then
        assertThatThrownBy(() -> inputValidator.validateCarsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_COUNT.toString());
    }

    @DisplayName("자동차 이름 정규식 기반 입력 예외 발생")
    @ValueSource(strings = {",pobi", ",",",,pobi"})
    @ParameterizedTest
    void 자동차_이름_정규식_기반_입력_예외_발생() {
        //given
        String input = ",pobi";

        //when&then
        assertThatThrownBy(() -> inputValidator.validateCarsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_INPUT_FORMAT.toString());
    }

    @DisplayName("주어진 횟수가 숫자가 아닐 경우 예외 발생")
    @ValueSource(strings = {"abc", "one", "1a", "a1", "1.5"})
    @ParameterizedTest
    void 주어진_횟수가_숫자가_아닐_경우_예외_발생(String input) {
        //when&then
        assertThatThrownBy(() -> inputValidator.validateAttemptCountFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ATTEMPT_NOT_NUMBER.toString());
    }

    @DisplayName("주어진 횟수가 0 이하일 경우 예외 발생")
    @ValueSource(ints = {0, -1, -100, -512})
    @ParameterizedTest
    void 주어진_횟수가_0_이하일_경우_예외_발생(int input) {
        //when&then
        assertThatThrownBy(() -> inputValidator.validateAttemptCountRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ATTEMPT_RANGE.toString());
    }

    @DisplayName("주어진 횟수가 공백일 경우 예외 발생")
    @ValueSource(strings = {""," ","  "})
    @ParameterizedTest
    void 주어진_횟수가_공백일_경우_예외_발생(String input) {
        //when&then
        assertThatThrownBy(() -> inputValidator.validateAttemptCountFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT_NOT_BLANK.toString());
    }
}
