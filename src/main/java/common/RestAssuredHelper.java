package common;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import java.util.Map;

public class RestAssuredHelper {

    public static ExtractableResponse<Response> callGetApi(String url, Map<String, String> paramMap, Map<String, String> headerMap){
        ExtractableResponse<Response> response = RestAssured.given().log().all().headers(headerMap).parameters(paramMap).when().get(url).then().log().all().extract();
        return response;
    }

    // Will implement this method when we learn about post api. Concentrate on above method as of now.
    public static ExtractableResponse<Response> callPostApi(){
        ExtractableResponse<Response> response = null;
        return response;
    }
}
