import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.ArrangeWord;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.oopproject.Query.WordGame.getArrangeGame;

public class ArrangeController {

    @FXML
    public GridPane out;
    @FXML
    public Pane scroll;
    @FXML
    public GridPane pattern;
    @FXML
    public GridPane pattern1;
    @FXML
    public GridPane pattern2;
    @FXML
    public GridPane pattern3;
    @FXML
    public GridPane pattern4;
    @FXML
    private VBox vbox;
    @FXML
    private Label answer;
    @FXML
    private Label hint;
    @FXML
    private Button nextQuestion;
    @FXML
    private Label question;
    @FXML
    private TextField textField;
    private static List<ArrangeWord> arrangeWordList = new ArrayList<>();
    private static int number;
    private static int count;

    public static void newArrange() {
        arrangeWordList = new ArrayList<>();
        count = 0;
        number = ArrangePickController.getNumber();
        arrangeWordList
                .add(getArrangeGame(ArrangePickController
                        .getLevel()));
    }

    @FXML
    private void initialize() {
        vbox.setAlignment(Pos.CENTER);
        question.setText(arrangeWordList.get(count).getShuffleWord());
        hint.setText(arrangeWordList.get(count).getTargetWord().getDefinition());
    }

    @FXML
    private void showDictionary() throws IOException {
        Dictionary.showScene(Dictionary.window, "dictionary.fxml");
    }

    @FXML
    private void showLibrary() throws IOException {
        Dictionary.showScene(Dictionary.window, "library.fxml");
    }

    @FXML
    private void showGame() throws IOException {
        Dictionary.newStage("game.fxml");
    }

    @FXML
    private void showMain() throws IOException {
        Dictionary.showScene(Dictionary.window, "main.fxml");
    }

    @FXML
    private void showHint() {
        if (hint.isVisible()) {
            return;
        }
        hint.setVisible(true);
    }

    @FXML
    private void showAnswer() {
        if (answer.isVisible()) {
            return;
        }
        hint.setVisible(true);
        answer.setText(arrangeWordList.get(count).getTargetWord().getTarget());
        answer.setVisible(true);
        nextQuestion.setVisible(true);
        count++;
        if (count == number) {
            nextQuestion.setText("Play again?");

            nextQuestion.setOnMouseClicked(mouseEvent -> {
                try {
                    Dictionary.newStage("arrange-pick.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @FXML
    private void showNextQuestion() {
        answer.setVisible(false);
        nextQuestion.setVisible(false);
        hint.setVisible(false);
        textField.clear();
        arrangeWordList
                .add(getArrangeGame(ArrangePickController
                        .getLevel()));
        question.setText(arrangeWordList.get(count).getShuffleWord());
        hint.setText(arrangeWordList.get(count).getTargetWord().getDefinition());
    }
}
