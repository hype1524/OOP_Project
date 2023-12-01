import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.PersonalWord;
import com.example.oopproject.Query.UserAdd;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddWordController {
    @FXML
    private Button create;
    @FXML
    private Label result;
    @FXML
    private TextField target;

    @FXML
    private TextField definition;
    @FXML
    private void addWord() {
        PersonalWord personalWord = new PersonalWord();
        personalWord.setTopicId(TopicController.topic.getId());
        personalWord.setTarget(target.getText());
        personalWord.setDefinition(definition.getText());
        create.setText("Return");
        result.setText(UserAdd.addWord(personalWord).getString());
        create.setOnMouseClicked(mouseEvent -> {
            try {
                Dictionary.children.close();
                Dictionary.showScene(Dictionary.window, "topic.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    public void setButton() {
        create.setDisable(target.getText().isEmpty());
    }
}
