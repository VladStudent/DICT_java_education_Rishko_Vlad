package CurrencyExchange;

import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyExchange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Double> cache = new HashMap<>();

        System.out.print("Enter your base currency: ");
        String base = scanner.next().toLowerCase();

        cache.put("usd", loadRate(base, "usd"));
        cache.put("eur", loadRate(base, "eur"));

        while (true) {
            System.out.print("\nEnter currency to exchange (empty = stop): ");
            String target = scanner.next().toLowerCase();

            if (target.isEmpty()) break;

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            System.out.println("Checking the cache...");

            if (cache.containsKey(target)) {
                System.out.println("It is in the cache!");
                double res = amount * cache.get(target);
                System.out.printf("You received %.2f %s\n", res, target.toUpperCase());
            } else {
                System.out.println("Sorry, but it is not in the cache!");
                double rate = loadRate(base, target);
                cache.put(target, rate);
                double res = amount * rate;
                System.out.printf("You received %.2f %s\n", res, target.toUpperCase());
            }
        }
    }

    private static double loadRate(String base, String target) {
        try {
            String link = "http://www.floatrates.com/daily/" + base + ".json";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(link)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject obj = new JSONObject(response.body());

            if (!obj.has(target)) return 0;

            return obj.getJSONObject(target).getDouble("rate");

        } catch (Exception e) {
            return 0;
        }
    }
}
