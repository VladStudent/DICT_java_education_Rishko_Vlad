package WebPageScraper;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WebPageScraper {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the URL: ");
        String url = sc.nextLine();

        Connection.Response response;

        try {
            response = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .execute();
        } catch (IOException e) {
            System.out.println("The URL returned error!");
            return;
        }

        int status = response.statusCode();

        if (status != 200) {
            System.out.println("The URL returned " + status + "!");
            return;
        }

        byte[] data = response.bodyAsBytes();

        try (FileOutputStream fos = new FileOutputStream("source.html")) {
            fos.write(data);
        }

        System.out.println("Content saved.");
    }
}
