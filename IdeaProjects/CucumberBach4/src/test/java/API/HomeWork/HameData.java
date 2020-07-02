package API.HomeWork;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class HameData {

    @Test
    public void hameWork1() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("swapi.dev");
        uriBuilder.setPath("/api/starships");

        HttpGet httpGet= new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","application/json");

        HttpResponse response= client.execute(httpGet);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES,false);
        Count des = mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true)
                .readValue(response.getEntity().getContent(),Count.class);
        System.out.println(des.getResults().get(0).getEdited());
    }


}
