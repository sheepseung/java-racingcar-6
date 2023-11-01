package racingcar.configurator;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.UserView;

public class GameSetter {
    private final CarList carList;
    private final UserView userView;

    private String userInputValue;
    private int coin;

    public GameSetter(CarList carList) {
        this.carList = carList;
        this.userView = new UserView();

        this.userInputValue = userView.inputNameValue();
        this.coin = userView.inputCoinValue();
    }

    public GameSetter(CarList carList, String inputValue, int coinValue){
        this.carList = carList;
        this.userView = new UserView();

        this.userInputValue = inputValue;
        this.coin = coinValue;
    }

    public void registerCars() {
        int startNameIndex = 0;
        int length = userInputValue.length();

        for (int i = 0; i < length; i++) {
            if (userInputValue.charAt(i) == ',') {
                String carName = userInputValue.substring(startNameIndex, i);
                startNameIndex = i + 1;
                inputCarToList(carName);
            }
            if (i == length - 1) {
                String carName = userInputValue.substring(startNameIndex);
                inputCarToList(carName);
            }
        }
    }

    public void inputCarToList(String carName) {
        carList.addCar(new Car(carName));
    }

    public int getCoin() {
        return coin;
    }
}
