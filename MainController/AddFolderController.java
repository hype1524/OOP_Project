import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.Folder;
import com.example.oopproject.Query.UserAdd;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddFolderController {
    @FXML
    private Button create;
    @FXML
    private Label result;
    @FXML
    private TextField name;

    @FXML
    private TextField description;
    @FXML
    private void addFolder() {
        Folder folder = new Folder();
        folder.setName(name.getText());
        folder.setDescription(description.getText());
        folder.setUserId(MainController.getUserId());
        folder.setDateCreate(LocalDate.now());
        folder.setTimeCreate(LocalTime.now());
        result.setText(UserAdd.addFolder(folder).getString());
        create.setText("Return");
        create.setOnMouseClicked(mouseEvent -> {
            try {
                Dictionary.children.close();
                Dictionary.showScene(Dictionary.window, "library.fxml");
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
