import com.example.oopproject.Dictionary;
import com.example.oopproject.Query.ConnectWord;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThirdGameController {
    private static Set<String> play = new HashSet<>();
    @FXML
    private TextField text;
    @FXML
    private Button send;
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox vbox;
    @FXML
    private GridPane grid;
    private static String preWord;

    public static void newThirdGame() {
        play = new HashSet<>();
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

    private void addWord(String a) {
        BorderPane borderPane = new BorderPane();
        borderPane.prefWidthProperty().bind(grid.widthProperty());
        borderPane.setPrefHeight(100);
        borderPane.setStyle(" -fx-border-color: black; -fx-border-radius: 5; -fx-border-width: 2");
        Label label = new Label(a);
        borderPane.setCenter(label);
        vbox.getChildren().add(borderPane);
        ScheduledService<Void> service = new ScheduledService<>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<>() {
                    @Override
                    protected Void call() {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                        return null;
                    }
                };
            }
        };

        service.setOnSucceeded(event -> Platform.runLater(() -> scroll.setVvalue(1.0)));
        service.setDelay(Duration.millis(500));
        service.start();
        play.add(a);
    }

    @FXML
    private void sendWord() {
        if (ConnectWord.getWord(text.getText()) == null) {
            addWord("Your word isn't exist!");
            text.clear();
            send.setDisable(true);
            return;
        }
        if (preWord != null && preWord.charAt(preWord.length() - 1) != text.getText().charAt(0)) {
            addWord("Your word isn't match!");
            text.clear();
            send.setDisable(true);
            return;
        }
        if (play.contains(text.getText())) {
            addWord("Your word is already used!");
            text.clear();
            send.setDisable(true);
            return;
        }
        addWord(text.getText());
        preWord = ConnectWord.getWord(text.getText()).getString();
        while (preWord.length() > 15) {
            preWord = ConnectWord.getWord(text.getText()).getString();
        }
        text.clear();
        send.setDisable(true);
        addWord(preWord);
    }

    @FXML
    private void setButton() {
        send.setDisable(text.getText().length() < 3);
    }
}
