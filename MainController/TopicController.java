import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.PersonalWord;
import com.example.oopproject.Entity.Topic;
import com.example.oopproject.Query.UserGet;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

import static com.example.oopproject.Query.UserGet.getWord;

public class TopicController {
    @FXML
    private VBox vbox;
    @FXML
    private HBox hBox;
    @FXML
    private Label name;
    @FXML
    private Label description;
    @FXML
    private GridPane pattern1;
    @FXML
    private Label numberWord;
    @FXML
    private Label dateCreate;

    public static Topic topic;
    public static List<PersonalWord> wordList;
    private boolean[] booleanList;
    public static void newTopic(Topic topic) {
        TopicController.topic = topic;
    }
    private static String up(String a) {
        StringBuilder b = new StringBuilder();
        b.append(Character.toUpperCase(a.charAt(0)));
        for (int i = 1; i < a.length(); i++) {
            b.append(a.charAt(i));
        }
        return b.toString();
    }

    @FXML
    public void initialize() {
        wordList = UserGet.getWord(topic.getId());

        booleanList = new boolean[wordList.size()];

        name.setText(up(topic.getName()));
        description.setText("Description : " + topic.getDescription());
        numberWord.setText("Number of topic : " + topic.getNumberWord());
        dateCreate.setText("Created : " + topic.getDateCreate());

        for (int i = 0; i < wordList.size(); i++) {
            booleanList[i] = false;
            BorderPane borderPane = new BorderPane();
            borderPane.prefHeightProperty().bind(pattern1.heightProperty());
            borderPane.setPrefWidth(200);
            borderPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;");
            Label text1 = new Label(wordList.get(i).getTarget());
            VBox vBox = new VBox();
            Label text2 = new Label("Definition : " + wordList.get(i).getDefinition());
            text2.setVisible(false);
            vBox.getChildren().add(text2);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(20);
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(text1);
            stackPane.getChildren().add(vBox);
            borderPane.setCenter(stackPane);
            hBox.getChildren().add(borderPane);
            int finalI = i;
            borderPane.setOnMouseClicked(mouseEvent -> {
                flip(borderPane, text1, text2, booleanList[finalI]);
                booleanList[finalI] = !booleanList[finalI];
            });
            for (PersonalWord personalWord : getWord(wordList.get(i).getId())) {
                BorderPane borderPane1 = new BorderPane();
                borderPane1.prefWidthProperty().bind(pattern1.widthProperty());
                borderPane1.setPrefHeight(80);
                borderPane1.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;");
                GridPane gridPane = new GridPane();
                ColumnConstraints col1 = new ColumnConstraints();
                col1.setPercentWidth(10);
                ColumnConstraints col2 = new ColumnConstraints();
                col2.setPercentWidth(90);
                gridPane.getColumnConstraints().addAll(col1, col2);

                RowConstraints row1 = new RowConstraints();
                row1.setPercentHeight(40);
                RowConstraints row2 = new RowConstraints();
                row2.setPercentHeight(20);
                RowConstraints row3 = new RowConstraints();
                row3.setPercentHeight(40);
                gridPane.getRowConstraints().addAll(row1, row2, row3);
                Label label1 = new Label(personalWord.getTarget());
                Label label2 = new Label(wordList.get(i).getDefinition());
                gridPane.add(label1, 1, 0);
                gridPane.add(label2, 1, 2);
                borderPane1.setCenter(gridPane);
                vbox.getChildren().add(borderPane1);
            }
        }
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
    public void showMain() throws IOException {
        Dictionary.showScene(Dictionary.window, "main.fxml");

    }

    @FXML
    public void showChoice() throws IOException {
        Dictionary.newStage("choice-pick.fxml");
    }

    @FXML
    public void showArrangePick() throws IOException {
        Dictionary.newStage("arrange-pick.fxml");
    }

    @FXML
    public void showGame() throws IOException {
        Dictionary.newStage("game.fxml");
    }

    private void flip(BorderPane pane, Label textA, Label textB, Boolean isBack) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.25), pane);
        rotateTransition.setAxis(Rotate.X_AXIS);
        rotateTransition.setByAngle(180);
        rotateTransition.play();
        if (!isBack) {
            textA.setVisible(false);
            textB.setVisible(true);
            textB.setScaleY(-1);
        } else {
            textA.setVisible(true);
            textB.setVisible(false);
            textB.setScaleY(1);
        }
    }

    @FXML
    private void showAddWord() throws IOException {
        Dictionary.newStage("add-word.fxml");
    }

    @FXML
    private void showEditTopic() throws IOException {
        Dictionary.newStage("edit-topic.fxml");
    }
    @FXML
    private void showDeleteTopic() throws IOException {
        Dictionary.newStage("delete-topic.fxml");
    }
}
