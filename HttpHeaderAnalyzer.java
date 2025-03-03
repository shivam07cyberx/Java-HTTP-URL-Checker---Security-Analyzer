import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpHeaderAnalyzer {
    public static boolean checkHeaders(String url) throws Exception {
        URL siteUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) siteUrl.openConnection();
        connection.setRequestMethod("GET");

        System.out.println("\n🔹 Checking HTTP Headers...");
        Map<String, List<String>> headers = connection.getHeaderFields();
        boolean isVulnerable = false;

        if (!headers.containsKey("X-Frame-Options")) {
            System.out.println("⚠️ Missing X-Frame-Options header (Clickjacking risk)");
            isVulnerable = true;
        }
        if (!headers.containsKey("Content-Security-Policy")) {
            System.out.println("⚠️ Missing Content-Security-Policy header (XSS risk)");
            isVulnerable = true;
        }
        if (!headers.containsKey("Strict-Transport-Security")) {
            System.out.println("⚠️ Missing Strict-Transport-Security (HSTS) header");
            isVulnerable = true;
        }

        return isVulnerable;
    }
}
