import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.Folder;
import com.example.oopproject.Entity.PersonalWord;
import com.example.oopproject.Entity.Topic;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.oopproject.Query.UserGet.*;

public class FolderController {
    @FXML
    public Label numberTopic;
    @FXML
    public Label dateCreate;
    @FXML
    public Label description;
    @FXML
    public Label name;
    @FXML
    public GridPane pattern1;
    @FXML
    public HBox hBox;
    @FXML
    private BorderPane gettopic;
    @FXML
    private VBox vbox;
    @FXML
    private GridPane pattern;
    @FXML
    BorderPane pane1;
    @FXML
    Label text1;
    @FXML
    Label text2;
    @FXML
    public BorderPane pane2;
    @FXML
    public Label text3;
    @FXML
    public Label text4;
    @FXML
    public Label text5;
    @FXML
    public Label text6;
    public static Folder folder;
    private boolean getTopic = false;

    private boolean[] booleanList;
    private static List<Topic> topicList;

    public static void newFolder(Folder folder) {
        FolderController.folder = folder;
    }

    public void initialize() {
        if (folder.getDescription().isEmpty()) {
            topicList = getDefaultTopic(folder.getId());
        } else {
            topicList = getTopic(folder.getId());
        }
        booleanList = new boolean[topicList.size()];
        if (folder.getDescription().isEmpty()) {
            name.setText(up(folder.getName()));
            numberTopic.setText("Number of topic : " + folder.getNumberList());
        } else {
            name.setText(up(folder.getName()));
            description.setText("Description : " + folder.getDescription());
            numberTopic.setText("Number of topic : " + folder.getNumberList());
            dateCreate.setText("Created : " + folder.getDateCreate());
        }
        for (int i = 0; i < topicList.size(); i++) {
            booleanList[i] = false;
            BorderPane borderPane = new BorderPane();
            borderPane.prefHeightProperty().bind(pattern1.heightProperty());
            borderPane.setPrefWidth(200);
            borderPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;");
            Label text1 = new Label(topicList.get(i).getName());
            VBox vBox = new VBox();
            Label text2 = new Label("Number of word : " + topicList.get(i).getNumberWord());
            Label text3 = new Label("Description : " + topicList.get(i).getDescription());
            text2.setVisible(false);
            text3.setVisible(false);
            vBox.getChildren().add(text2);
            vBox.getChildren().add(text3);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(20);
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(text1);
            stackPane.getChildren().add(vBox);
            borderPane.setCenter(stackPane);
            hBox.getChildren().add(borderPane);
            int finalI = i;
            borderPane.setOnMouseClicked(mouseEvent -> {
                if (getTopic) {
                    try {
                        TopicController.topic = topicList.get(finalI);
                        Dictionary.showScene(Dictionary.window, "topic.fxml");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                flip(borderPane, text1, text2, text3, booleanList[finalI]);
                booleanList[finalI] = !booleanList[finalI];
            });
            for (PersonalWord personalWord : getWord(topicList.get(i).getId())) {
                BorderPane borderPane1 = new BorderPane();
                borderPane1.prefWidthProperty().bind(pattern.widthProperty());
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
                Label label2 = new Label(topicList.get(i).getName());
                gridPane.add(label1, 1, 0);
                gridPane.add(label2, 1, 2);
                borderPane1.setCenter(gridPane);
                vbox.getChildren().add(borderPane1);
            }
        }
    }
    @FXML
    private void showTopic() {
        getTopic = !getTopic;
        if (getTopic) {
            gettopic.setBackground(Background.fill(Color.YELLOW));
        } else {
            gettopic.setBackground(Background.EMPTY);
        }
    }

    private static String up(String a) {
        StringBuilder b = new StringBuilder();
        b.append(Character.toUpperCase(a.charAt(0)));
        for (int i = 1; i < a.length(); i++) {
            b.append(a.charAt(i));
        }
        return b.toString();
    }

    public void showDictionary() throws IOException {
        Dictionary.showScene(Dictionary.window, "dictionary.fxml");
    }

    public void showLibrary() throws IOException {
        Dictionary.showScene(Dictionary.window, "library.fxml");
    }

    public void showMain() throws IOException {
        Dictionary.showScene(Dictionary.window, "main.fxml");
    }

    private void flip(BorderPane pane, Label textA, Label textB, Label textC, Boolean isBack) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.25), pane);
        rotateTransition.setAxis(Rotate.X_AXIS);
        rotateTransition.setByAngle(180);
        rotateTransition.play();
        if (!isBack) {
            textA.setVisible(false);
            textB.setVisible(true);
            textC.setVisible(true);
            textB.setScaleY(-1);
            textC.setScaleY(-1);
        } else {
            textA.setVisible(true);
            textB.setVisible(false);
            textB.setScaleY(1);
            textC.setVisible(false);
            textC.setScaleY(1);
        }
    }



    @FXML
    public void showAddTopic() throws IOException {
        Dictionary.newStage("add-topic.fxml");
    }
    @FXML
    public void showEditFolder() throws IOException {
        Dictionary.newStage("edit-folder.fxml");
    }
    @FXML
    public void showDeleteFolder() throws IOException {
        Dictionary.newStage("delete-folder.fxml");
    }
}
