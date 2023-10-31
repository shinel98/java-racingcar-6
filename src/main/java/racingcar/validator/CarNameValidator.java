package racingcar.validator;

import racingcar.util.Utils;

import java.util.List;
import java.util.regex.Pattern;

public class CarNameValidator {
    private final String carNames;
    public final List<String> carNameList;

    public CarNameValidator(String carNames) {
        this.carNames = carNames;
        this.carNameList = Utils.toList(carNames);
        validate();

    }

    public void validate() {
        isNameValid();
        isNameWithinRange();
    }

    public void isNameWithinRange() {
        if(carNameList.stream().anyMatch(name -> name.length() > 5 || name.isEmpty())) {
            throw new IllegalArgumentException("자동차의 이름은 1~5자이어야 합니다.");
        }
    }

    public void isNameValid() {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9,]");
        if(carNames.matches(".*[^a-zA-Z0-9 ,].*")) {
            throw new IllegalArgumentException("쉼표 외의 특수문자를 입력하셨습니다.");
        }
    }
}
