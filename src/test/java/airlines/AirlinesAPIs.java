package airlines;

import io.restassured.response.Response;
import restUtils.RestUtils;
import java.util.HashMap;
import java.util.Map;

public class AirlinesAPIs {
    public Response createAirline(Map<String, Object> createAirlinePayload){
        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndPoint");
        return RestUtils.performPost(endPoint, createAirlinePayload,new HashMap<>());
    }
}
