import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
public class EmailClient {
    private static final String SERVER_URL = "http://localhost:8080/send-email";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("=== Email Client Started ===");
        System.out.println("Type 'exit' in the 'Name' field to quit.\n");

        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) break;

            System.out.print("Vendor (@vendor.com): ");
            String mailPostfix = scanner.nextLine().trim();

            System.out.print("Body: ");
            String body = scanner.nextLine().trim();

            System.out.print("To: ");
            String to = scanner.nextLine().trim();

            String json = String.format(
                "{\"name\":\"%s\", \"mailPostfix\":\"%s\", \"body\":\"%s\", \"to\":\"%s\"}",
                name, mailPostfix, body, to.replace("\"", "\\\"")
            );
            sendEmail(json, client);
        }
        scanner.close();
        System.out.println("💤 Client exited.");

    }
    private static void sendEmail(String jsonPayload, HttpClient client) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(SERVER_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200 || response.statusCode() == 201) {
                System.out.println("✅ Email sent successfully.");
            } else {
                System.out.printf("❌ Failed. Status: %d\nResponse: %s\n", response.statusCode(), response.body());
            }
        } catch (Exception e) {
            System.err.println("💥 Error: " + e.getMessage());
        }
    }
}
