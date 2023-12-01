import com.example.oopproject.Dictionary;
import com.example.oopproject.Query.WordGame;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

import static com.example.oopproject.MainController.ChoiceController.newChoice;

public class ChoicePickController {
    public enum Type {
        target, definition
    }

    @FXML
    public GridPane pattern;
    @FXML
    private BorderPane border1;
    @FXML
    private BorderPane border2;
    @FXML
    private BorderPane border3;
    @FXML
    private BorderPane border4;
    @FXML
    private BorderPane border5;
    @FXML
    private BorderPane border6;
    @FXML
    private BorderPane border7;
    @FXML
    private RadioButton radioButton1;

    @FXML
    private RadioButton radioButton2;
    private static Type type = Type.target;
    private static WordGame.Level level = WordGame.Level.A1;
    private static int number = 10;

    @FXML
    private void handleCheckBoxAction1() {
        if (radioButton2.isSelected()) {
            radioButton2.setSelected(false);
        }
        if (radioButton1.isSelected()) {
            type = Type.target;
        }
    }

    @FXML
    private void handleCheckBoxAction2() {
        if (radioButton1.isSelected()) {
            radioButton1.setSelected(false);
        }
        if (radioButton2.isSelected()) {
            type = Type.definition;
        }
    }

    @FXML
    public void onChoose1() {
        border1.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border2.setStyle("-fx-border-width: 0");
        border3.setStyle("-fx-border-width: 0");
        border4.setStyle("-fx-border-width: 0");
        level = WordGame.Level.A1;
    }

    @FXML
    public void onChoose2() {
        border2.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border3.setStyle("-fx-border-width: 0");
        border4.setStyle("-fx-border-width: 0");
        border1.setStyle("-fx-border-width: 0");
        level = WordGame.Level.A2;
    }

    @FXML
    public void onChoose3() {
        border3.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border4.setStyle("-fx-border-width: 0");
        border1.setStyle("-fx-border-width: 0");
        border2.setStyle("-fx-border-width: 0");
        level = WordGame.Level.B1;
    }

    @FXML
    public void onChoose4() {
        border4.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border1.setStyle("-fx-border-width: 0");
        border2.setStyle("-fx-border-width: 0");
        border3.setStyle("-fx-border-width: 0");
        level = WordGame.Level.B2;
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
    public void startChoice() throws IOException {
        Dictionary.children.close();
        newChoice();
        Dictionary.showScene(Dictionary.window, "choice.fxml");
    }

    public static WordGame.Level getLevel() {
        return level;
    }

    public static Type getType() {
        return type;
    }

    public static int getNumber() {
        return number;
    }
}
