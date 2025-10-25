package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

public class RacingGameServiceTest {
    private RacingGameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new RacingGameService();
    }

    @DisplayName("우승자가 한 명일 때 우승자 찾기")
    @Test
    void 우승자가_한_명일_때_우승자_찾기() {
        //given
        Cars cars = new Cars(List.of("pobi","woni","jun"));
        gameService.initializeCars(cars);

        cars.getCars().get(0).move(5);
        cars.getCars().get(0).move(5);
        cars.getCars().get(1).move(5);
        cars.getCars().get(2).move(2);

        //when
        String result = gameService.findWinners();

        //then
        assertEquals("pobi", result);
    }

    @DisplayName("우승자가 여러 명일 때 우승자 찾기")
    @Test
    void 우승자가_여러_명일_때_우승자_찾기() {
        //given
        Cars cars = new Cars(List.of("pobi","woni","jun"));
        gameService.initializeCars(cars);

        cars.getCars().get(0).move(4);
        cars.getCars().get(0).move(6);
        cars.getCars().get(1).move(5);
        cars.getCars().get(1).move(8);
        cars.getCars().get(2).move(2);

        //when
        String result = gameService.findWinners();

        //then
        assertEquals("pobi, woni", result);
    }

    @DisplayName("주어진 횟수가 숫자가 아닐 경우 예외 발생")
    @Test
    void 주어진_횟수가_숫자가_아닐_경우_예외_발생() {
        //given
        String input = "five";

        //when&then
        assertThatThrownBy(() -> gameService.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자여야 합니다.");
    }

    @DisplayName("주어진 횟수가 0 이하일 경우 예외 발생")
    @Test
    void 주어진_횟수가_0_이하일_경우_예외_발생() {
        //given
        String input = "0";

        //when&then
        assertThatThrownBy(() -> gameService.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1회 이상이여야 합니다.");
    }
}
