import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.MyString;
import com.example.oopproject.Entity.Trie;
import com.example.oopproject.Entity.Word;
import com.example.oopproject.Query.BaseWord;
import com.example.oopproject.Query.TextToSpeech;
import com.example.oopproject.Query.Translate;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.TextFlow;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryController {
    private MediaPlayer mediaPlayer;
    private Media media;

    @FXML
    private VBox vbox;
    @FXML
    private Label target;
    @FXML
    private Button translate;
    @FXML
    private TextArea textarea;
    @FXML
    private Label result;
    @FXML
    private Button find;
    @FXML
    private TextField text;
    @FXML
    private GridPane pattern;
    public boolean hasText = false;
    public static Trie wordList = new Trie();

    public void initialize() {
    }

    public static void addWord(MyString word) {
        wordList.add(word.getString());
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
    public void setButton1() {
        translate.setDisable(textarea.getText().isEmpty());
    }

    @FXML
    public void translate() {
        MyString a = new MyString();
        a.setString(textarea.getText());
        String t = Translate.translate(a).getString();
        if (t.isEmpty()) {
            result.setText(textarea.getText());
        } else {
            result.setText(t);
        }
    }
    @FXML
    private void find() {
        Word word = BaseWord.getWord(text.getText());
        if (word == null) {
            target.setText("Word not found!");
        } else {
            vbox.getChildren().clear();
            target.setText(word.getTarget());
            String[] definition = word.getDefinition().split("\n\t");
            for (int i = 0; i < definition.length; i++) {
                Label label = new Label(definition[i]);
                vbox.getChildren().add(label);
            }
        }
    }

    @FXML
    private void setButton2() throws IOException {
        find.setDisable(text.getText().isEmpty());
        if (!text.getText().isEmpty()) {
            vbox.getChildren().clear();
            int count = 0;
            for (String s : wordList.keysWithPrefix(text.getText())) {
                if (count == 50) {
                    break;
                }
                BorderPane borderPane = new BorderPane();
                borderPane.prefWidthProperty().bind(pattern.widthProperty());
                borderPane.setPrefHeight(100);
                borderPane.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-border-radius: 5px;");
                Label label = new Label(s);
                borderPane.setCenter(label);
                borderPane.setOnMouseClicked(mouseEvent -> {
                    text.setText(s);
                });
                vbox.getChildren().add(borderPane);
                count++;
            }
            TextToSpeech.convertTextToSpeech(text.getText(), "en");
            String mp3File = "C:\\Users\\Laptop\\IdeaProjects\\OOPProject\\output.mp3";
            media = new Media(new File(mp3File).toURI().toString());
        }
    }

    @FXML
    private void showSpeech() throws IOException {
        if (text.getText().isEmpty()) {
            return;
        }

        // Khởi tạo đối tượng MediaPlayer với Media
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
