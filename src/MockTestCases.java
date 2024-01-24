import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MockTestCases {

    @Test
    void testFetchData() throws Exception {
        String apiResponse = new filePather("C:\\Users\\ucskm\\OneDrive\\Desktop\\MockitoMockAPI\\src\\TestJsonFiles\\file.json").init().toString();
        HttpClient mockHttpClient = Mockito.mock(HttpClient.class);
        ApiCall apiService = new ApiCall(mockHttpClient, "https://example.com/api/data");

        String expectedResponse = apiResponse;

        // Create a mock response
        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);
        when(mockResponse.body()).thenReturn(apiResponse);

        when(mockHttpClient.send(any(), any())).thenReturn((HttpResponse) mockResponse);

        String url = "https://example.com/api/data";
        apiResponse = new ApiCall(mockHttpClient, url).getDataAPI();
        assertEquals(expectedResponse, apiResponse);
    }


    @Test
    void getNames() throws IOException, InterruptedException, URISyntaxException {
        String apiResponse = new filePather("C:\\Users\\ucskm\\OneDrive\\Desktop\\MockitoMockAPI\\src\\TestJsonFiles\\file.json").init().toString();
        HttpClient mockHttpClient = Mockito.mock(HttpClient.class);
        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);

        String expectedResponse = new filePather("C:\\Users\\ucskm\\OneDrive\\Desktop\\MockitoMockAPI\\src\\TestJsonFiles\\getNames.json").init().toString();

        // Create a mock response
        when(mockResponse.body()).thenReturn(apiResponse);
        when(mockHttpClient.send(any(), any())).thenReturn((HttpResponse) mockResponse);

        apiResponse = new ApiCall(mockHttpClient).getNames();
        assertEquals(expectedResponse,apiResponse);
    }

    @Test
    void nullData() throws IOException, URISyntaxException, InterruptedException {
        String apiResponse = null;
        HttpClient mockHttpClient = Mockito.mock(HttpClient.class);
        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);

        when(mockResponse.body()).thenReturn(apiResponse);
        when(mockHttpClient.send(any(), any())).thenReturn((HttpResponse) mockResponse);

        String url = "https://example.com/api/data";
        apiResponse = new ApiCall(mockHttpClient, url).getNames();
        assertEquals("[]",apiResponse);
    }

    @Test
    void EntityCount() throws IOException, InterruptedException, URISyntaxException {
        String apiResponse = new filePather("C:\\Users\\ucskm\\OneDrive\\Desktop\\MockitoMockAPI\\src\\TestJsonFiles\\file.json").init().toString();
        HttpClient mockHttpClient = Mockito.mock(HttpClient.class);


        // Create a mock response
        HttpResponse mockResponse = Mockito.mock(HttpResponse.class);
        when(mockResponse.body()).thenReturn(apiResponse);

        when(mockHttpClient.send(any(), any())).thenReturn((HttpResponse) mockResponse);

        String url = "https://example.com/api/data";
        apiResponse = new ApiCall(mockHttpClient, url).getEntityCount();
        assertEquals(6, Integer.parseInt(apiResponse));
    }


}
