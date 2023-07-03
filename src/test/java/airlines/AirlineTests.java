package airlines;
import airlines.pojos.Airline;
import airlines.pojos.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class AirlineTests extends AirlinesAPIs{
//    @Test
//    public void createAirline() throws IOException {
//        Airline payload = Payloads.getCreateAirlinePayloadFromPojo();
//        Airline payload = new Airline();
//        Airline payload = Airline.builder().name("testing").build();
//        Airline payload = new Airline().toBuilder().build();
//        Response response = createAirline(payload);
//        Assert.assertEquals(response.statusCode(), 200);
//        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(payload));
//    }
        @Test
       public void createAirlineAndVerifyResponse() throws IOException {
            Airline payload = new Airline();
            Response response = createAirline(payload);
            Assert.assertEquals(response.jsonPath().getString("name"),payload.getName());
            ObjectMapper objectMapper = new ObjectMapper();
            Airline createAirlineResponse = objectMapper.readValue(response.getBody().asString(),Airline.class);
            Assert.assertEquals(createAirlineResponse, payload);
        }
}
