import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 12032016 on 05.03.2017.
 */
public class HtmlHandler {

    public StringBuilder handleWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();

        URL targetUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) targetUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Chrome/41.02228.0");

        return getWebPage(connection);
    }

    private StringBuilder getWebPage(HttpURLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder result = new StringBuilder();
        String nextString;

        while ((nextString = reader.readLine()) != null) {
            result.append(nextString.toLowerCase());
        }
        return getBody(result);
    }

    private StringBuilder getBody(StringBuilder htmlDocument) {
        int openBodyTag = htmlDocument.indexOf("<body");
        int closeBodyTag = htmlDocument.indexOf("</body>");

        return new StringBuilder(htmlDocument.substring(openBodyTag, closeBodyTag));
    }
}
