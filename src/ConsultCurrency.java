
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConsultCurrency {
    private List<String> Iso;

    public ConsultCurrency() {
        Iso = new ArrayList<>();
        Iso.add("USD");
        Iso.add("ARS");
        Iso.add("BRL");
        Iso.add("COP");
        Iso.add("MXN");
        Iso.add("EUR");
        Iso.add("JPY");
    }

    public int getIsoListSize() {
        return Iso.size();
    }

    public List<String> getIso() {
        return Iso;
    }

    public CurrencyOmdb consultCurrency(int numberOne, int numberTwo, double value) {
        URI direction = URI.create("https://v6.exchangerate-api.com/v6/c7b1506819da710e960b6b96/pair/" + Iso.get(numberOne - 1) + "/" + Iso.get(numberTwo - 1));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direction)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new GsonBuilder().create();
            CurrencyOmdb currencyOmdb = gson.fromJson(json, CurrencyOmdb.class);

            ValorFinal currency = new ValorFinal(currencyOmdb, value);
            System.out.println();
            System.out.println(currency);
            System.out.println();

            return currencyOmdb;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
