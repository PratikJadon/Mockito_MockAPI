import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;

public class filePather {
    String path = "";
    ObjectMapper objectMapper;

    public filePather(String path){
        this.path = path;
        this.objectMapper = new ObjectMapper();
    }

    public JsonNode init() throws IOException {
        return objectMapper.readTree(new File(this.path));
    }
}
