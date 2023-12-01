import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.FillSentence;
import com.example.oopproject.Query.SentenceGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecondGameController {
    @FXML
    private Button submit;
    @FXML
    private TextField text;
    @FXML
    private Button nextQuestion;
    @FXML
    private Label question;
    @FXML
    private Label answer;

    private static List<FillSentence> fillSentenceList = new ArrayList<>();

    private static int number;
    private static int count;
    private static int correct;
    private boolean showAnswer = false;

    public static void newSecondGame() {
        fillSentenceList = new ArrayList<>();
        count = 0;
        number = GameController.getNumber();
        correct = 0;
        fillSentenceList = SentenceGame.getListFillSentence(number);
    }

    public void initialize() {
        setQuestion();
    }
    private void setQuestion() {
        question.setText(fillSentenceList.get(count).getSentence());
        answer.setText(fillSentenceList.get(count).getFill());
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
    private void showAnswer() {
        if (showAnswer) {
            return;
        }
        if (count == number - 1) {
            nextQuestion.setText("Result");
            submit.setVisible(false);

            nextQuestion.setOnMouseClicked(mouseEvent -> {
                question.setText("Number of correct answer: " + correct);
                answer.setVisible(false);
                nextQuestion.setText("Play again?");
                nextQuestion.setOnMouseClicked(mouseEvent1 -> {
                    try {
                        Dictionary.newStage("game.fxml");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            });
        }
        if (fillSentenceList.get(count).getFill().equals(answer.getText())) {
            correct++;
        }
        answer.setVisible(true);
        nextQuestion.setVisible(true);
        text.setEditable(false);
    }

    @FXML
    private void showNextQuestion() {
        count++;
        nextQuestion.setVisible(false);
        answer.setVisible(false);
        text.setEditable(true);
        showAnswer = false;
        setQuestion();
    }

}
