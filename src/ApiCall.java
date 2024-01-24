import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ApiCall {
    private HttpClient httpClient;
    private String url;
    private ObjectMapper objectMapper;

    public ApiCall(HttpClient httpClient, String url) {
        this.url = url;
        this.httpClient = httpClient;
        this.objectMapper = new ObjectMapper();
    }

    public ApiCall(HttpClient httpClient) {
        this.url = "http://temp/";
        this.httpClient = httpClient;
        this.objectMapper = new ObjectMapper();
    }

    private String sendRequest() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(url)).build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String result = response.body();
        if (result == null) {
            result = String.valueOf(objectMapper.createObjectNode().put("", ""));
        }
        return result;
    }

    public String getDataAPI() throws IOException, InterruptedException, URISyntaxException {
        return this.sendRequest();
    }

    public String getNames() throws IOException, URISyntaxException, InterruptedException {

        JsonNode jsonnode = objectMapper.readTree(sendRequest()).get("value");

        List<JsonNode> nameObj = new ArrayList<>();
        if (jsonnode != null && jsonnode.isArray()) {
            for (JsonNode o : jsonnode) {
                nameObj.add(objectMapper.createObjectNode().put("name", o.get("name").asText()));
            }
        }
        return objectMapper.writeValueAsString(nameObj);
    }

    public String getEntityCount() throws IOException, URISyntaxException, InterruptedException {

        JsonNode jsonnode = objectMapper.readTree(sendRequest()).get("value");

        Integer count = 0;
        if (jsonnode != null && jsonnode.isArray()) {
            for (JsonNode o : jsonnode) {
                count++;
            }
        }
        return count.toString();
    }

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        HttpClient httpClient_ = HttpClient.newHttpClient();
        ApiCall api = new ApiCall(httpClient_, "https://services.odata.org/V4/(S(adslzk2deqsbc23y5au0xrwk))/TripPinServiceRW/");
        String result = api.getNames();
//        System.out.println(result);
    }
}
