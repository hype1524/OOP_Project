import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.Folder;
import com.example.oopproject.Entity.Topic;
import com.example.oopproject.Query.UserGet;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.IOException;

import static com.example.oopproject.Query.UserGet.getDefaultFolder;

public class LibraryController {
    @FXML
    private GridPane pattern;
    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;
    @FXML
    private GridPane pattern1;
    public void initialize() {
        addFolder();
        addTopic();
    }
    @FXML
    private void showDictionary() throws IOException {
        Dictionary.showScene(Dictionary.window, "dictionary.fxml");
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
    private void showAddFolder() throws IOException {
        Dictionary.newStage("add-folder.fxml");
    }
    @FXML
    private void showDeleteFolder() {

    }

    private void addFolder() {
        for (Folder folder : UserGet.getFolder(MainController.getUserId())) {
            BorderPane borderPane = new BorderPane();
            borderPane.prefWidthProperty().bind(pattern1.widthProperty());
            borderPane.setPrefHeight(80);
            borderPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;");
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
            Label label1 = new Label(folder.getName());
            Label label2 = new Label("Created : " + folder.getTimeCreate() + " " + folder.getDateCreate());
            gridPane.add(label1, 1, 0);
            gridPane.add(label2, 1, 2);
            borderPane.setCenter(gridPane);
            borderPane.setOnMouseClicked(mouseEvent -> {
                FolderController.newFolder(folder);
                try {
                    Dictionary.showScene(Dictionary.window, "folder.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            vbox1.getChildren().add(borderPane);
        }
    }

    private void addTopic() {
        for (Topic topic : UserGet.getAllTopic(MainController.getUserId())) {
            BorderPane borderPane = new BorderPane();
            borderPane.prefWidthProperty().bind(pattern.widthProperty());
            borderPane.setPrefHeight(80);
            borderPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;");
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
            Label label1 = new Label(topic.getName());
            Label label2 = new Label("Created : " + topic.getTimeCreate() + " " + topic.getDateCreate());
            gridPane.add(label1, 1, 0);
            gridPane.add(label2, 1, 2);
            borderPane.setCenter(gridPane);
            borderPane.setOnMouseClicked(mouseEvent -> {
                TopicController.topic = topic;
                try {
                    Dictionary.showScene(Dictionary.window, "topic.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            vbox2.getChildren().add(borderPane);
        }
    }
}
