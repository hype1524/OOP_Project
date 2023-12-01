import com.example.oopproject.Entity.Folder;
import com.example.oopproject.Entity.MyInt;
import com.example.oopproject.Entity.MyString;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectWord {
    public static MyString getWord(String word) {
        MyString ans = new MyString();
        String apiUrl = "http://171.244.63.46/api/connect/" + word;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper objectMapper = new ObjectMapper();

                objectMapper.registerModule(new JavaTimeModule());
                ans = objectMapper.readValue(response.toString(), MyString.class);
            } else {
                System.out.println("API call failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
}
