import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TextToSpeech {

    public static void convertTextToSpeech(String text, String language)
            throws IOException {
        String encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8);
        String url = "https://translate.google.com/translate_tts?ie=UTF-8&q="
                + encodedText + "&tl=" + language + "&client=tw-ob";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            try (InputStream inputStream = connection.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(
                         "C:\\Users\\Laptop\\IdeaProjects\\OOPProject\\output.mp3")) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        } else {
            System.out.println("Error: " + connection.getResponseCode());
        }

        connection.disconnect();
    }
}
