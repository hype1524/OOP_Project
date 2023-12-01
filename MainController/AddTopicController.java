import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.Topic;
import com.example.oopproject.Query.UserAdd;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddTopicController {
    @FXML
    private Button create;
    @FXML
    private Label result;
    @FXML
    private TextField name;

    @FXML
    private TextField description;
    @FXML
    private void addTopic() {
        Topic topic = new Topic();
        topic.setName(name.getText());
        topic.setDescription(description.getText());
        topic.setFolderId(FolderController.folder.getId());
        topic.setDateCreate(LocalDate.now());
        topic.setTimeCreate(LocalTime.now());
        result.setText(UserAdd.addTopic(topic).getString());
        create.setText("Return");
        create.setOnMouseClicked(mouseEvent -> {
            try {
                Dictionary.children.close();
                Dictionary.showScene(Dictionary.window, "folder.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    public void setButton() {
        create.setDisable(name.getText().isEmpty());
    }
}
