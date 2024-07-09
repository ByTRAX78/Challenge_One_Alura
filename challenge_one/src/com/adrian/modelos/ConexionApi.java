package com.adrian.modelos;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {

    public ValoresActualesDeModena buscarConversor (String conversor) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI url = URI.create("https://v6.exchangerate-api.com/v6/489369abc22f9db417802d26/latest/" +  conversor);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            JsonObject conversionRatesJson = jsonObject.getAsJsonObject("conversion_rates");

            double usd = conversionRatesJson.get("USD").getAsDouble();
            double ars = conversionRatesJson.get("ARS").getAsDouble();
            double brl = conversionRatesJson.get("BRL").getAsDouble();
            double cop = conversionRatesJson.get("COP").getAsDouble();
            double mxn = conversionRatesJson.get("MXN").getAsDouble();
            ValoresActualesDeModena valores = new ValoresActualesDeModena(usd, ars, brl, cop, mxn);

            return valores;

        }catch (Exception e){
            throw new RuntimeException("Algo salio mal en la petición");

        }



    }
}
