import com.example.oopproject.Entity.ArrangeWord;
import com.example.oopproject.Entity.Quiz;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WordGame {
    public enum Level {
        A1, A2, B1, B2
    }

    public static Quiz getDefinitionQuiz(Level level) {
        String levelString;
        switch (level) {
            case A1: {
                levelString = "a1";
                break;
            }
            case A2: {
                levelString = "a2";
                break;
            }
            case B1: {
                levelString = "b1";
                break;
            }
            default: {
                levelString = "b2";
                break;
            }
        }
        Quiz ans = new  Quiz();
        String apiUrl = "http://171.244.63.46/api/" + levelString + "/definitionQuiz";

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
                ans = objectMapper.readValue(response.toString(), Quiz.class);
            } else {
                System.out.println("API call failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
    public static Quiz getTargetQuiz(Level level) {
        String levelString;
        switch (level) {
            case A1: {
                levelString = "a1";
                break;
            }
            case A2: {
                levelString = "a2";
                break;
            }
            case B1: {
                levelString = "b1";
                break;
            }
            default: {
                levelString = "b2";
                break;
            }
        }
        Quiz ans = new  Quiz();
        String apiUrl = "http://171.244.63.46/api/" + levelString + "/targetQuiz";

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
                ans = objectMapper.readValue(response.toString(), Quiz.class);
            } else {
                System.out.println("API call failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
    public static ArrangeWord getArrangeGame(Level level) {
        String levelString;
        switch (level) {
            case A1: {
                levelString = "a1";
                break;
            }
            case A2: {
                levelString = "a2";
                break;
            }
            case B1: {
                levelString = "b1";
                break;
            }
            default: {
                levelString = "b2";
                break;
            }
        }
        ArrangeWord ans = new ArrangeWord();
        String apiUrl = "http://171.244.63.46/api/" + levelString + "/arrangeGame";

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
                ans = objectMapper.readValue(response.toString(), ArrangeWord.class);
            } else {
                System.out.println("API call failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
}
