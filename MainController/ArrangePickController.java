import com.example.oopproject.Dictionary;
import com.example.oopproject.Query.WordGame;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

import static com.example.oopproject.MainController.ArrangeController.newArrange;

public class ArrangePickController {
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
    private static WordGame.Level level = WordGame.Level.A1;
    private static int number = 10;

    @FXML
    private void onChoose1() {
        border1.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border2.setStyle("-fx-border-width: 0");
        border3.setStyle("-fx-border-width: 0");
        border4.setStyle("-fx-border-width: 0");
        level = WordGame.Level.A1;
    }

    @FXML
    private void onChoose2() {
        border2.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border3.setStyle("-fx-border-width: 0");
        border4.setStyle("-fx-border-width: 0");
        border1.setStyle("-fx-border-width: 0");
        level = WordGame.Level.A2;
    }

    @FXML
    private void onChoose3() {
        border3.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border4.setStyle("-fx-border-width: 0");
        border1.setStyle("-fx-border-width: 0");
        border2.setStyle("-fx-border-width: 0");
        level = WordGame.Level.B1;
    }

    @FXML
    private void onChoose4() {
        border4.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border1.setStyle("-fx-border-width: 0");
        border2.setStyle("-fx-border-width: 0");
        border3.setStyle("-fx-border-width: 0");
        level = WordGame.Level.B2;
    }

    @FXML
    private void onChoose5() {
        border5.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border6.setStyle("-fx-border-width: 0");
        border7.setStyle("-fx-border-width: 0");
        System.out.println(number);
        number = 10;
    }

    @FXML
    private void onChoose6() {
        border6.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border7.setStyle("-fx-border-width: 0");
        border5.setStyle("-fx-border-width: 0");
        System.out.println(number);
        number = 20;
    }

    @FXML
    private void onChoose7() {
        border7.setStyle("-fx-border-color: blue; -fx-border-width: 1");
        border5.setStyle("-fx-border-width: 0");
        border6.setStyle("-fx-border-width: 0");
        System.out.println(number);
        number = 30;
    }

    @FXML
    private void startArrange() throws IOException {
        Dictionary.children.close();
        newArrange();
        Dictionary.showScene(Dictionary.window, "arrange.fxml");
    }

    public static int getNumber() {
        return number;
    }

    public static WordGame.Level getLevel() {
        return level;
    }
}
