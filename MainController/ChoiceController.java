import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.Quiz;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.oopproject.Query.WordGame.*;

public class ChoiceController {
    @FXML
    public GridPane grid;
    @FXML
    public GridPane pattern;
    @FXML
    public GridPane pattern1;
    @FXML
    public GridPane pattern2;
    @FXML
    public GridPane pattern3;

    @FXML
    private Button nextQuestion;
    @FXML
    private Button submit;
    @FXML
    private Label question;
    @FXML
    private Label a;
    @FXML
    private Label b;
    @FXML
    private Label c;
    @FXML
    private Label d;
    @FXML
    private BorderPane aBorder;
    @FXML
    private BorderPane bBorder;
    @FXML
    private BorderPane cBorder;
    @FXML
    private BorderPane dBorder;
    private static ChoicePickController.Type type;

    private static List<Quiz> quizList = new ArrayList<>();
    private static int number;
    private static int count;
    private static int correct;

    private boolean showAnswer = false;
    private int choose = -1;

    public static void newChoice() {
        quizList = new ArrayList<>();
        count = 0;
        number = ChoicePickController.getNumber();
        type = ChoicePickController.getType();
        correct = 0;
        if (Objects.requireNonNull(type) == ChoicePickController.Type.target) {
            quizList
                    .add(getTargetQuiz(ChoicePickController
                            .getLevel()));
        } else {
            quizList
                    .add(getDefinitionQuiz(ChoicePickController
                            .getLevel()));
        }
    }

    @FXML
    public void initialize() {
        setQuestion();
    }

    private void setQuestion() {
        question.setText(quizList.get(count).getQuestion());
        a.setText(quizList.get(count).getA());
        b.setText(quizList.get(count).getB());
        c.setText(quizList.get(count).getC());
        d.setText(quizList.get(count).getD());
    }

    @FXML
    public void showDictionary() throws IOException {
        Dictionary.showScene(Dictionary.window, "dictionary.fxml");
    }

    @FXML
    public void showLibrary() throws IOException {
        Dictionary.showScene(Dictionary.window, "library.fxml");
    }

    @FXML
    public void showGame() throws IOException {
        Dictionary.newStage("game.fxml");
    }

    @FXML
    public void showMain() throws IOException {
        Dictionary.showScene(Dictionary.window, "main.fxml");
    }

    @FXML
    public void chooseA() {
        if (showAnswer) {
            return;
        }
        aBorder.setBackground(Background.fill(Color.YELLOW));
        bBorder.setBackground(Background.EMPTY);
        cBorder.setBackground(Background.EMPTY);
        dBorder.setBackground(Background.EMPTY);
        choose = 0;
    }

    @FXML
    public void chooseB() {
        if (showAnswer) {
            return;
        }
        bBorder.setBackground(Background.fill(Color.YELLOW));
        cBorder.setBackground(Background.EMPTY);
        dBorder.setBackground(Background.EMPTY);
        aBorder.setBackground(Background.EMPTY);
        choose = 1;
    }

    @FXML
    public void chooseC() {
        if (showAnswer) {
            return;
        }
        cBorder.setBackground(Background.fill(Color.YELLOW));
        dBorder.setBackground(Background.EMPTY);
        aBorder.setBackground(Background.EMPTY);
        bBorder.setBackground(Background.EMPTY);
        choose = 2;
    }

    @FXML
    public void chooseD() {
        if (showAnswer) {
            return;
        }
        dBorder.setBackground(Background.fill(Color.YELLOW));
        aBorder.setBackground(Background.EMPTY);
        bBorder.setBackground(Background.EMPTY);
        cBorder.setBackground(Background.EMPTY);
        choose = 3;
    }

    @FXML
    public void showAnswer() {
        if (showAnswer) {
            return;
        }
        switch (choose) {
            case 0: {
                aBorder.setBackground(Background.fill(Color.RED));
                break;
            }
            case 1: {
                bBorder.setBackground(Background.fill(Color.RED));
                break;
            }
            case 2: {
                cBorder.setBackground(Background.fill(Color.RED));
                break;
            }
            case 3: {
                dBorder.setBackground(Background.fill(Color.RED));
                break;
            }
            default: {
                break;
            }
        }
        switch (quizList.get(count).getAnsPosition()) {
            case 0: {
                aBorder.setBackground(Background.fill(Color.GREEN));
                break;
            }
            case 1: {
                bBorder.setBackground(Background.fill(Color.GREEN));
                break;
            }
            case 2: {
                cBorder.setBackground(Background.fill(Color.GREEN));
                break;
            }
            default: {
                dBorder.setBackground(Background.fill(Color.GREEN));
                break;
            }
        }
        if (count == number - 1) {
            nextQuestion.setText("Result");
            submit.setVisible(false);

            nextQuestion.setOnMouseClicked(mouseEvent -> {
                question.setText("Number of correct answer: " + correct);
                a.setText("");
                b.setText("");
                c.setText("");
                d.setText("");
                aBorder.setBackground(Background.EMPTY);
                bBorder.setBackground(Background.EMPTY);
                cBorder.setBackground(Background.EMPTY);
                dBorder.setBackground(Background.EMPTY);
                nextQuestion.setText("Play again?");
                nextQuestion.setOnMouseClicked(mouseEvent1 -> {
                    try {
                        Dictionary.newStage("choice-pick.fxml");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            });
        }
        if (choose == quizList.get(count).getAnsPosition()) {
            correct++;
        }
        showAnswer = true;
        nextQuestion.setVisible(true);
    }

    @FXML
    public void showNextQuestion() {
        aBorder.setBackground(Background.EMPTY);
        bBorder.setBackground(Background.EMPTY);
        cBorder.setBackground(Background.EMPTY);
        dBorder.setBackground(Background.EMPTY);
        if (Objects.requireNonNull(type) == ChoicePickController.Type.target) {
            quizList
                    .add(getTargetQuiz(ChoicePickController
                            .getLevel()));
        } else {
            quizList
                    .add(getDefinitionQuiz(ChoicePickController
                            .getLevel()));
        }
        count++;
        setQuestion();
        nextQuestion.setVisible(false);
        showAnswer = false;
        choose = -1;
    }
}
