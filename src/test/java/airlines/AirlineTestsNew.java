package airlines;

import airlines.pojos.Airline;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import restUtils.AssertionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AirlineTestsNew extends AirlinesAPIs{

    @Test
    public void createAirlineAndVerify(){
        Airline request = Payloads.getCreateAirlinePayloadFromPojo();
        Response response = createAirline(request);
        Map<String,Object> expectedValueMap = new HashMap<>();
        expectedValueMap.put("id", request.getId());
        expectedValueMap.put("name", request.getName()+"dddd");
        expectedValueMap.put("country", request.getCountry());
        expectedValueMap.put("logo", request.getLogo()+"kkkk");
        expectedValueMap.put("slogan", request.getSlogan());
        expectedValueMap.put("head_quaters", request.getHead_quaters());
        expectedValueMap.put("website", request.getWebsite());
        expectedValueMap.put("established", request.getEstablished());
        AssertionUtils.assertExpectedValuesWithJsonPath(response, expectedValueMap);

    }
}
