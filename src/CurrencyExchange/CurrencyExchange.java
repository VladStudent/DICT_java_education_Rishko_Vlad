package CurrencyExchange;

import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyExchange {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter currency code (example: USD, EUR, ILS): ");
        String code = scanner.next().toLowerCase();

        String link = "http://www.floatrates.com/daily/" + code + ".json";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(link)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject obj = new JSONObject(response.body());

        if (obj.has("usd")) {
            System.out.println("USD rate: " + obj.getJSONObject("usd").getDouble("rate"));
        }
        if (obj.has("eur")) {
            System.out.println("EUR rate: " + obj.getJSONObject("eur").getDouble("rate"));
        }
    }
}
