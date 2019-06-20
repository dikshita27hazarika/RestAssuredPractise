package common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import java.util.Map;

public class RestAssuredHelper {

    public static ExtractableResponse<Response> callGetApi(String url, Map<String, String> paramMap, Map<String, String> headerMap){
        ExtractableResponse<Response> response = RestAssured.given().log().all().headers(headerMap).parameters(paramMap).when().get(url).then().log().all().extract();
       return response.statusCode() == 200 ? response : null;
    }


    public static ExtractableResponse<Response> callPostApi(String url, Map<String, String> paramMap, Map<String, String> headerMap, Object requestBody){
        ExtractableResponse<Response> response = null;
        try {
            if (requestBody == null){
                response = RestAssured.given().log().all().headers(headerMap).parameters(paramMap).when().post(url).then().log().all().extract();
            } else {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.convertValue(requestBody, JsonNode.class);
                String body = mapper.writeValueAsString(jsonNode);
                response = RestAssured.given().log().all().headers(headerMap).parameters(paramMap).body(body).when().post(url).then().log().all().extract();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static ExtractableResponse<Response> callPutApi(String url, Map<String, String> paramMap, Map<String, String> headerMap, Object requestBody){
        ExtractableResponse<Response> response = null;
        try {
            if (requestBody == null) {
                response = RestAssured.given().log().all().headers(headerMap).parameters(paramMap).when().put(url).then().log().all().extract();
            } else {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.convertValue(requestBody, JsonNode.class);
                String body = mapper.writeValueAsString(jsonNode);
                response = RestAssured.given().log().all().headers(headerMap).parameters(paramMap).body(body).when().put(url).then().log().all().extract();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
