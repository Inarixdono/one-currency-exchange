package models;

import io.github.cdimascio.dotenv.Dotenv;
import java.net.URI;

public class UrlBuilder {
    private String url;
    private String apiKey;

    public UrlBuilder() {
        this.apiKey = getApiKey();  
        this.url = "https://v6.exchangerate-api.com/v6/API_KEY/pair/currency/toConvert/amount";      
    }

    private String getApiKey() {
        Dotenv dotenv = Dotenv.load();
        return dotenv.get("API_KEY");
    }

    public URI getRequestURI(Currency currency, Currency toConvert) {
        var uri = URI.create(url.replace("API_KEY", apiKey)
            .replace("currency", currency.getBaseCode())
            .replace("toConvert", toConvert.getBaseCode())
            .replace("amount", String.valueOf(currency.getRate())));
        
        System.out.println(uri);
        return uri;
    }

}
