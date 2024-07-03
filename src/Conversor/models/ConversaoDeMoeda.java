package Conversor.models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConversaoDeMoeda {
    String key = System.getenv("apiKey");
    @SerializedName("base_code")
    String countryCoin;
    @SerializedName("target_code")
    String convertedCountryCoin;
    @SerializedName("conversion_rate")
    double taxCoin;
    @SerializedName("conversion_result")
    double convertedValue;

    public String getCountryCoin() {
        return countryCoin;
    }

    public String getConvertedCountryCoin() {
        return convertedCountryCoin;
    }

    public double getTaxCoin() {
        return taxCoin;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public void conversao(String originCoin, String convertedCoin,  double value) throws IOException, InterruptedException {
        String endereco = "https://v6.exchangerate-api.com/v6/"+key+"/pair/"+ originCoin +"/"+ convertedCoin +"/"+ value;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        try {
            Gson gson = new Gson();
            ConversaoDeMoeda moeda = gson.fromJson(json, ConversaoDeMoeda.class);
            System.out.println("O valor " + value + " " + originCoin + ", convertido em " + convertedCoin + " é de: ");
            System.out.println(moeda.getConvertedValue());
        }catch (Exception e){
            System.out.println("Aconteceu algun erro.");
        }
    }
}
