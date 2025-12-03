package WebPageScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WebPageScraper {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter pages count: ");
        int pages = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter article type: ");
        String typeInput = sc.nextLine();

        for (int i = 1; i <= pages; i++) {

            String url = "https://www.nature.com/nature/articles?sort=PubDate&year=2023&page=" + i;

            Document doc = Jsoup.connect(url).get();
            Elements articles = doc.select("article");

            File folder = new File("Page_" + i);
            folder.mkdir();

            for (Element article : articles) {

                Element typeSpan = article.selectFirst("span[data-test='article.type']");
                if (typeSpan == null) continue;

                String articleType = typeSpan.text();

                if (!articleType.equalsIgnoreCase(typeInput)) continue;

                Element link = article.selectFirst("a[data-track-action='view article']");
                if (link == null) continue;

                String articleUrl = "https://www.nature.com" + link.attr("href");

                Document articleDoc = Jsoup.connect(articleUrl).get();

                Element body = articleDoc.selectFirst("div[class*=body]");
                if (body == null) continue;

                String title = articleDoc.selectFirst("title").text();

                String safeName = title
                        .replaceAll("[^a-zA-Z0-9 ]", "")
                        .replace(" ", "_") + ".txt";

                File outFile = new File(folder, safeName);

                try (FileOutputStream fos = new FileOutputStream(outFile)) {
                    fos.write(body.text().getBytes("UTF-8"));
                }

                System.out.println("Saved: " + folder.getName() + "/" + safeName);
            }
        }

        System.out.println("Saved all articles");
    }
}
