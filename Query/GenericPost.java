import com.example.oopproject.Entity.MyString;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GenericPost {
    public static <T> MyString addAndEdit(String apiUrl, T t) {

        MyString ans = new MyString();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            String jsonBody = objectMapper.writeValueAsString(t);
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonBody.getBytes("UTF-8"));
            outputStream.flush();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

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

    public static MyString delete(String apiUrl) {
        MyString ans = new MyString();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

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
