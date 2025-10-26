package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
    @Test
    void 자동차_이름이_공백일_경우_예외_발생() {
        //given
        String input = "";

        //when&then
        assertThatThrownBy(() -> inputValidator.validateCarsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @DisplayName("자동차가 2대 이상 없을 시 예외 발생")
    @Test
    void 자동차가_2대_이상_없을_시_예외_발생() {
        //given
        String input = "pobijjang";

        //when&then
        assertThatThrownBy(() -> inputValidator.validateCarsName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상이어야 합니다.");
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
                .hasMessage("입력 형식이 잘못되었습니다.");
    }

    @DisplayName("주어진 횟수가 숫자가 아닐 경우 예외 발생")
    @Test
    void 주어진_횟수가_숫자가_아닐_경우_예외_발생() {
        //given
        String input = "five";

        //when&then
        assertThatThrownBy(() -> inputValidator.validateIsNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자여야 합니다.");
    }

    @DisplayName("주어진 횟수가 0 이하일 경우 예외 발생")
    @Test
    void 주어진_횟수가_0_이하일_경우_예외_발생() {
        //given
        int input = 0;

        //when&then
        assertThatThrownBy(() -> inputValidator.validateAttemptCountRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1회 이상이여야 합니다.");
    }

    @DisplayName("주어진 횟수가 공백일 경우 예외 발생")
    @Test
    void 주어진_횟수가_공백일_경우_예외_발생() {
        //given
        String input = "";

        //when&then
        assertThatThrownBy(() -> inputValidator.validateAttemptCountFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주어진 횟수가 공백일 수 없습니다.");
    }
}
