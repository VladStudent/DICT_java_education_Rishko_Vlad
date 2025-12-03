package WebPageScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileOutputStream;
import java.io.IOException;

public class WebPageScraper {

    public static void main(String[] args) throws IOException {

        String url = "https://www.nature.com/nature/articles?sort=PubDate&year=2023&page=2";

        Document doc = Jsoup.connect(url).get();
        Elements articles = doc.select("article");

        for (Element article : articles) {

            Element typeSpan = article.selectFirst("span[data-test='article.type']");
            if (typeSpan == null) continue;

            String type = typeSpan.text();

            if (!type.equalsIgnoreCase("News")) continue;

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

            try (FileOutputStream fos = new FileOutputStream(safeName)) {
                fos.write(body.text().getBytes("UTF-8"));
            }

            System.out.println("Saved: " + safeName);
        }
    }
}
