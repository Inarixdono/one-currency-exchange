package models;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonParser;

/**
 * The Exchanger class represents a currency exchanger that converts currency from one type to another.
 */
public class Exchanger {

    private double conversionResult;

    /**
     * Converts the specified amount of currency from one type to another.
     *
     * @param from The currency to convert from.
     * @param to The currency to convert to.
     * @throws IOException If an I/O error occurs while making the HTTP request.
     * @throws InterruptedException If the thread is interrupted while waiting for the HTTP response.
     */
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
