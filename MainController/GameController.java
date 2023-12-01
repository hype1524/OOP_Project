import com.example.oopproject.Dictionary;
import com.example.oopproject.MainController.FirstGameController;
import com.example.oopproject.MainController.SecondGameController;
import com.example.oopproject.MainController.ThirdGameController;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class GameController {
    public enum Type {
        test, fill, connect
    }

    private static Type type = Type.test;
    private static int number = 10;
    @FXML
    public BorderPane border5;
    @FXML
    public BorderPane border6;
    @FXML
    public BorderPane border7;
    @FXML
    private RadioButton radiobutton1;

    @FXML
    private RadioButton radiobutton2;
    @FXML
    private RadioButton radiobutton3;

    @FXML
    private void handleCheckBoxAction1() {
        if (radiobutton2.isSelected()) {
            radiobutton2.setSelected(false);
        }
        if (radiobutton3.isSelected()) {
            radiobutton3.setSelected(false);
        }
        if (radiobutton1.isSelected()) {
            type = Type.test;
        }
    }

    @FXML
    private void handleCheckBoxAction2() {
        if (radiobutton3.isSelected()) {
            radiobutton3.setSelected(false);
        }
        if (radiobutton1.isSelected()) {
            radiobutton1.setSelected(false);
        }
        if (radiobutton2.isSelected()) {
            type = Type.fill;
        }
    }

    @FXML
    private void handleCheckBoxAction3() {
        if (radiobutton1.isSelected()) {
            radiobutton1.setSelected(false);
        }
        if (radiobutton2.isSelected()) {
            radiobutton2.setSelected(false);
        }
        if (radiobutton3.isSelected()) {
            type = Type.connect;
        }
    }

    @FXML
    public void onChoose5() {
        border5.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border6.setStyle("-fx-border-width: 0");
        border7.setStyle("-fx-border-width: 0");
        number = 10;
    }

    @FXML
    public void onChoose6() {
        border6.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border7.setStyle("-fx-border-width: 0");
        border5.setStyle("-fx-border-width: 0");
        number = 20;
    }

    @FXML
    public void onChoose7() {
        border7.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border5.setStyle("-fx-border-width: 0");
        border6.setStyle("-fx-border-width: 0");
        number = 30;
    }

    @FXML
    public void startGame() throws IOException {
        Dictionary.children.close();
        switch (type) {
            case test: {
                FirstGameController.newFirstGame();
                Dictionary.showScene(Dictionary.window, "first-game.fxml");
                break;
            }
            case fill: {
                SecondGameController.newSecondGame();
                Dictionary.showScene(Dictionary.window, "second-game.fxml");
                break;
            }
            default: {
                ThirdGameController.newThirdGame();
                Dictionary.showScene(Dictionary.window, "third-game.fxml");
                break;
            }
        }
    }

    public static int getNumber() {
        return number;
    }
}
