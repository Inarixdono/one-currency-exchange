package models;

import io.github.cdimascio.dotenv.Dotenv;
import java.net.URI;

public class UrlBuilder {
    private String url;
    private String apiKey;

    public UrlBuilder() {
        this.apiKey = getApiKey();  
        this.url = "https://v6.exchangerate-api.com/v6/API_KEY/latest/CURRENCY";      
    }

    private String getApiKey() {
        Dotenv dotenv = Dotenv.load();
        return dotenv.get("API_KEY");
    }

    public URI getRequestURI(String currency) {
        return URI.create(url.replace("API_KEY", apiKey).replace("CURRENCY", currency));
    }

    public String getUrl(String currency) {
        return url.replace("API_KEY", String.valueOf(apiKey)).replace("CURRENCY", currency);
    }

    public String hi() {
        return apiKey;
    }    
}
