package models;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversionRatesFinder {

    private static JsonObject conversionRates;

    public static JsonObject getConversionRates(Currency currency) throws IOException, InterruptedException {

        var url = new UrlBuilder().getRequestURI(currency.getBaseCode());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(url)
            .GET()
            .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        conversionRates = JsonParser.parseString(response.body())
            .getAsJsonObject()
            .getAsJsonObject("conversion_rates");

        return conversionRates;
    }

}
