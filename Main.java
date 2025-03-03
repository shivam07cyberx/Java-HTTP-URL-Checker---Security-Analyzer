import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter website URL (e.g., https://example.com): ");
        String url = scanner.nextLine();

        boolean isVulnerable = false;

        try {
            if (HttpHeaderAnalyzer.checkHeaders(url)) {
                isVulnerable = true;
            }
            if (SqlInjectionTester.checkSqlInjection(url)) {
                isVulnerable = true;
            }

            if (isVulnerable) {
                System.out.println("\n🚨 WARNING: Website might be vulnerable!");
            } else {
                System.out.println("\n✅ Website seems secure.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        scanner.close();
    }
}



// compole 1
// javac -d bin src/*.java

// compilke 2
// java -cp bin Main

