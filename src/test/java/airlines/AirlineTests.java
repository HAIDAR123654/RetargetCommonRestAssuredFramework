package airlines;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;

public class AirlineTests extends AirlinesAPIs{
    @Test
    public void createAirline() throws IOException {
         Map<String, Object> payload = Payloads.getCreateAirlinePayloadFromMap();
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
