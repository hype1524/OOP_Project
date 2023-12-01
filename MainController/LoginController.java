import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.MyInt;
import com.example.oopproject.Entity.User;
import com.example.oopproject.Query.LoginAndRegister;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.oopproject.MainController.MainController.setUserId;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private void login() throws IOException {
        User user = new User();
        user.setUsername(username.getText());
        user.setPassword(password.getText());

        MyInt userId = LoginAndRegister.login(user);
        if (userId.getId() == -1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("!");
            alert.setHeaderText("Login failed");
            alert.setContentText("Check your username or password");
            alert.showAndWait();
        } else {
            setUserId(userId);
            Dictionary.showScene(Dictionary.window, "main.fxml");
        }
    }

    @FXML
    private void showRegister() throws IOException {
        Dictionary.showScene(Dictionary.window, "register.fxml");
    }
}
