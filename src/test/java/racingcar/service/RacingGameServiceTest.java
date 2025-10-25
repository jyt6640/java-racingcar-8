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
}
