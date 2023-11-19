import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkShortener {
    private Map<String, String> shortToLongMap;
    private Map<String, String> longToShortMap;
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;

    public LinkShortener() {
        shortToLongMap = new HashMap<>();
        longToShortMap = new HashMap<>();
    }

    public String shortenLink(String longUrl) {
        if (longToShortMap.containsKey(longUrl)) {
            return longToShortMap.get(longUrl);
        }

        String shortUrl = generateShortUrl();
        shortToLongMap.put(shortUrl, longUrl);
        longToShortMap.put(longUrl, shortUrl);
        return shortUrl;
    }

    public String getLongUrl(String shortUrl) {
        return shortToLongMap.get(shortUrl);
    }

    private String generateShortUrl() {
        StringBuilder shortUrl = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            shortUrl.append(CHARACTERS.charAt(randomIndex));
        }

        return shortUrl.toString();
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        String longUrl = "https://www.example.com";
        String shortUrl = linkShortener.shortenLink(longUrl);

        System.out.println("Original URL: " + longUrl);
        System.out.println("Shortened URL: " + shortUrl);

        String retrievedUrl = linkShortener.getLongUrl(shortUrl);
        System.out.println("Retrieved URL: " + retrievedUrl);
    }
}
