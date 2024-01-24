### README for `ApiCall` Class

**ApiCall Class**

The `ApiCall` class is designed to make API calls using Java's `HttpClient`, process JSON responses using Jackson's `ObjectMapper`, and provide methods for fetching data from an API.

#### Usage

1. **Initialization:**
   - Create an instance of `ApiCall` by providing an instance of `HttpClient` and an optional URL.
   ```java
   HttpClient httpClient = HttpClient.newHttpClient();
   ApiCall api = new ApiCall(httpClient, "https://example.com/api/data");
   ```

2. **Fetching Data:**
   - Call methods such as `getDataAPI()`, `getNames()`, or `getEntityCount()` to retrieve data from the API.

3. **Testing:**
   - Use JUnit and Mockito for testing. See `MockTestCases` class for examples.

#### Example

```java
public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
    HttpClient httpClient = HttpClient.newHttpClient();
    ApiCall api = new ApiCall(httpClient, "https://example.com/api/data");
    String result = api.getNames();
    System.out.println(result);
}
```

### README for `MockTestCases` Class

**MockTestCases Class**

The `MockTestCases` class contains JUnit test cases using Mockito for testing the `ApiCall` class. It includes tests for fetching data, handling null responses, and verifying entity counts.

#### Usage

1. **Test Cases:**
   - Three test cases are provided: `testFetchData()`, `getNames()`, `nullData()`, and `EntityCount()`.

2. **Mocking HTTP Responses:**
   - Mockito is used to mock the `HttpClient` and simulate HTTP responses.

3. **Running Tests:**
   - Execute the test cases using JUnit.

#### Example

```java
@Test
void testFetchData() throws Exception {
    // ... test setup and assertions ...
}

@Test
void getNames() throws IOException, InterruptedException, URISyntaxException {
    // ... test setup and assertions ...
}

@Test
void nullData() throws IOException, URISyntaxException, InterruptedException {
    // ... test setup and assertions ...
}

@Test
void EntityCount() throws IOException, InterruptedException, URISyntaxException {
    // ... test setup and assertions ...
}
```

Feel free to customize these README files based on your specific project structure and requirements.
