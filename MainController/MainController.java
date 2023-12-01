import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.Folder;
import com.example.oopproject.Entity.MyInt;
import com.example.oopproject.Entity.Topic;
import com.example.oopproject.Query.UserGet;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

import static com.example.oopproject.Query.UserGet.getDefaultFolder;

public class MainController {
    @FXML
    private VBox vbox;
    @FXML
    private VBox vbox2;
    @FXML
    private GridPane pattern;
    private static MyInt userId;

    public List<Folder> folderList;
    public List<Topic> topicList;

    public static void setUserId(MyInt userId) {
        MainController.userId = userId;
    }

    public static int getUserId() {
        return userId.getId();
    }

    public List<Folder> getFolderList() {
        return folderList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void showLibrary() throws IOException {
        Dictionary.showScene(Dictionary.window, "library.fxml");
    }

    public void showDictionary() throws IOException {
        Dictionary.showScene(Dictionary.window, "dictionary.fxml");
    }

    public void showGame() throws IOException {
        Dictionary.newStage("game.fxml");
    }

    @FXML
    private void initialize() {
        addFolder();
        addTopic();
        folderList = UserGet.getFolder(userId.getId());
        topicList = UserGet.getAllTopic(userId.getId());
    }
    private void addFolder() {
        BorderPane defaultFolder = new BorderPane();
        defaultFolder.prefWidthProperty().bind(pattern.widthProperty());
        defaultFolder.setPrefHeight(100);
        defaultFolder.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;");
        Label label = new Label("Default");
        defaultFolder.setCenter(label);
        defaultFolder.setOnMouseClicked(mouseEvent -> {
            Folder myDefaultFolder = getDefaultFolder(userId.getId());
            myDefaultFolder.setName("Default Folder");
            myDefaultFolder.setDescription("");
            FolderController.newFolder(myDefaultFolder);
            try {
                Dictionary.showScene(Dictionary.window, "folder.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        vbox.getChildren().add(defaultFolder);
        for (Folder folder : UserGet.getFolder(userId.getId())) {
            BorderPane borderPane = new BorderPane();
            borderPane.prefWidthProperty().bind(pattern.widthProperty());
            borderPane.setPrefHeight(100);
            borderPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;");
            Label label1 = new Label(folder.getName());
            borderPane.setCenter(label1);
            borderPane.setOnMouseClicked(mouseEvent -> {
                FolderController.newFolder(folder);
                try {
                    Dictionary.showScene(Dictionary.window, "folder.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            vbox.getChildren().add(borderPane);
        }
        BorderPane createFolder = new BorderPane();
        createFolder.prefWidthProperty().bind(pattern.widthProperty());
        createFolder.setPrefHeight(100);
        createFolder.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;");
        Label label2 = new Label("Create new folder");
        createFolder.setCenter(label2);
        createFolder.setOnMouseClicked(mouseEvent -> {
            try {
                Dictionary.newStage("add-folder.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        vbox.getChildren().add(createFolder);
    }

    private void addTopic() {
        for (Topic topic : UserGet.getAllTopic(userId.getId())) {
            BorderPane borderPane = new BorderPane();
            borderPane.prefWidthProperty().bind(pattern.widthProperty());
            borderPane.setPrefHeight(100);
            borderPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;");
            Label label1 = new Label(topic.getName());
            borderPane.setCenter(label1);
            borderPane.setOnMouseClicked(mouseEvent -> {
                TopicController.newTopic(topic);
                try {
                    Dictionary.showScene(Dictionary.window, "topic.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            vbox2.getChildren().add(borderPane);
        }
        BorderPane createFolder = new BorderPane();
        createFolder.prefWidthProperty().bind(pattern.widthProperty());
        createFolder.setPrefHeight(100);
        createFolder.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;");
        Label label2 = new Label("Create new topic");
        createFolder.setCenter(label2);
        createFolder.setOnMouseClicked(mouseEvent -> {
            try {
                Dictionary.newStage("add-topic.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        vbox2.getChildren().add(createFolder);
    }
}
