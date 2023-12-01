import com.example.oopproject.Dictionary;
import com.example.oopproject.Entity.User;
import com.example.oopproject.Query.LoginAndRegister;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class RegisterController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField rePassword;
    @FXML
    private void register() throws IOException {
        if (!password.getText().equals(rePassword.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("!");
            alert.setHeaderText("Register failed");
            alert.setContentText("The two passwords do not match!");
            alert.showAndWait();
        }
        else {
            User user = new User();
            user.setUsername(username.getText());
            user.setPassword(password.getText());
            user.setDateCreate(LocalDate.now());
            if (LoginAndRegister.register(user).getString().equals("Registration successful!")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("!");
                alert.setHeaderText("Registration successful!");
                alert.setContentText("Please login!");
                alert.showAndWait();
                Dictionary.showScene(Dictionary.window, "login.fxml");
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("!");
                alert.setHeaderText("Register failed");
                alert.setContentText("Username already exists!");
                alert.showAndWait();
            }
        }
    }
    @FXML
    public void showLogin() throws IOException {
        Dictionary.showScene(Dictionary.window, "login.fxml");
    }
}
