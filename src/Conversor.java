import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Conversor {
    // Método para convertir monedas usando HttpClient
    public static void convertirMoneda(String fromCurrency, String toCurrency, double cantidad) {
        try {
            String apiKey = "3db4876af057b19768302585";  // Tu clave de API
            String apiURL = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + fromCurrency;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiURL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parsear la respuesta con Gson
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            double tasaDeCambio = jsonObject
                    .getAsJsonObject("conversion_rates")
                    .get(toCurrency)
                    .getAsDouble();

            double resultado = cantidad * tasaDeCambio;
            System.out.printf("%.2f %s equivalen a %.2f %s%n", cantidad, fromCurrency, resultado, toCurrency);

        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
        }
    }
}