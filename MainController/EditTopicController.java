import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.Folder;
import com.example.oopproject.Entity.Topic;
import com.example.oopproject.Query.UserEdit;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class EditTopicController {
    @FXML
    private TextField name;

    @FXML
    private TextField description;
    @FXML
    private Label result;
    @FXML
    private Button edit;

    @FXML
    private void editTopic() {
        Topic topic = new Topic();
        topic.setName(name.getText());
        topic.setDescription(description.getText());
        topic.setFolderId(1);
        topic.setDateCreate(LocalDate.now());
        topic.setTimeCreate(LocalTime.now());
        result.setText(UserEdit.editTopic(FolderController.folder.getId(), topic).getString());
        edit.setText("Return");
        edit.setOnMouseClicked(mouseEvent -> {
            try {
                Dictionary.children.close();
                Dictionary.showScene(Dictionary.window, "library.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    @FXML
    private void setbutton() {
        edit.setDisable(name.getText().isEmpty());
    }
}
