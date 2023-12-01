import com.example.oopproject.Entity.MyString;
import com.example.oopproject.MainController.DictionaryController;
import com.example.oopproject.Query.BaseWord;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Dictionary extends Application {
    public static Stage window;
    public static Stage children;

    @Override
    public void start(Stage stage) throws IOException {

        window = stage;
        showScene(window, "login.fxml");
    }

    public static void main(String[] args) {

        Thread a = new Thread(() -> {
            for (MyString word : BaseWord.getAllWord()) {
                DictionaryController.addWord(word);
            }
        });
        a.start();
        launch();
    }

    public static void showScene(Stage stage, String sceneFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Dictionary.class.getResource(sceneFile));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);

        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public static void newStage(String sceneFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Dictionary.class.getResource(sceneFile));
        Scene scene = new Scene(fxmlLoader.load(), 300, 400);
        Stage newWindow = new Stage();
        newWindow.setTitle("Dictionary");
        newWindow.setScene(scene);

        newWindow.initOwner(window);
        newWindow.initModality(Modality.WINDOW_MODAL);

        newWindow.show();
        children = newWindow;
    }
}