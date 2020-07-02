package API.HomeWork.AkchaBar;

import API.Pojo.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Babki {

    @Test
    public void home2() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("rates.akchabar.kg");
        uriBuilder.setPath("get.json");//http://rates.akchabar.kg/get.json

        HttpGet httpGet= new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse response= client.execute(httpGet);
        ObjectMapper mapper = new ObjectMapper();

        DateAkcha jok = mapper.readValue(response.getEntity().getContent(),DateAkcha.class);

        System.out.println(jok.getRates().getBtc());

    }
}
