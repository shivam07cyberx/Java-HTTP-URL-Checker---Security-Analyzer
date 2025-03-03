import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SqlInjectionTester {
    public static boolean checkSqlInjection(String url) {
        String testUrl = url + "?id=1' OR '1'='1";
        boolean isVulnerable = false;

        try {
            System.out.println("\n🔹 Testing SQL Injection...");
            URL siteUrl = new URL(testUrl);
            HttpURLConnection connection = (HttpURLConnection) siteUrl.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response;

            while ((response = reader.readLine()) != null) {
                if (response.contains("error in your SQL syntax") || response.contains("mysql_fetch")) {
                    System.out.println("🚨 SQL Injection Vulnerability Found at: " + testUrl);
                    isVulnerable = true;
                    break;
                }
            }
            reader.close();

        } catch (Exception e) {
            System.out.println("❌ Error testing SQL Injection: " + e.getMessage());
        }

        return isVulnerable;
    }
}
