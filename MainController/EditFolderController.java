import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.Folder;
import com.example.oopproject.Query.UserEdit;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class EditFolderController {
    @FXML
    private TextField name;

    @FXML
    private TextField description;
    @FXML
    private Label result;
    @FXML
    private Button edit;

    @FXML
    private void editFolder() {
        Folder folder = new Folder();
        folder.setName(name.getText());
        folder.setDescription(description.getText());
        folder.setUserId(1);
        folder.setDateCreate(LocalDate.now());
        folder.setTimeCreate(LocalTime.now());
        result.setText(UserEdit.editFolder(FolderController.folder.getId(), folder).getString());
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
    private void setButton() {
        edit.setDisable(name.getText().isEmpty());
    }
}
