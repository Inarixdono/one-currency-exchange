package models;

import io.github.cdimascio.dotenv.Dotenv;
import java.net.URI;

/**
 * The UrlBuilder class is responsible for constructing the URL for making currency conversion requests.
 * It takes an API key and uses it to replace placeholders in the URL template with actual values.
 */
public class UrlBuilder {
    private String url;
    private String apiKey;

    /**
     * Constructs a new UrlBuilder object.
     * Initializes the API key and URL template.
     */
    public UrlBuilder() {
        this.apiKey = getApiKey();
        this.url = "https://v6.exchangerate-api.com/v6/API_KEY/pair/currency/toConvert/amount";
    }

    /**
     * Retrieves the API key from the environment variables.
     *
     * @return The API key as a String.
     */
    private String getApiKey() {
        Dotenv dotenv = Dotenv.load();
        return dotenv.get("API_KEY");
    }

    /**
     * Constructs the request URI for currency conversion.
     *
     * @param from   The base currency to convert from.
     * @param to  The currency to convert to.
     * @return The URI object representing the request URL.
     */
    public URI getRequestURI(Currency from, Currency to) {
        var uri = URI.create(url.replace("API_KEY", apiKey)
                .replace("currency", from.getBaseCode())
                .replace("toConvert", to.getBaseCode())
                .replace("amount", String.valueOf(from.getAmount())));

        return uri;
    }
}
