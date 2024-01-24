package AI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.net.URI;
import java.net.URISyntaxException;

import org.json.JSONArray;
import org.json.JSONObject;

public class Gemini {
    static private String APIKEY = "AIzaSyDDC9cvGBYQPjbspS_FRGqL8JKD3S9jPHE";
    static private String URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=" + Gemini.APIKEY;
    static private String PROMPT = """
            You are a very good, friendly, thoughful doctor with many years of experience.
            You have to give good advise to patient.
            Just give advise, dont ask anything else. Only response if patient ask about health, disease, if user ask about another domain (not healthcare) you MUST response that you dont know about it.
            RESPONSE AS HUMAN, BE FRIENDLY
            Below is message from patient: \n
            """;
    static public String getResponse(String text) {
        String output = "";
        try {
            URI uri = new URI(Gemini.URL);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String question = Gemini.PROMPT + text;

            String jsonData = "{\r\n" + //
                    "      \"contents\": [{\r\n" + //
                    "        \"parts\":[{\r\n" + //
                    "          \"text\": \"" + question + "\"}]}]}";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            // Read the response from the server
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                JSONObject jsonObject = new JSONObject(response.toString());
                System.out.println(jsonObject);
                JSONArray candidatesArray = jsonObject.getJSONArray("candidates");
                JSONObject firstCandidate = candidatesArray.getJSONObject(0);
                JSONObject content = firstCandidate.getJSONObject("content");
                JSONArray parts = content.getJSONArray("parts");
                JSONObject firstPart = parts.getJSONObject(0);
                output = firstPart.getString("text");
            }
            connection.disconnect();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            output = "Sorry! Doctors are busy :(";
        }
        return output;
    }
}
