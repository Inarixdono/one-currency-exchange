package models;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonParser;

public class Exchanger {

    private double conversionResult;

    public void converTo(Currency from, Currency to) throws IOException, InterruptedException {

        var url = new UrlBuilder().getRequestURI(from, to);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        conversionResult = JsonParser.parseString(response.body())
                .getAsJsonObject()
                .get("conversion_result")
                .getAsDouble();

        to.setAmount(conversionResult);
    }
}