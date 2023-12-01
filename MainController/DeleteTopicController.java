import com.example.oopproject.Dictionary;
import com.example.oopproject.Query.UserDelete;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class DeleteTopicController {
    @FXML
    private Button yes;
    @FXML
    private Label result;
    @FXML
    private void no() throws IOException {
        Dictionary.showScene(Dictionary.window, "topic.fxml");
    }
    @FXML
    private void yes(){
        result.setText(UserDelete.deleteFolder(TopicController.topic.getId()).getString());
        yes.setText("Return");
        yes.setOnMouseClicked(mouseEvent -> {
            try {
                Dictionary.children.close();
                Dictionary.showScene(Dictionary.window, "library.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
