package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String, String> headers){
        return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.loggInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.loggInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.loggInfoDetails("Request Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.loggInfoDetails("Request body is ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());

    }

    public static void printResponseLogInReport(Response response){
        ExtentReportManager.loggInfoDetails("Response Status is " + response.getStatusCode());
        ExtentReportManager.loggInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.loggInfoDetails("Response body is ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }

    public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers){
       RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
       Response response = requestSpecification.when().post();
       printRequestLogInReport(requestSpecification);
       printResponseLogInReport(response);
       return response;
    }
    public static Response performPost(String endPoint, Map<String, Object> requestPayload, Map<String, String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.when().post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }
    public static Response performPost(String endPoint, Object requestPayloadAsPojo, Map<String, String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayloadAsPojo, headers);
        Response response = requestSpecification.when().post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }
}
