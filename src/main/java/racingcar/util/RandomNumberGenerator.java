package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements Random {
    @Override
    public int random() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
