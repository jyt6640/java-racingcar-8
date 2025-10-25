package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @DisplayName("자동차 이름이 공백일 경우 예외 발생")
    @Test
    void 자동차_이름이_공백일_경우_예외_발생() {
        //given
        String input = "";

        //when&then
        assertThatThrownBy(() -> inputValidator.validateCarsNameNotBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @DisplayName("주어진 횟수가 숫자가 아닐 경우 예외 발생")
    @Test
    void 주어진_횟수가_숫자가_아닐_경우_예외_발생() {
        //given
        String input = "five";

        //when&then
        assertThatThrownBy(() -> inputValidator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자여야 합니다.");
    }

    @DisplayName("주어진 횟수가 0 이하일 경우 예외 발생")
    @Test
    void 주어진_횟수가_0_이하일_경우_예외_발생() {
        //given
        String input = "0";

        //when&then
        assertThatThrownBy(() -> inputValidator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1회 이상이여야 합니다.");
    }
}
