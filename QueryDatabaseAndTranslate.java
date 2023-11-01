package DatabaseAndTranslate;

import BasicComponent.Word;
import Handle.HandleData;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QueryDatabaseAndTranslate {
    public static List<String> queryKeyDictionary(String key) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        String query = "SELECT * FROM dictionary WHERE target like \""
                + key + "%\"";

        List<String> ans = new ArrayList<>();

        Statement stm;
        try {
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                String target = rs.getString("target");
                ans.add(target);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }

    public static Word queryWordDictionary(String wordTarget) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        String query = "SELECT * FROM dictionary WHERE target = \""
                + wordTarget + "\"";

        Statement stm;
        Word word = null;
        try {
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(query);

            rs.next();

            String target = rs.getString("target");
            String definition = HandleData
                    .handle(rs.getString("definition"));
            word = new Word(target, definition);

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return word;
    }

    public static Word queryWordGame(int id) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        String query = "SELECT * FROM dictionary WHERE id = \""
                + id + "\"";

        Statement stm;
        Word word = null;
        try {
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(query);

            rs.next();

            String target = rs.getString("target");
            String definition = HandleData
                    .handle(rs.getString("definition"));
            word = new Word(target, definition);

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return word;
    }

    public static String translate(String word)
            throws IOException, GeneralSecurityException {
        Translate t = new Translate.Builder(
                GoogleNetHttpTransport.newTrustedTransport()
                , GsonFactory.getDefaultInstance(), null)
                .setApplicationName("Stackoverflow-Example")
                .build();
        Translate.Translations.List list = t.new Translations().list(
                Collections.singletonList(
                        word),
                "VI");

        // TODO: Set your API-Key from https://console.developers.google.com/
        list.setKey("AIzaSyBlVORDZnQ4enZk-KJ5xuVF2wx5rk-lcK0");
        TranslationsListResponse translationsListResponse = list.execute();
        return translationsListResponse
                .getTranslations().get(0).getTranslatedText();
    }

}
